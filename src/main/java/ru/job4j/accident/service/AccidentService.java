package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMen;

import java.util.List;

/**
 * get and set data from AccidentMen repository
 */
@Service
public class AccidentService {
    private final AccidentMen accidentMen;

    public AccidentService(AccidentMen accidentMen) {
        this.accidentMen = accidentMen;
    }

    public List<Accident> findAll() {
        return accidentMen.findAll();
    }

    public void save(Accident accident) {
        accidentMen.save(accident);
    }
}
