package de.lubowiecki.springsteps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

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
}
