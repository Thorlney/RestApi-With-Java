package Solidworks.com.demo.dao;

import Solidworks.com.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("FakeDAO")
public class FakePersonDataAcessService implements PersonDao  {
    private  static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
      }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonbyID(UUID id) {

        return DB.stream().filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonbyID(UUID id) {
        Optional<Person> personMaybe = selectPersonbyID(id);
        if (personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonbyID(UUID id, Person update) {
        return selectPersonbyID(id).map(person -> {
            int indexofPersonToUpdate = DB.indexOf(person);
            if (indexofPersonToUpdate >= 0) {
                DB.set(indexofPersonToUpdate,new Person(id, update.getName()));
                return 1;
            }
            return 0;

        })
                .orElse(0 );
    }


}
