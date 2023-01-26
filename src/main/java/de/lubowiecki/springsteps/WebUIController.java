package de.lubowiecki.springsteps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    // Schreibe Ein Formular zu Hinzufügen von Produkten
    // Verwende das Formular in einer Methode des WebUIControllers, so dass das Form aufrufbar ist
}
