package org.zd.springMVC.dao;

import org.springframework.stereotype.Component;
import org.zd.springMVC.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Tom"));
        people.add(new Person(++PEOPLE_COUNT,"Jon"));
        people.add(new Person(++PEOPLE_COUNT,"Nick"));
        people.add(new Person(++PEOPLE_COUNT,"Mick"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person->person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id) {
        people.removeIf(p->p.getId()==id);
    }
}
