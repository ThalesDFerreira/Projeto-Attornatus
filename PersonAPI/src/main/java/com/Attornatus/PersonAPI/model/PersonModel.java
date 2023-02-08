package com.Attornatus.PersonAPI.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "person")
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate birthDate;
    @JsonManagedReference
    @OneToMany(mappedBy= "person", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH })
    private List<AddressModel> address;
}
