package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.jparepository.AccidentRepository;
import ru.job4j.accident.repository.jparepository.AccidentTypeRepository;
import ru.job4j.accident.repository.jparepository.RuleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccidentServiceJpa implements AccidentService {
    private final AccidentRepository accidentRepository;
    private final AccidentTypeRepository accidentTypeRepository;
    private final RuleRepository ruleRepository;

    public AccidentServiceJpa(AccidentRepository accidentRepository,
                              AccidentTypeRepository accidentTypeRepository,
                              RuleRepository ruleRepository) {
        this.accidentRepository = accidentRepository;
        this.accidentTypeRepository = accidentTypeRepository;
        this.ruleRepository = ruleRepository;
    }

    @Override
    public List<Accident> findAll() {
        List<Accident> accidents = new ArrayList<>();
        accidentRepository.findAll().forEach(accidents::add);
        return accidents;
    }

    @Override
    public Accident save(Accident accident) {
        return accidentRepository.save(accident);
    }

    @Override
    public List<AccidentType> findAllAccidentTypes() {
        List<AccidentType> accidentTypes = new ArrayList<>();
        accidentTypeRepository.findAll().forEach(accidentTypes::add);
        return accidentTypes;
    }

    @Override
    public List<Rule> getAllRule() {
        List<Rule> rules = new ArrayList<>();
        ruleRepository.findAll().forEach(rules::add);
        return rules;
    }

    @Override
    public void addRulesToAccident(Accident accident, Integer[] ruleIds) {
        List<Rule> rules = getAllRule();
        for (Integer index : ruleIds) {
            accident.addRule(rules.get(index - 1));
        }
        accidentRepository.save(accident);
    }
}
