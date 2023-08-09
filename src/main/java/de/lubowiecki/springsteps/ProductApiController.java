package de.lubowiecki.springsteps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/products")
@RestController
public class ProductApiController {

    @Autowired
    private ProductRepository repository;


    // http://localhost:8080/api/v1/products
    @GetMapping
    public List<Product> all() {
        return repository.findAll();
    }

    // http://localhost:8080/api/v1/products/10
    @GetMapping("/{id}")
    public Product one(@PathVariable int id) {
        return repository.findById(id).orElse(new Product());
    }

    // http://localhost:8080/api/v1/products/search/Tasse
    @GetMapping("/search/{str}")
    public List<Product> oneByName(@PathVariable String str) {
        return repository.findAllByNameLike("%" + str + "%");
    }
}
