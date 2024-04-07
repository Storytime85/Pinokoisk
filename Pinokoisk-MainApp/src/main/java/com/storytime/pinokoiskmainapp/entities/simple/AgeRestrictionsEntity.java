package com.storytime.pinokoiskmainapp.entities.simple;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "age_restrictions")
public class AgeRestrictionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "age_restriction_id")
    private Long id;

    @NotNull
    @Size(max = 20, message = "Слишком длинное название")
    @Column(name = "name")
    private String restrictions;
}
