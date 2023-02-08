package com.Attornatus.PersonAPI.controller;

import java.util.List;
import java.util.Optional;

import com.Attornatus.PersonAPI.model.PersonModel;
import com.Attornatus.PersonAPI.repository.PersonRepository;
import com.Attornatus.PersonAPI.service.PersonService;
import com.Attornatus.PersonAPI.utils.ObjResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonModel> getAllPersons() {
        return personRepository.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PersonModel> getByIdPerson(@PathVariable Long id) {
        return personRepository.findById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ObjResponse addPerson(@RequestBody PersonModel personModel) {
        return personService.verifyDuplicate(personModel);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PersonModel editPerson(@RequestBody PersonModel personModel) {
        return personRepository.save(personModel);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }
}
