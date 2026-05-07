package de.lubowiecki.springsteps;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Kann HTML-Seite ausliefern
public class MainController {

    // Mappings MÜSSEN pro HTTP-Methode einzigartig sein
    // HTTP-Methoden: GET, POST, PUT, DELETE, UPDATE
    @GetMapping("") // Mapping beschreibt über welche URL die Methode erreichbar ist
    public String home(Model tpl) { // Model dient der Kommunikation zwischen Controller und HTML-Template
        tpl.addAttribute("title", "Herzlich Willkommen!"); // Übergabe an die Vorlage
        return "standard"; // Name des HTML-Templates (unter /resources/templates)
    }

    @GetMapping("/products")
    public String products(Model tpl) {
        tpl.addAttribute("title", "Unsere Produkte");
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
