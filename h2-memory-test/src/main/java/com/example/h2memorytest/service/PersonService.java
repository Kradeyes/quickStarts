package com.example.h2memorytest.service;

import com.example.h2memorytest.db.Person;
import com.example.h2memorytest.repository.PersonRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonService {

    private final PersonRep repository;

    @Autowired
    public PersonService(PersonRep repository) {
        this.repository = repository;
    }


    public Person create(Person person) {
        return repository.save(person);
    }


    public Person update(long id, Person person) {
        Optional<Person> optionalPersonPerson = repository.findById(id);
        Person updatedPerson  = optionalPersonPerson.get();
        updatedPerson.setName(person.getName());
        return repository.save(updatedPerson);
    }


    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public Person findById(long id) {
        Optional<Person> task = repository.findById(id);
        return task.orElse(null);
    }

    public List<Person> getAll() {
        List<Person> tasks = new ArrayList<>();
        repository.findAll().forEach(tasks::add);
        return tasks;
    }
}