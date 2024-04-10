package com.storytime.pinokoiskmainapp.entities;


import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnSeriesEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String userName;

    @Column
    private String role;

    @Column
    private String avatar;

    @OneToMany(mappedBy = "user")
    private List<ReviewOnMovieEntity> movieReviews;
    @OneToMany(mappedBy = "user")
    private List<ReviewOnSeriesEntity> seriesReviews;
    //TODO:: Аватарка ???
}
