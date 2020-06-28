package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * repository for accidents
 */
@Repository
public class AccidentMen {
    private HashMap<Long, Accident> accidents;

    public AccidentMen() {
        this.accidents = new HashMap<>();
        accidents.put(1L, new Accident(1L, "Иван Иванович Иванов", "Превышение скорости на 30 км/час", "Москва, проспект Ленина"));
        accidents.put(2L, new Accident(2L, "Валентин Валентинович Валентинов", "Превышение скорости на 56 км/час", "Санкт-Петербург, проспект Ленина"));
        accidents.put(3L, new Accident(3L, "Валелерий Валерьевич Валериевов", "Превышение скорости на 60 км/час", "Екатеринбург, проспект Ленина"));
        accidents.put(4L, new Accident(4L, "Джон Доу", "Превышение скорости на 70 км/час", "Тула, проспект Ленина"));
        accidents.put(5L, new Accident(5L, "Василий Васильевич Васильев", "Превышение скорости на 10 км/час", "Москва, проспект Ленина"));
        accidents.put(6L, new Accident(6L, "Джон Уик", "Превышение скорости на 10 км/час", "Нью-Йорк, проспект Ленина"));
        accidents.put(7L, new Accident(7L, "Эрик Понти", "Превышение скорости на 50 км/час", "Стокгольм, проспект Ленина"));
        accidents.put(8L, new Accident(8L, "Мартин Иден", "Превышение скорости на 100 км/час", "Москва, проспект Ленина"));
        accidents.put(9L, new Accident(9L, "Декард Шоу", "Сбил китайца", "Токио, проспект Ленина"));
        accidents.put(10L, new Accident(10L, "Билли Бутчер", "Сбил человека-невидимку", "Нью-Йорк, магазин видео-аудио техники, проспект Ленина"));
        accidents.put(11L, new Accident(11L, "Иван Иванович Иванов", "Превышение скорости на 20 км/час", "Москва, проспект Ленина"));
    }

    /**
     * get List of all accidents
     * @return List of accidents
     */
    public List<Accident> findAll() {
        return  new ArrayList<>(accidents.values());
    }
}
