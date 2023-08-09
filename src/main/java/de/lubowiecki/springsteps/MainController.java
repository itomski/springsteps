package de.lubowiecki.springsteps;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {

    /* HTTP-Methoden:
    GET (@GetMapping): Liefert den Inhalt einer gewünschten Ressource (HTML, JSON, PDF, etc.)
    POST (@PostMapping): Wird zum Verschicken von Formulardaten benutzt. Kann neue Ressourcen anlegen

    Ein Webbrowser verwendet nur Get und Post

    Für APIs nutzt man auch weitere wie z.B.
    PUT (@PutMapping): Wird zum verändern von Ressourcen benutzt
    DELETE (@DeleteMapping): Löscht eine Ressource
     */

    /* Aktuell erreichbare URL-Mappings
    | METHODE   | URL           | Controller        | Methode       |
    | GET       | /             | MainController    | index         |
    | GET       | /products     | MainController    | products      |
    | GET       | /new          | MainController    | form          |
    | POST      | /save         | MainController    | save          |
    | GET       | /edit/1       | MainController    | edit          |
    | GET       | /delete/1     | MainController    | delete        |
     */

    /*
        Model (org.springframework.ui.Model) ist ein Speicher, mit dem man Variablen
        an Thymeleaf-HTML-Templates transportieren kann
        model.addAttribute("schluessel", "wert");
        Schlüssel muss immer ein String sein
        Wert kann ein Objekt, Collection, Array oder auch primitiver Wert sein
     */

    /*
        Model wird als Transportschicht zwischen Controller und HTML-Templates verwendet
        Das gefüllte Model-Objekt wird automatisch an das HTML-Template weitergegeben,
        das im return der Methode steht
     */


    @Autowired // Dieses Objekt wird automatisch vom Spring-Container instanziert und zugewiesen
    private ProductRepository repository;

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
    public String products(Model model) {
        model.addAttribute("headline", "Unsere Produkte");

        // findAll: Liefert eine Liste aller Produkte
        model.addAttribute("products", repository.findAll());
        model.addAttribute("cur", "products");
        return "list"; // Wir verwenden list.html
    }

    // http://localhost:8080/new
    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("headline", "Neues Produkt");
        model.addAttribute("cur", "new");
        model.addAttribute("product", new Product());
        return "form";
    }

    // Post: http://localhost:8080/save
    // BindingResult enthält das Ergebnis der Validierung
    @PostMapping("/save")
    public String save(@Valid Product product, BindingResult result, Model model) { // Formulardaten werden zu einem Produkt-Objekt zusammengesetzt
        // save: Speichert ein Objekt in der DB
        // ist die id = 0 wird ein neues Objekt erzeugt
        // ist es != 0 und ein passendes Objekt ist in der DB, wird es geändert

        if(result.hasErrors()) { // Wenn Fehler, dann zurück zum Formular
            model.addAttribute("headline", "Produkt");
            return "form";
        }

        repository.save(product);
        return "redirect:/products"; // Umleitung auf eine andere URL
    }

    // http://localhost:8080/edit/10
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("headline", "Produkt bearbeiten");
        model.addAttribute("cur", "products");

        // findById: sucht ein Produkt in der DB. Liefert das Produkt verpackt in ein Optional
        // Gibt es für die ID nichts passendes in der DB ist das Optional empty

        Product product = repository.findById(id).orElse(new Product()); // Entweder das gesuchte Produkt oder wenn nicht vorhanden ein leeres
        model.addAttribute("product", product);
        return "form";
    }

    // http://localhost:8080/delete/10
    // @PathVariable liest den Wert für den Parameter aus der URL
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        // deleteById: löscht ein Produkt aus der DB, wenn die ID verfügbar ist
        repository.deleteById(id);
        return "redirect:/products";
    }

    /* Alternativ
    @PostMapping("/save")
    public String save(String name, double price, int amount, LocalDate availableSince) {
        Product p = new Product(name, price, amount, availableSince);
        productList.add(p);
        return "redirect:/products";
    }
    */
}
