package de.lubowiecki.springsteps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller // Kann HTML-Seite ausliefern
public class MainController {

    @Autowired // Spring-Container stellt das Repository zur Verfügung
    private ProductRepository repo;

    // Mappings MÜSSEN pro HTTP-Methode einzigartig sein
    // HTTP-Methoden: GET, POST, PUT, DELETE, UPDATE
    @GetMapping("") // Mapping beschreibt über welche URL die Methode erreichbar ist
    public String home(Model tpl) { // Model dient der Kommunikation zwischen Controller und HTML-Template
        tpl.addAttribute("title", "Herzlich Willkommen!"); // Übergabe an die Vorlage

//        Product p = new Product("Tasse, rot", "Feinstes Keramik", 100, 7.99);
//        repo.save(p);

        return "standard"; // Name des HTML-Templates (unter /resources/templates)
    }

    @GetMapping("/products")
    public String products(Model tpl) {
        tpl.addAttribute("title", "Unsere Produkte");
        tpl.addAttribute("showProducts", true);
        List<Product> products = repo.findAll();
        tpl.addAttribute("products", products); // Produkte werden an das HTML-Template weitergegeben
        //tpl.addAttribute("products", repo.findAll());
        return "standard";
    }

    @GetMapping("/services")
    public String services(Model tpl) {
        tpl.addAttribute("title", "Der beste Service für Sie");
        return "standard";
    }

    @GetMapping("/contact")
    public String contact(Model tpl) {
        tpl.addAttribute("title", "Schreiben Sie uns");
        return "standard";
    }
}
