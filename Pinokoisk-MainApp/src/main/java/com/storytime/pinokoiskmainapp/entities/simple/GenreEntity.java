package com.storytime.pinokoiskmainapp.entities.simple;


import com.storytime.pinokoiskmainapp.entities.MovieEntity;
import com.storytime.pinokoiskmainapp.entities.SeriesEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "genres")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long id;

    @NotNull
    @Size(max = 20, message = "Слишком длинное название")
    @Column(name = "name")
    private String genre;

    @ManyToMany(mappedBy = "genres")
    private List<MovieEntity> movies;

    @ManyToMany(mappedBy = "genres")
    private List<SeriesEntity> series;
}
