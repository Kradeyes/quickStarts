package com.example.h2memorytest.controller;

import com.example.h2memorytest.db.Person;
import com.example.h2memorytest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("{id}")
    public Person findById(@PathVariable long id) {
        return personService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        personService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create (@RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping("{id}")
    public Person update(@PathVariable long id, @RequestBody Person person) {
        return personService.update(id, person);
    }
}
