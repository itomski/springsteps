package de.lubowiecki.springsteps.controller;

import de.lubowiecki.springsteps.model.Product;
import de.lubowiecki.springsteps.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
