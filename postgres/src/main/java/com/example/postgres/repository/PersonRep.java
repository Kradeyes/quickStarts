package com.example.postgres.repository;

import com.example.postgres.db.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRep extends CrudRepository<Person, Long> {
}
