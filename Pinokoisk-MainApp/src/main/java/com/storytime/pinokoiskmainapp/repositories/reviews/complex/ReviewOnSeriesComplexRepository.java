package com.storytime.pinokoiskmainapp.repositories.reviews.complex;

import com.storytime.pinokoiskmainapp.dto.AvgRating;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface ReviewOnSeriesComplexRepository {
    Map<Long, AvgRating> findAllSeriesRating(String userRole);
    Optional<AvgRating> findAvgRatingsBySeriesIdAndUserRole(Long movieId, String userRole);
}
