package de.lubowiecki.springsteps.controller;

import de.lubowiecki.springsteps.model.Category;
import de.lubowiecki.springsteps.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("categories")
public class CategoryController {

    @Autowired // FieldInjection. Feld darf nicht final sein
    private CategoryRepository repo;

    /*
    @Autowired // ConstructorInjection. Feld kann final sein
    public CategoryController(CategoryRepository repo) {
        this.repo = repo;
    }
    */

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("categories", repo.findAll());
        return "categories";
    }

    @PostMapping("")
    private String save(@RequestParam("name") String name, Model model) {
        repo.save(new Category(name));
        return "redirect:/categories"; // Umleitung auf die Übersicht
    }
}
