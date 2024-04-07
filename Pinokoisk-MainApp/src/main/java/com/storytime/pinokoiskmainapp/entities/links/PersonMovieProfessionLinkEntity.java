package com.storytime.pinokoiskmainapp.entities.links;

import com.storytime.pinokoiskmainapp.entities.MovieEntity;
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
@Table(name = "persons_on_movies")
public class PersonMovieProfessionLinkEntity extends PersonShowProfessionLink {

    @Id
    @Column(name = "pom_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "movie")
    private MovieEntity movie;

}
