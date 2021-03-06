package ru.job4j.accident.service;

import ru.job4j.accident.model.*;
import ru.job4j.accident.repository.AccidentJdbcTemplate;

import java.util.List;

//@Service
public class AccidentServiceJdbcTemplate implements AccidentService {

    private final AccidentJdbcTemplate accidentJdbcTemplate;

    public AccidentServiceJdbcTemplate(AccidentJdbcTemplate accidentJdbcTemplate) {
        this.accidentJdbcTemplate = accidentJdbcTemplate;
    }

    @Override
    public List<Accident> findAll() {
        return accidentJdbcTemplate.findAll();
    }

    @Override
    public Accident save(Accident accident) {
        return accidentJdbcTemplate.save(accident);
    }

    @Override
    public List<AccidentType> findAllAccidentTypes() {

        return accidentJdbcTemplate.findAllAccidentTypes();
    }

    @Override
    public List<Rule> getAllRule() {

        return accidentJdbcTemplate.getAllRule();
    }

    @Override
    public void addRulesToAccident(Accident accident, Integer[] ruleIds) {
        accidentJdbcTemplate.addRulesToAccident(accident, ruleIds);
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


