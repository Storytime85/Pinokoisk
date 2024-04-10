package com.storytime.pinokoiskmainapp.entities;


import com.storytime.pinokoiskmainapp.entities.simple.AgeRestrictionsEntity;
import com.storytime.pinokoiskmainapp.entities.simple.StreamingEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Show {

    @Column
    private String name;
    @Column(name = "name_original")
    private String originalName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "streaming", nullable = true)
    private StreamingEntity streaming;
    @Column
    private String tagline;

    @Column
    @NotNull
    private LocalDateTime premiereDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "age_restrictions", nullable = true)
    private AgeRestrictionsEntity ageRestrictions;
    @Column
    private String poster;
    //TODO: Постер
}
