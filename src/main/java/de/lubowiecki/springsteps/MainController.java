package de.lubowiecki.springsteps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    private List<Product> products;

    public MainController() {
        products = new ArrayList<>();
        products.add(new Product(1, "Mütze", "100% Wolle", 19.99));
        products.add(new Product(2, "Handschuhe", "100% Wolle", 29.99));
        products.add(new Product(3, "Tasse, blau", "Keramik", 7.29));
    }

    @GetMapping("/hallo")
    public String halloWelt() {
        return "<h1>Hallo Spring</h1>";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/products/{id}")
    public Product getOneProduct(@PathVariable int id) {
        return products.get(id - 1);
    }
}
