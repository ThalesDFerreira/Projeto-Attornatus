package com.Attornatus.PersonAPI.repository;

import com.Attornatus.PersonAPI.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {
    List findByName(String name);
}
