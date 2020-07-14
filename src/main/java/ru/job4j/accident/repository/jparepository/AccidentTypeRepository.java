package ru.job4j.accident.repository.jparepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;

@Repository
public interface AccidentTypeRepository extends CrudRepository<AccidentType, Long> {
}
