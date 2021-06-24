package com.example.h2dbmemory.controller;

import com.example.h2dbmemory.db.Person;
import com.example.h2dbmemory.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;


    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("{id}")
    public Person getOne(@PathVariable long id) {
        return personService.get(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        personService.delete(id);
    }

    @PostMapping
    public Person create (@RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping("{id}")
    public Person update(@PathVariable long id, @RequestBody Person person) {
        return personService.update(id, person);
    }
}
