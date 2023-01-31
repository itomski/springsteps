package de.lubowiecki.springsteps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MainController {

    //@GetMapping("/")
    @RequestMapping("/") // Verarbeitet alle Anfrage-Typen (GET, POST, PUT, DELETE, etc.)
    public String index(Model model) {
        // model.addAttribute = Weitergabe von Daten an die View
        model.addAttribute("headline", "Herzlich Willkommen bei Spring");
        model.addAttribute("ac", "home");
        model.addAttribute("content", "Das ist das Haus von Nikigraus...");
        return "standard"; // Verweist auf /WEB-INF/standard.jsp (siehe application.properties)
    }

    @GetMapping("/team") // Verarbeitet nur eine GET Anfrage
    public String team(Model model) { // Model wird automatisch von Spring eingesetzt
        // Model ist der Vermittler zwischen dem Controller und der View (jsp)
        model.addAttribute("headline", "Unser Team");
        model.addAttribute("ac", "team");
        model.addAttribute("content", "Das sind alle unsere Team-Mitglieder...");
        return "standard"; // View, die verwendet werden soll
    }

    // http://localhost:8080/endpunkt
    @GetMapping("/endpunkt") // Einfacher Endpunkt
    public String endpunktTest1(Model model) {
        model.addAttribute("data", "leer");
        return "endpunkt";
    }

    // http://localhost:8080/endpunkt/a/Wert
    @GetMapping("/endpunkt/a/{name}") // Endpunkt mit einer variablen Information. Name ist Pflichtattribut
    public String endpunktTest2(@PathVariable String name, Model model) {
        model.addAttribute("data", name);
        return "endpunkt";
    }

    @GetMapping(value = {"/endpunkt/b", "/endpunkt/b/{name}"}) // Endpunkt mit einer variablen Information. Name ist optional
    public String endpunktTest3(@PathVariable Optional<String> name, Model model) {
        // Wird ein Wert vorgegeben ist das Optional gefüllt, anderenfalls ist es leer
        model.addAttribute("data", name.orElse("leer"));
        return "endpunkt";
    }

    // http://localhost:8080/endpunkt/xyz/123
    @GetMapping("/endpunkt/{gruppe}/{id}") // Endpunkt mit zwei variablen Information. Beide sind Pflichtangaben
    public String endpunktTest4(@PathVariable String gruppe, @PathVariable int id, Model model) {
        model.addAttribute("gruppe", gruppe);
        model.addAttribute("data", id);
        return "endpunkt";
    }

    // http://localhost:8080/endpunkt/c?id=123
    @GetMapping("/endpunkt/c") // Endpunkt mit einer variablen Information. Pflichtangabe
    public String endpunktTest5(@RequestParam int id, Model model) {
        model.addAttribute("data", id);
        return "endpunkt";
    }

    // http://localhost:8080/endpunkt/d?g=nachrichten&i=123
    @GetMapping("/endpunkt/d") // Endpunkt mit zwei variablen Information. Pflichtangabe.
    // g Parameter wird in gruppe umbenannt, i in id
    public String endpunktTest6(@RequestParam("g") String gruppe, @RequestParam("i") int id, Model model) {
        model.addAttribute("gruppe", gruppe);
        model.addAttribute("data", id);
        return "endpunkt";
    }

    // http://localhost:8080/endpunkt/e?gruppe=nachrichten
    @GetMapping("/endpunkt/e") // Endpunkt mit zwei variablen Information. Angabe ist optional.
    public String endpunktTest7(@RequestParam(required = false) String gruppe, @RequestParam(required = false) Integer id, Model model) {
        // Für primitive Typen Wrapper nutzen, da sonst eine Prüfung auf null nicht möglich ist
        model.addAttribute("gruppe", gruppe);
        model.addAttribute("data", id);
        return "endpunkt";
    }

    // http://localhost:8080/endpunkt/f?gruppe=nachrichten
    @GetMapping("/endpunkt/f") // Endpunkt mit einer variablen Information. Angabe ist optional mit Defaultvalue
    public String endpunktTest8(@RequestParam(defaultValue = "leer") String gruppe, Model model) {
        model.addAttribute("gruppe", gruppe);
        return "endpunkt";
    }

    // http://localhost:8080/endpunkt/g?x=15&x=22&x=107
    @GetMapping("/endpunkt/g") // Endpunkt mit einer variablen Anzahl Parameter. Namen dürfen keine Duplikate sein
    public String endpunktTest9(@RequestParam Map<String, Integer> werte, Model model) {
        model.addAttribute("gruppe", werte.toString());
        return "endpunkt";
    }

    // http://localhost:8080/endpunkt/h?id=15&id=22&id=107
    // http://localhost:8080/endpunkt/h?id=15,22,107,17
    @GetMapping("/endpunkt/h") // Endpunkt mit einer variablen Anzahl Parameter. Alle tragen den gleichen Namen
    public String endpunktTest10(@RequestParam("id") List<Integer> werte, Model model) {
        model.addAttribute("gruppe", werte.toString());
        return "endpunkt";
    }

    @PostMapping("/endpunkt/i") // Endpunkt mit einem variablen Parameter.
    public String endpunktTest11(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("data", id);
        return "endpunkt";
    }

    @PostMapping("/endpunkt/j") // Endpunkt mit einem variablen Parameter.
    public String endpunktTest12(String email, String name, Model model) {
        model.addAttribute("data", email + ", " + name);
        return "endpunkt";
    }
}
