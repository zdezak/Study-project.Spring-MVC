package org.zd.springMVC.dao;

import org.springframework.stereotype.Component;
import org.zd.springMVC.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(1,"Tom"));
        people.add(new Person(2,"Jon"));
        people.add(new Person(3,"Nick"));
        people.add(new Person(4,"Mick"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person->person.getId() == id).findAny().orElse(null);
    }
}
