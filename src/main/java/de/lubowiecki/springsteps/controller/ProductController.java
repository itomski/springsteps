package de.lubowiecki.springsteps.controller;

import de.lubowiecki.springsteps.model.Product;
import de.lubowiecki.springsteps.model.ProductDto;
import de.lubowiecki.springsteps.repository.ProductRepository;
import de.lubowiecki.springsteps.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired // CDI - Context and Dependency Injection
    private ProductService service;

    @Autowired
    private ProductRepository repo;

    @GetMapping("") // http://localhost:8080/products (Nur GET)
    public String products(Model model) {
        model.addAttribute("headline", "Unsere Produkte");
        model.addAttribute("ac", "products");
        model.addAttribute("productList", repo.findAll());
        return "products";
    }

    /*
    @PostMapping("") // Bekommt vom Formular ein Einzelwerte zurück
    public String saveProduct(String name, String description, double price, Model model) {
        Product product = new Product(0, name, description, price);

        // Validierung
        Map<String, String> errorMap = new HashMap<>();

        if(price < 0.01 || price > 100) {
            errorMap.put("price", "Preis ist ungültig.");
        }

        if(name.length() == 0 || name.length() > 100) {
            errorMap.put("name", "Name ist ungültig.");
        }

        if(description.length() < 10 || description.length() > 500) {
            errorMap.put("description", "Beschreibung ist ungültig.");
        }

        if(errorMap.size() > 0) {
            model.addAttribute("failed", true);
            model.addAttribute("errors", errorMap);
            model.addAttribute("product", product);
        }
        else {
            service.add(product);
            model.addAttribute("saved", true);
        }

        return "product-form";
    }
    */

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("headline", "Neues Produkt");
        model.addAttribute("ac", "products");
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @GetMapping("/edit/{id}") // id hängt als Information an der URL
    public String editForm(@PathVariable int id, Model model) {
        model.addAttribute("headline", "Produkt Bearbeiten");
        model.addAttribute("ac", "products");
        model.addAttribute("product", service.findById(id));
        return "product-form";
    }

    @PostMapping("/edit") // id wird im EntityBody des Requests übertragen
    public String editPostForm(int id, Model model) {
        model.addAttribute("headline", "Produkt Bearbeiten");
        model.addAttribute("ac", "products");
        model.addAttribute("product", service.findById(id));
        return "product-form";
    }

    // http://localhost:8080/products (Nur POST)
    @PostMapping("") // Bekommt vom Formular ein Produkt-Objekt zurück
    public String saveAsObj(@ModelAttribute ProductDto productDto, Model model) {

        // DTO wird nicht in der Datenbank gespeichert und ist keine Entity
        // Es wird in eine Entity Konvertiert bevor es gespeichert wird
        Product product = productDto.convert();

        Map<String, String> errorMap = new HashMap<>();

        if(product.getPrice() < 0.01 || product.getPrice() > 100) {
            errorMap.put("price", "Preis ist ungültig.");
        }

        if(product.getName().length() == 0 || product.getName().length() > 100) {
            errorMap.put("name", "Name ist ungültig.");
        }

        if(product.getDescription().length() < 10 || product.getDescription().length() > 500) {
            errorMap.put("description", "Beschreibung ist ungültig.");
        }

        if(errorMap.size() > 0) {
            model.addAttribute("failed", true);
            model.addAttribute("errors", errorMap);
            model.addAttribute("product", product);
        }
        else {
            repo.save(product);
            model.addAttribute("product", new Product());
            model.addAttribute("saved", true);
        }

        return "product-form";
    }
}
