package com.example.springtest.persistence;

import com.example.springtest.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by alexander on 12/24/15.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
