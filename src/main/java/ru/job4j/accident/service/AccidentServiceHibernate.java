package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.*;
import ru.job4j.accident.repository.AccidentHibernate;

import java.util.List;

//@Service
public class AccidentServiceHibernate implements AccidentService {

    private final AccidentHibernate accidentHibernate;

    public AccidentServiceHibernate(AccidentHibernate accidentHibernate) {
        this.accidentHibernate = accidentHibernate;
    }

    @Override
    public List<Accident> findAll() {
        return accidentHibernate.findAll();
    }

    @Override
    public Accident save(Accident accident) {
        return accidentHibernate.save(accident);
    }

    @Override
    public List<AccidentType> findAllAccidentTypes() {
        return accidentHibernate.findAllAccidentTypes();
    }

    @Override
    public List<Rule> getAllRule() {
        return accidentHibernate.getAllRule();
    }

    @Override
    public void addRulesToAccident(Accident accident, Integer[] ruleIds) {
        accidentHibernate.addRulesToAccident(accident, ruleIds);
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
