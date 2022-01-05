package Solidworks.com.demo.dao;

import Solidworks.com.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
    List<Person> selectAllPeople();

    Optional<Person> selectPersonbyID(UUID id);

    int deletePersonbyID(UUID id);
    int updatePersonbyID(UUID id, Person person);

}
