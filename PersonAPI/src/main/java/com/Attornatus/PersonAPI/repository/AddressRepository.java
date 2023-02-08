package com.Attornatus.PersonAPI.repository;

import com.Attornatus.PersonAPI.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, Long> {
    List findByPersonIdAndPrincipalTrue(Long id);
    List findByPersonId(Long id);
}
