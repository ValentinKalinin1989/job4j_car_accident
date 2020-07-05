package ru.job4j.accident.service;

import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.List;

public interface AccidentService {
    List<Accident> findAll();

    Accident save(Accident accident);

    List<AccidentType> findAllAccidentTypes();

    void addAccidentType(AccidentType accidentType);

    List<Rule> getAllRule();

    void addRulesToAccident(Accident accident, Integer[] ruleIds);
}
