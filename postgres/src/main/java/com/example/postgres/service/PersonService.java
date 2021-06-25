package com.example.postgres.service;

import com.example.postgres.db.Person;
import com.example.postgres.repository.PersonRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRep repository;

    public Person create(Person person) {
        return repository.save(person);
    }

    public Person update(long id, Person person) {
        Optional<Person> optionalPersonPerson = repository.findById(id);
        Person updatedPerson  = optionalPersonPerson.get();
        updatedPerson.setName(person.getName());
        return repository.save(updatedPerson);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public Person get(long id) {
        Optional<Person> task = repository.findById(id);
        return task.orElse(null);
    }

    public List<Person> getAll() {
        List<Person> tasks = new ArrayList<>();
        repository.findAll().forEach(tasks::add);
        return tasks;
    }
}