package de.lubowiecki.springsteps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WebUIController {

    @Autowired // CDI - Context and Dependency Injection
    private ProductService service;

    @GetMapping("/")
    public String index(Model model) {
        // model.addAttribute = Weitergabe von Daten an die View
        model.addAttribute("headline", "Herzlich Willkommen bei Spring");
        model.addAttribute("ac", "home");
        model.addAttribute("content", "Das ist das Haus von Nikigraus...");
        return "standard"; // Verweist auf /WEB-INF/standard.jsp (siehe application.properties)
    }

    @GetMapping("/team")
    public String team(Model model) {
        model.addAttribute("headline", "Unser Team");
        model.addAttribute("ac", "team");
        model.addAttribute("content", "Das sind alle unsere Team-Mitglieder...");
        return "standard";
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("headline", "Unsere Produkte");
        model.addAttribute("ac", "products");
        model.addAttribute("productList", service.findAll());
        return "products";
    }

    @PostMapping("/products")
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

    @GetMapping("/products/new")
    public String productForm(Model model) {
        model.addAttribute("headline", "Neues Produkt");
        model.addAttribute("ac", "products");
        return "product-form";
    }
}
