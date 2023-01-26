package de.lubowiecki.springsteps;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        products.add(new Product(1, "Mütze", "100% Wolle", 19.99));
        products.add(new Product(2, "Handschuhe", "100% Wolle", 29.99));
        products.add(new Product(3, "Tasse, blau", "Keramik", 7.29));
    }

    public List<Product> findAll() {
        return  products;
    }

    public Optional<Product> findById(int id) {
        Product product = null;
        for(Product p : products) {
            if(p.getId() == id) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }
}
