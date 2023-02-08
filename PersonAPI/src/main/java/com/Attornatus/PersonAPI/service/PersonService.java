package com.Attornatus.PersonAPI.service;

import com.Attornatus.PersonAPI.model.PersonModel;
import com.Attornatus.PersonAPI.repository.PersonRepository;
import com.Attornatus.PersonAPI.utils.ObjResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    private ObjResponse objResponse = new ObjResponse();
    public ObjResponse verifyDuplicate(PersonModel personModel) {
        List listPerson = personRepository.findByName(personModel.getName());
        if (listPerson.size() != 0) {
            objResponse.setMessage("Pessoa já cadastrada !!!");
        } else {
            personRepository.save(personModel);
            objResponse.setMessage("Pessoa cadastrada com sucesso !!!");
        }
        return objResponse;
    }
}
