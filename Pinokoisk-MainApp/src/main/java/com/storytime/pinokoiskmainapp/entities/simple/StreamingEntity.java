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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "streamings")
public class StreamingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "streaming_id")
    private Long id;

    @NotNull
    @Size(max = 20, message = "Слишком длинное название")
    @Column(name = "name")
    private String streamingService;

    @OneToMany(mappedBy = "streaming")
    private List<MovieEntity> movies;
    @OneToMany(mappedBy = "streaming")
    private List<SeriesEntity> series;
}
