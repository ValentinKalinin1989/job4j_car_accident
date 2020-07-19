package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.*;
import ru.job4j.accident.repository.jparepository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccidentServiceJpa implements AccidentService {
    private final AccidentRepository accidentRepository;
    private final AccidentTypeRepository accidentTypeRepository;
    private final RuleRepository ruleRepository;
    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;

    public AccidentServiceJpa(AccidentRepository accidentRepository,
                              AccidentTypeRepository accidentTypeRepository,
                              RuleRepository ruleRepository,
                              AuthorityRepository authorityRepository,
                              UserRepository userRepository) {
        this.accidentRepository = accidentRepository;
        this.accidentTypeRepository = accidentTypeRepository;
        this.ruleRepository = ruleRepository;
        this.authorityRepository = authorityRepository;
        this.userRepository = userRepository;
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

    public Authority findByAuthority(String authority) {
        return authorityRepository.findByAuthority(authority);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
