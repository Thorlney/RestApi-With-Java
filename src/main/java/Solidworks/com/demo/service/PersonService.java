package Solidworks.com.demo.service;

import Solidworks.com.demo.dao.PersonDao;
import Solidworks.com.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class  PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("PostGres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }
    public Optional<Person> getPersonbyID(UUID id){
        return personDao.selectPersonbyID(id);
    }
    public int deletePerson(UUID id){
        return personDao.deletePersonbyID(id);
    }
    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePersonbyID(id, newPerson);
    }
}
