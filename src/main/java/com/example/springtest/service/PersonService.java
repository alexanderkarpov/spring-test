package com.example.springtest.service;

import com.example.springtest.model.Address;
import com.example.springtest.model.Person;
import com.example.springtest.persistence.AddressRepository;
import com.example.springtest.persistence.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by alexander on 12/24/15.
 */
@Service
public class PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public Person addPerson(Person person) {
        person.setId(0);
        List<Address> addresses = Optional.ofNullable(person.getAddresses()).orElse(new ArrayList<>());
        addresses.stream().forEach(a -> {
            a.setId(0);
            addressRepository.save(a);
        });
        person.setAddresses(addresses);
        return personRepository.save(person);
    }

    @Transactional
    public Person addAddress(int personId, Address address) {

        Person person = personRepository.findOne(personId);
        if (person == null) {
            throw new IllegalArgumentException("person with id " + personId + " wasn't found");
        }

        address.setId(0);

        List<Address> addresses = Optional.ofNullable(person.getAddresses()).orElse(new ArrayList<>());
        addresses.add(addressRepository.save(address));
        person.setAddresses(addresses);

        return personRepository.save(person);
    }

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    public Person getPerson(int id) {
        return personRepository.findOne(id);
    }

}
