package de.lubowiecki.springsteps;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    // http://localhost:8080
    @GetMapping // Diese Methode ist über ein GET-Request erreichbar
    public String index(Model model) {
        model.addAttribute("headline", "Startseite");
        model.addAttribute("content", "Herzlich Willkommen bei Springsteps!");
        model.addAttribute("cur", "home");
        return "standard"; // Name des HTML-Templates (ohne der .html-Endung)
    }

    // http://localhost:8080/products
    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("headline", "Unsere Produkte");

        List<Product> produktListe = new ArrayList<>();
        produktListe.add(new Product("Tasse, gelb", 5.99, 100, LocalDate.now()));
        produktListe.add(new Product("Tasse, grün", 3.99, 1000, LocalDate.of(2023, 5, 15)));
        produktListe.add(new Product("Tasse, blau", 3.99, 600, LocalDate.of(2023, 5, 15)));
        produktListe.add(new Product("Vase", 15.99, 50, LocalDate.of(2023, 7, 25)));

        model.addAttribute("products", produktListe);
        model.addAttribute("cur", "products");
        return "list"; // Wir verwenden list.html
    }
}
