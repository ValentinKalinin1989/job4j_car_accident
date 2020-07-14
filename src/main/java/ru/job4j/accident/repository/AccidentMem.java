package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.*;

/**
 * repository for accidents
 */
//@Repository
public class AccidentMem {
    private HashMap<Long, Accident> accidents;
    private HashMap<Long, AccidentType> accidentTypes;
    private HashMap<Long, Rule> rules;
    private Long id;

    public AccidentMem() {
        this.rules = new HashMap<>();
        rules.put(1L, Rule.of(1L, "Статья. 1"));
        rules.put(2L, Rule.of(2L, "Статья. 2"));
        rules.put(3L, Rule.of(3L, "Статья. 3"));
        rules.put(4L, Rule.of(4L, "Статья. 4"));
        rules.put(5L, Rule.of(5L, "Статья. 5"));
        rules.put(6L, Rule.of(6L, "Статья. 6"));
        rules.put(7L, Rule.of(7L, "Статья. 7"));
        rules.put(8L, Rule.of(8L, "Статья. 8"));
        rules.put(9L, Rule.of(9L, "Статья. 9"));
        Set<Rule> rules1 = new HashSet<>();
        rules1.add(rules.get(1L));
        rules1.add(rules.get(2L));
        rules1.add(rules.get(3L));
        Set<Rule> rules2 = new HashSet<>();
        rules2.add(rules.get(4L));
        rules2.add(rules.get(5L));
        rules2.add(rules.get(6L));
        Set<Rule> rules3 = new HashSet<>();
        rules3.add(rules.get(7L));
        rules3.add(rules.get(8L));
        rules3.add(rules.get(9L));
        this.accidentTypes = new HashMap<>();
        accidentTypes.put(1L, AccidentType.of(1L, "Машина и человек"));
        accidentTypes.put(2L, AccidentType.of(2L, "Две машины"));
        accidentTypes.put(3L, AccidentType.of(3L, "Три машины и более"));
        accidentTypes.put(4L, AccidentType.of(4L, "Машина и велосипед"));
        accidentTypes.put(5L, AccidentType.of(5L, "Машина и животное"));
        accidentTypes.put(6L, AccidentType.of(6L, "Сбит человек на дороге"));
        accidentTypes.put(7L, AccidentType.of(7L, "Сбит человек на пешеходном переходе"));
        accidentTypes.put(8L, AccidentType.of(8L, "Сбит человек вне дороги"));
        accidentTypes.put(9L, AccidentType.of(9L, "Превышение скорости"));
        this.accidents = new HashMap<>();

        accidents.put(1L, new Accident(1L, "Иван Иванович Иванов", "Превышение скорости на 30 км/час", "Москва, проспект Ленина", accidentTypes.get(9L), rules1));
        accidents.put(2L, new Accident(2L, "Валентин Валентинович Валентинов", "Превышение скорости на 56 км/час", "Санкт-Петербург, проспект Ленина", accidentTypes.get(9L), rules1));
        accidents.put(3L, new Accident(3L, "Валелерий Валерьевич Валериевов", "Превышение скорости на 60 км/час", "Екатеринбург, проспект Ленина", accidentTypes.get(9L), rules1));
        accidents.put(4L, new Accident(4L, "Джон Доу", "Превышение скорости на 70 км/час", "Тула, проспект Ленина", accidentTypes.get(9L), rules2));
        accidents.put(5L, new Accident(5L, "Василий Васильевич Васильев", "Превышение скорости на 10 км/час", "Москва, проспект Ленина", accidentTypes.get(9L), rules2));
        accidents.put(6L, new Accident(6L, "Джон Уик", "Превышение скорости на 10 км/час", "Нью-Йорк, проспект Ленина", accidentTypes.get(9L), rules2));
        accidents.put(7L, new Accident(7L, "Эрик Понти", "Превышение скорости на 50 км/час", "Стокгольм, проспект Ленина", accidentTypes.get(9L), rules2));
        accidents.put(8L, new Accident(8L, "Мартин Иден", "Превышение скорости на 100 км/час", "Москва, проспект Ленина", accidentTypes.get(9L), rules2));
        accidents.put(9L, new Accident(9L, "Декард Шоу", "Сбил китайца", "Токио, проспект Ленина", accidentTypes.get(6L), rules3));
        accidents.put(10L, new Accident(10L, "Билли Бутчер", "Сбил человека-невидимку", "Нью-Йорк, магазин видео-аудио техники, проспект Ленина", accidentTypes.get(8L), rules3));
        accidents.put(11L, new Accident(11L, "Иван Иванович Иванов", "Превышение скорости на 20 км/час", "Москва, проспект Ленина", accidentTypes.get(9L), rules3));
        id = (long) accidents.size();


    }

    /**
     * get List of all accidents
     *
     * @return List of accidents
     */
    public List<Accident> findAll() {
        return new ArrayList<>(accidents.values());
    }

    /**
     * save accident if it is new, or update accident if same id present in repository
     * <p>
     * // * @param accident - object to save or update in repository
     */

    public Accident save(Accident accident) {
        Long accidentId = accident.getId();
        if (accidents == null) {
            accidents = new HashMap<>();
            id = 0L;
        }
        if (accidentId == null) {
            id++;
            accidentId = id;
            accident.setId(accidentId);
        }
        AccidentType currentType = accident.getAccidentType();
        if (currentType.getName() == null) {
            accident.setAccidentType(accidentTypes.get(currentType.getId()));
        }
        accidents.put(accidentId, accident);
        return accident;
    }

    /**
     * add new type accident in repository
     *
     * @param accidentType - new type accident
     */
    public void addType(AccidentType accidentType) {
        if (accidentTypes == null) {
            accidentTypes = new HashMap<>();
        }
        if (!accidentTypes.containsValue(accidentType)) {
            accidentTypes.put(accidentTypes.size() + 1L, accidentType);
        }
    }

    /**
     * get all types accident
     *
     * @return list of types accident
     */
    public List<AccidentType> getAllType() {
        return new ArrayList<>(accidentTypes.values());
    }

    /**
     * get all rules
     *
     * @return list of rules
     */
    public List<Rule> getAllRules() {
        return new ArrayList<>(rules.values());
    }


    public void addRulesToAccident(Accident accident, Integer[] ruleIds) {
        if (accident.getId() == null) {
            save(accident);
        }

        Accident currentAccident = accidents.get(accident.getId());
        for (int index : ruleIds) {
            currentAccident.addRule(rules.get((long) index));
        }
    }
}

