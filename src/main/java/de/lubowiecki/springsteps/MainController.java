package de.lubowiecki.springsteps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

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
    public String getProducts(Model model) {
        model.addAttribute("headline", "Unsere Produkte");
        model.addAttribute("products", repository.findAll());
        model.addAttribute("cur", "products");
        return "list"; // Wir verwenden list.html
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("headline", "Neues Produkt");
        model.addAttribute("cur", "new");
        model.addAttribute("product", new Product());
        return "form";
    }

    /* HTTP-Methoden:
    GET
    POST
    PUT
    DELETE
    ...
     */

    @PostMapping("/save")
    public String save(Product product) {
        repository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("headline", "Produkt bearbeiten");
        model.addAttribute("cur", "products");
        Product product = repository.findById(id).orElse(new Product()); // Entweder das gesuchte Produkt oder wenn nicht vorhanden ein leeres
        model.addAttribute("product", product);
        return "form";
    }

    // @PathVariable liest den Wert für den Parameter aus der URL
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
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
