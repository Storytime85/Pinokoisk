package com.storytime.pinokoiskmainapp.repositories;


import com.storytime.pinokoiskmainapp.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
    @Query("SELECT rome.user FROM ReviewOnMovieEntity AS rome where rome.movie.id = ?1")
    Optional<List<UserEntity>> findUserEntitiesByReviewsWithMovieId(Long movieId);
    @Query("SELECT rose.user FROM ReviewOnSeriesEntity AS rose where rose.series.id = ?1")
    Optional<List<UserEntity>> findUserEntitiesByReviewsWithSeriesId(Long seriesId);
}
