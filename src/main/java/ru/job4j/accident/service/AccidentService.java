package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentMem;

import java.util.List;

/**
 * get and set data from AccidentMen repository
 */
@Service
public class AccidentService {
    private final AccidentMem accidentMem;

    public AccidentService(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    public List<Accident> findAll() {
        return accidentMem.findAll();
    }

    public void save(Accident accident) {
        accidentMem.save(accident);
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
