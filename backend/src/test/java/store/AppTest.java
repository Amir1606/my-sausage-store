package store;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testProductList() {
        List<String> expected = Arrays.asList(
            "Сосиска говяжья",
            "Сарделька свиная",
            "Колбаса копчёная",
            
        );

        List<String> actual = App.getProducts();
        assertEquals("Список продуктов не совпадает", expected, actual);
    }
}
