package store;

import java.util.Arrays;
import java.util.List;

public class App {
    public static List<String> getProducts() {
        return Arrays.asList(
            "Сосиска говяжья",
            "Сарделька свиная",
            "Колбаса копчёная"
        );
    }

    public static void main(String[] args) {
        System.out.println("Sausage Store запущен!");
        getProducts().forEach(System.out::println);
    }
}
