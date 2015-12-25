package com.example.springtest.controller;

import com.example.springtest.model.Address;
import com.example.springtest.model.Person;
import com.example.springtest.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by alexander on 12/24/15.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Resource
    private PersonService personService;

    @RequestMapping(value="/add-person", method = RequestMethod.POST)
    public Person addPerson(@RequestBody Person person) {

        return personService.addPerson(person);
    }

    @RequestMapping(value="/add-address", method = RequestMethod.POST)
    public Person addAddress(@RequestParam int personId, @RequestBody Address address) {
        return personService.addAddress(personId, address);
    }

    @RequestMapping(value="/get-all-persons", method = RequestMethod.GET)
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @RequestMapping(value="/get-person", method = RequestMethod.GET)
    public Person getPerson(@RequestParam int id) {
        return personService.getPerson(id);
    }

}
