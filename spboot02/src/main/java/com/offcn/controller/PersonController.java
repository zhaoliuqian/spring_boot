package com.offcn.controller;

import com.offcn.pojo.Person;
import com.offcn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("addPerson")
    public void addPerson(@RequestBody Person person) {
        personService.add(person);
    }

    @GetMapping("getAllPerson")
    public List<Person> getAllPerson() {
        return personService.getAll();
    }

    @GetMapping("getPerson/{id}")
    public Person getPerson(@PathVariable("id") Integer id) {
        return personService.get(id);
    }

    @DeleteMapping("deletePerson/{id}")
    public void deletePerson(@PathVariable("id") Integer id) {
        personService.delete(id);
    }

    @PutMapping("updatePerson")
    public void updatePerson(@RequestBody Person person) {
        personService.update(person);
    }

}

