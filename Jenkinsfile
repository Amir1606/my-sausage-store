pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *')
    }

    tools {
        maven 'Maven-3'
        jdk   'jdk-17'
    }

  
    environment {
        BOT_TOKEN = credentials('telegram-bot-token')
        CHAT_ID   = credentials('telegram-chat-id')
    }	


    stages {
        stage('Build backend') {
            steps {
                dir('backend') {
                    sh 'mvn package'
                }
            }
        }
        stage('Build frontend') {
            steps {
                dir('frontend') {
                    sh 'npm install && npm run build'
                }
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'backend/target/*.jar'
            sh '''
              curl -X POST https://api.telegram.org/bot${BOT_TOKEN}/sendMessage \
                   -d chat_id=${CHAT_ID} \
                   -d text="✅ Сборка прошла успешно!"
            '''
        }
        failure {
            sh '''
              curl -X POST https://api.telegram.org/bot${BOT_TOKEN}/sendMessage \
                   -d chat_id=${CHAT_ID} \
                   -d text="❌ Сборка упала!"
            '''
        }
    }
}
