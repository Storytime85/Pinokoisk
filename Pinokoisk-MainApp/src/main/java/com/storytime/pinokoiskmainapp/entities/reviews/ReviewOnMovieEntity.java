package com.storytime.pinokoiskmainapp.entities.reviews;

import com.storytime.pinokoiskmainapp.entities.MovieEntity;
import com.storytime.pinokoiskmainapp.entities.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "reviews_on_movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewOnMovieEntity {
    @Id
    @Column(insertable = false, updatable = false, name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="rating")
    @Min(1)
    @Max(10)
    private Short rating;

    @Column
    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie", nullable = false)
    private MovieEntity movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;
}
