package com.storytime.pinokoiskmainapp.entities.simple;


import com.storytime.pinokoiskmainapp.entities.links.PersonMovieProfessionLinkEntity;
import com.storytime.pinokoiskmainapp.entities.links.PersonSeriesProfessionLinkEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "professions")
public class ProfessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profession_id")
    private Long id;

    @NotNull
    @Size(max = 20, message = "Слишком длинное название")
    @Column(name = "name")
    private String profession;

    @OneToMany(mappedBy = "profession", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonMovieProfessionLinkEntity> pmpl;
    @OneToMany(mappedBy = "profession", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonSeriesProfessionLinkEntity> pspl;
}
