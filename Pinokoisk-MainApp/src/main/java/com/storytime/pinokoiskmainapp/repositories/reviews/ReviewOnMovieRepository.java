package com.storytime.pinokoiskmainapp.repositories.reviews;

import com.storytime.pinokoiskmainapp.entities.UserEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewOnMovieRepository extends CrudRepository<ReviewOnMovieEntity, Long> {
    Optional<List<ReviewOnMovieEntity>> findAllByUserId(Long userId);

    Optional<List<ReviewOnMovieEntity>> findAllByMovieId(Long userId);

//    Optional<List<Short>> findRatingsByMovieId(Long MovieId);

}
