package ru.job4j.accident.service;

import ru.job4j.accident.model.*;

import java.util.List;

public interface AccidentService {
    List<Accident> findAll();

    Accident save(Accident accident);

    List<AccidentType> findAllAccidentTypes();

    List<Rule> getAllRule();

    void addRulesToAccident(Accident accident, Integer[] ruleIds);

    Authority findByAuthority(String authority);

    void save(User user);
}
