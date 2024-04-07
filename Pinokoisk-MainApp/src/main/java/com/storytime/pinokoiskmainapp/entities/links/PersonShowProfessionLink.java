package com.storytime.pinokoiskmainapp.entities.links;

import com.storytime.pinokoiskmainapp.entities.PersonEntity;
import com.storytime.pinokoiskmainapp.entities.simple.ProfessionEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class PersonShowProfessionLink {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "profession")
    private ProfessionEntity profession;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "person")
    private PersonEntity person;
}
