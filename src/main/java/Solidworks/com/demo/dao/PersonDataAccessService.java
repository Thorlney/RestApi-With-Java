package Solidworks.com.demo.dao;

import Solidworks.com.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("PostGres")
public class PersonDataAccessService implements PersonDao {

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        return List.of(new Person (UUID.randomUUID(), "From POSTGRES DB"));
    }

    @Override
    public Optional<Person> selectPersonbyID(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonbyID(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonbyID(UUID id, Person person) {
        return 0;
    }
}
