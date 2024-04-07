package com.storytime.pinokoiskmainapp.entities;

import com.storytime.pinokoiskmainapp.entities.links.PersonMovieProfessionLinkEntity;
import com.storytime.pinokoiskmainapp.entities.links.PersonSeriesProfessionLinkEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    @NotNull
    private LocalDateTime birthday;
    @Column(name = "birthplace")
    @NotNull
    private String birthplace;
    @Column
    private String photo;
    @OneToMany(mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonMovieProfessionLinkEntity> pmpl;
    @OneToMany(mappedBy = "person", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonSeriesProfessionLinkEntity> pspl;
    //TODO: ФОТО
}
