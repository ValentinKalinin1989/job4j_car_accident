package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * repository for accidents
 */
@Repository
public class AccidentMem {
    private HashMap<Long, Accident> accidents;
    private HashMap<Long, AccidentType> accidentTypes;
    private Long id;

    public AccidentMem() {
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
        accidents.put(1L, new Accident(1L, "Иван Иванович Иванов", "Превышение скорости на 30 км/час", "Москва, проспект Ленина", accidentTypes.get(9L)));
        accidents.put(2L, new Accident(2L, "Валентин Валентинович Валентинов", "Превышение скорости на 56 км/час", "Санкт-Петербург, проспект Ленина", accidentTypes.get(9L)));
        accidents.put(3L, new Accident(3L, "Валелерий Валерьевич Валериевов", "Превышение скорости на 60 км/час", "Екатеринбург, проспект Ленина", accidentTypes.get(9L)));
        accidents.put(4L, new Accident(4L, "Джон Доу", "Превышение скорости на 70 км/час", "Тула, проспект Ленина", accidentTypes.get(9L)));
        accidents.put(5L, new Accident(5L, "Василий Васильевич Васильев", "Превышение скорости на 10 км/час", "Москва, проспект Ленина", accidentTypes.get(9L)));
        accidents.put(6L, new Accident(6L, "Джон Уик", "Превышение скорости на 10 км/час", "Нью-Йорк, проспект Ленина", accidentTypes.get(9L)));
        accidents.put(7L, new Accident(7L, "Эрик Понти", "Превышение скорости на 50 км/час", "Стокгольм, проспект Ленина", accidentTypes.get(9L)));
        accidents.put(8L, new Accident(8L, "Мартин Иден", "Превышение скорости на 100 км/час", "Москва, проспект Ленина", accidentTypes.get(9L)));
        accidents.put(9L, new Accident(9L, "Декард Шоу", "Сбил китайца", "Токио, проспект Ленина", accidentTypes.get(6L)));
        accidents.put(10L, new Accident(10L, "Билли Бутчер", "Сбил человека-невидимку", "Нью-Йорк, магазин видео-аудио техники, проспект Ленина", accidentTypes.get(8L)));
        accidents.put(11L, new Accident(11L, "Иван Иванович Иванов", "Превышение скорости на 20 км/час", "Москва, проспект Ленина", accidentTypes.get(9L)));
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
     *
     * @param accident - object to save or update in repository
     */
    public void save(Accident accident) {
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
}
