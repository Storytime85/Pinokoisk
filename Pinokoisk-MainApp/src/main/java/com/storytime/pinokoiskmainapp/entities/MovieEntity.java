package com.storytime.pinokoiskmainapp.entities;

import com.storytime.pinokoiskmainapp.entities.links.PersonMovieProfessionLinkEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;
import com.storytime.pinokoiskmainapp.entities.simple.GenreEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class MovieEntity extends Show {

    @Id
    @Column(insertable = false, updatable = false, name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "budget")
    private Integer budget;
    @Column(name = "box_office")
    private Integer boxOffice;
    @Column(name = "running_time")
    private Integer runningTime;
    @NotNull
    @Column(name = "online_release")
    private LocalDateTime onlineRelease;
    @ManyToMany
    @JoinTable(
            name = "movies_on_genres",
            joinColumns = {@JoinColumn(name = "movie", referencedColumnName = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre", referencedColumnName = "genre_id")}
    )
    @NotNull
    private List<GenreEntity> genres;
    @OneToMany(mappedBy = "movie")
    private List<PersonMovieProfessionLinkEntity> pmpl;
    @OneToMany(mappedBy = "id")
    private List<ReviewOnMovieEntity> review;

}
