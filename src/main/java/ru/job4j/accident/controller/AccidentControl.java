package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.service.AccidentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AccidentControl {

    private final AccidentService accidentService;

    public AccidentControl(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<AccidentType> accidentTypes = accidentService.findAllAccidentTypes();
        List<Rule> rules = accidentService.getAllRule();
        model.addAttribute("accidentTypes", accidentTypes);
        model.addAttribute("rules", rules);
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest request) {
        accidentService.save(accident);
        String[] idsString = request.getParameterValues("ruleIds");
        if (idsString != null) {
            Integer[] ids = new Integer[idsString.length];
            for (int i = 0; i < idsString.length; i++) {
                ids[i] = Integer.valueOf(idsString[i]);
            }
            accidentService.addRulesToAccident(accident, ids);
        }
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        List<AccidentType> accidentTypes = accidentService.findAllAccidentTypes();
        List<Rule> rules = accidentService.getAllRule();
        model.addAttribute("accidentTypes", accidentTypes);
        model.addAttribute("rules", rules);
        return "accident/edit";
    }

}
