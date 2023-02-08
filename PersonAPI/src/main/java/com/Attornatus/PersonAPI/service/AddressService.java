package com.Attornatus.PersonAPI.service;

import com.Attornatus.PersonAPI.model.AddressModel;
import com.Attornatus.PersonAPI.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public AddressModel addressPrincipalValue(AddressModel addressModel) {
        addressModel.setPrincipal(true);
        Long idPerson = addressModel.getPerson().getId();
        List<AddressModel> addreslList = addressRepository.findByPersonIdAndPrincipalTrue(idPerson);
        if (addreslList.size() > 0) {
            addreslList.forEach(el -> {
                el.setPrincipal(false);
                addressRepository.save(el);
            });
        }
        return addressRepository.save(addressModel);
    }
}
