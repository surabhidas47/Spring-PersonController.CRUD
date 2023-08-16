package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRep;

    @PostMapping("/people")
    Person createPerson(@RequestBody Person p){

        return personRep.save(p);
    }

    @GetMapping("people/{id}")
    Person getPerson (@PathVariable Long id){

        return personRep.findOne(id);
    }

    @GetMapping("/people")
    List<Person> getPersonList(){

        return (List<Person>) personRep.findAll();
    }

    @PutMapping("/people")
    Person updatePerson(@RequestBody Person p){

        Person temp = getPerson(p.getId());
        personRep.save(temp);

        return p;
    }

    @DeleteMapping("/people/{id}")
    void DeletePerson(@PathVariable Long id){
        personRep.delete(id);

    }





}
