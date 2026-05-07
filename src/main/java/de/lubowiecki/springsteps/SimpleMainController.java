package de.lubowiecki.springsteps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// Controller sind Komponenten, die vom Spring-Container verwaltet werden
@RestController
@RequestMapping("/api")
public class SimpleMainController {

    @GetMapping("") // http://localhost:8080/api/
    public String showHello() {
        return "Moin Moin!";
    }

    @GetMapping("/products") // http://localhost:8080/api/products
    public List<Product> showProducts() {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Tasse, rot", "Keramik. Ganz toll", 100, 3.99));
        products.add(new Product("Tasse, gelb", "Keramik. Ganz toll", 100, 3.99));
        products.add(new Product("Tasse, blau", "Keramik...", 20, 7.99));
        products.add(new Product("Mütze", "100% Wolle", 15, 19.99));
        return products;
    }
}
