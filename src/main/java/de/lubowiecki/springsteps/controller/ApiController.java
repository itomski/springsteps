package de.lubowiecki.springsteps.controller;

import de.lubowiecki.springsteps.model.Product;
import de.lubowiecki.springsteps.repository.ProductRepository;
import de.lubowiecki.springsteps.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductRepository repo;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getOneProduct(@PathVariable int id) {
        return service.findById(id).orElse(new Product());
    }

    @GetMapping("/products/name/{name}")
    public List<Product> getAllByName(@PathVariable String name) {
        //return repo.findByName(name);
        //return repo.findByNameContaining(name);
        return repo.findByNameContainingOrDescriptionContaining(name, name);
    }



    // Test für das Speichern über REST-Api
    @PostMapping("/products/save") // Kommuniziert über JSON
    public Product addOne(@RequestBody Product p) {
        p.setPrice(p.getPrice() * 2);
        return p;
    }
}
