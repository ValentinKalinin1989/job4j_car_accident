package ru.job4j.accident.service;

import ru.job4j.accident.model.*;
import ru.job4j.accident.repository.AccidentMem;

import java.util.List;

/**
 * get and set data from AccidentMen repository
 */

//@Service
public class AccidentServiceMem implements AccidentService {

    private final AccidentMem accidentMem;

    public AccidentServiceMem(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    @Override
    public List<Accident> findAll() {
        return accidentMem.findAll();
    }

    @Override
    public Accident save(Accident accident) {
        return accidentMem.save(accident);
    }

    @Override
    public List<AccidentType> findAllAccidentTypes() {
        return accidentMem.getAllType();
    }

    @Override
    public List<Rule> getAllRule() {
        return accidentMem.getAllRules();
    }

    @Override
    public void addRulesToAccident(Accident accident, Integer[] ruleIds) {
        accidentMem.addRulesToAccident(accident, ruleIds);
    }

    @Override
    public Authority findByAuthority(String authority) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void save(User user) {
        throw new UnsupportedOperationException();
    }
}


