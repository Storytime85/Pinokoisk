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
@Table(name="users", schema = "public")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    @NotNull
    private String username;

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
