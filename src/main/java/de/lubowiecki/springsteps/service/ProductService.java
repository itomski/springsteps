package de.lubowiecki.springsteps.service;

import de.lubowiecki.springsteps.repository.ProductRepository;
import de.lubowiecki.springsteps.util.NumberSimulator;
import de.lubowiecki.springsteps.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    /*
    private List<Product> products;

    private NumberSimulator simulator;

    private int counter;

    @Autowired // Bindet automatisch ein Objekt des NumberSimulators ein
    public ProductService(NumberSimulator simulator) {
        products = new ArrayList<>();
        products.add(new Product(1, "Mütze", "100% Wolle", simulator.generateDouble(20)));
        products.add(new Product(2, "Handschuhe", "100% Wolle", simulator.generateDouble(30)));
        products.add(new Product(3, "Tasse, blau", "Keramik", simulator.generateDouble(10)));
    }
    */

    public List<Product> findAll() {
        //return  products;
        return repo.findAll(); // Liefert eine List von Product
    }

    public Optional<Product> findById(long id) {

        return repo.findById(id);

        /*
        Product product = null;
        for(Product p : products) {
            if(p.getId() == id) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
        */
    }

    public void save(Product product) {

        repo.save(product);

        /*
        product.setId(++counter);
        products.add(product);
        */
    }
}
