package com.storytime.pinokoiskmainapp.entities.links;

import com.storytime.pinokoiskmainapp.entities.SeriesEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons_on_series")
public class PersonSeriesProfessionLinkEntity extends PersonShowProfessionLink {

    @Id
    @Column(name = "pos_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "series")
    private SeriesEntity series;


}
