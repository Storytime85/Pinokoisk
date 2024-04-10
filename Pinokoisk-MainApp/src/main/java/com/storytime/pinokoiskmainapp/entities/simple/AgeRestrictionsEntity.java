package com.storytime.pinokoiskmainapp.entities.simple;

import com.storytime.pinokoiskmainapp.entities.MovieEntity;
import com.storytime.pinokoiskmainapp.entities.SeriesEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

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

    @Column(name = "name")
    private String restrictions;

    @OneToMany(mappedBy = "ageRestrictions")
    private List<MovieEntity> movies;
    @OneToMany(mappedBy = "ageRestrictions")
    private List<SeriesEntity> series;
}
