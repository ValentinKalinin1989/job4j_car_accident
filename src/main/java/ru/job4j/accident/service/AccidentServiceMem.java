package ru.job4j.accident.service;

import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentMem;

import java.util.List;

/**
 * get and set data from AccidentMen repository
 */
public class AccidentServiceMem implements AccidentService {
    private final AccidentMem accidentMem;

    public AccidentServiceMem(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    public List<Accident> findAll() {
        return accidentMem.findAll();
    }

    public Accident save(Accident accident) {
        return accidentMem.save(accident);
    }

    public List<AccidentType> findAllAccidentTypes() {
        return accidentMem.getAllType();
    }

    public void addAccidentType(AccidentType accidentType) {
        accidentMem.addType(accidentType);
    }

    public List<Rule> getAllRule() {
        return accidentMem.getAllRules();
    }

    public void addRulesToAccident(Accident accident, Integer[] ruleIds) {
        accidentMem.addRulesToAccident(accident, ruleIds);
    }
}
