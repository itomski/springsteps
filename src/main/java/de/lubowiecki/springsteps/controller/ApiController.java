package de.lubowiecki.springsteps.controller;

import de.lubowiecki.springsteps.model.Product;
import de.lubowiecki.springsteps.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getOneProduct(@PathVariable int id) {
        return service.findById(id).orElse(new Product());
    }

    // Test für das Speichern über REST-Api
    @PostMapping("/products/save") // Kommuniziert über JSON
    public Product addOne(@RequestBody Product p) {
        p.setPrice(p.getPrice() * 2);
        return p;
    }
}
