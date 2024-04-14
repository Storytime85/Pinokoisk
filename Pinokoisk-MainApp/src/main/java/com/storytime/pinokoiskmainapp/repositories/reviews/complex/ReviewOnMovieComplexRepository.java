package com.storytime.pinokoiskmainapp.repositories.reviews.complex;

import com.storytime.pinokoiskmainapp.dto.AvgRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ReviewOnMovieComplexRepository {
    Map<Long, AvgRating> findAllMoviesRating(String userRole);
    Optional<AvgRating> findAvgRatingsByMovieIdAndUserRole(Long movieId, String userRole);



}
