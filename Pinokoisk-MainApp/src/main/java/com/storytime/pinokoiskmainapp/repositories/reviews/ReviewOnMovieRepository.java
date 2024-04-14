package com.storytime.pinokoiskmainapp.repositories.reviews;

import com.storytime.pinokoiskmainapp.dto.AvgRating;
import com.storytime.pinokoiskmainapp.entities.MovieEntity;
import com.storytime.pinokoiskmainapp.entities.UserEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;
import com.storytime.pinokoiskmainapp.repositories.reviews.complex.ReviewOnMovieComplexRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ReviewOnMovieRepository extends CrudRepository<ReviewOnMovieEntity, Long>, ReviewOnMovieComplexRepository {
    Optional<List<ReviewOnMovieEntity>> findAllByUserId(Long userId);
    Optional<List<ReviewOnMovieEntity>> findAllByMovieIdAndUserRole(Long movieId, String userRole);



}
