package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Repository
public class AccidentHibernate {
    private final SessionFactory sessionFactory;

    public AccidentHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Accident save(Accident accident) {
        try (Session session = sessionFactory.openSession()) {
            session.saveOrUpdate(accident);
        }
        return accident;
    }

    public void addRulesToAccident(Accident accident, Integer[] ruleIds) {
        try (Session session = sessionFactory.openSession()) {
            Set<Rule> rules = new HashSet<>();
            for(Integer id: ruleIds) {
                Rule rule = session.byId(Rule.class).getReference(id.longValue());
                rules.add(rule);
            }
            accident.setRules(rules);
            session.saveOrUpdate(accident);
        }
    }

    public List<Accident> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("from Accident", Accident.class)
                    .list();
        }
    }

    public List<AccidentType> findAllAccidentTypes() {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("from AccidentType", AccidentType.class)
                    .list();
        }
    }

    public List<Rule> getAllRule() {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("from Rule", Rule.class)
                    .list();
        }
    }


    public void addAccidentType(AccidentType accidentType) {

    }

    public void addRulesToAccident() {

    }


}
