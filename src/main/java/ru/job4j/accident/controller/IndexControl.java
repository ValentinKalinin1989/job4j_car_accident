package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexControl {
    @GetMapping("/")
    public String index(Model model) {
        List<String> towns = new ArrayList<>(6);
        towns.add("Москва");
        towns.add("Тула");
        towns.add("Орел");
        towns.add("Брянск");
        towns.add("Новомосковск");
        towns.add("Воронеж");
        model.addAttribute("towns", towns);
        return "index";
    }
}
