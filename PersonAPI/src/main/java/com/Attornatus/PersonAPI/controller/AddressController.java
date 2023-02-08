package com.Attornatus.PersonAPI.controller;

import java.util.List;

import com.Attornatus.PersonAPI.model.AddressModel;
import com.Attornatus.PersonAPI.repository.AddressRepository;
import com.Attornatus.PersonAPI.repository.PersonRepository;
import com.Attornatus.PersonAPI.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List getByIdAddressPerson(@PathVariable Long id) {
        return addressRepository.findByPersonId(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressModel addAddress(@RequestBody AddressModel addressModel) {
        return addressService.addressPrincipalValue(addressModel);
    }
}
