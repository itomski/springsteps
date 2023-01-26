package de.lubowiecki.springsteps;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebUIController {

    @GetMapping("/")
    public String index(Model model) {
        // model.addAttribute = Weitergabe von Daten an die View
        model.addAttribute("headline", "Herzlich Willkommen bei Spring");
        model.addAttribute("ac", "home");
        model.addAttribute("content", "Das ist das Haus von Nikigraus...");
        return "hallo"; // Verweist auf /WEB-INF/hallo.jsp (siehe application.properties)
    }

    @GetMapping("/team")
    public String team(Model model) {
        model.addAttribute("headline", "Unser Team");
        model.addAttribute("ac", "team");
        model.addAttribute("content", "Das sind alle unsere Team-Mitglieder...");
        return "hallo";
    }
}
