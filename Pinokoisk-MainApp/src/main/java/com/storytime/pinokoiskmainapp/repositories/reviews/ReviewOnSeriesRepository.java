package com.storytime.pinokoiskmainapp.repositories.reviews;

import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnSeriesEntity;
import com.storytime.pinokoiskmainapp.repositories.reviews.complex.ReviewOnSeriesComplexRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewOnSeriesRepository extends CrudRepository<ReviewOnSeriesEntity, Long>, ReviewOnSeriesComplexRepository {

    Optional<List<ReviewOnSeriesEntity>> findAllByUserId(Long userId);
    Optional<List<ReviewOnSeriesEntity>> findAllBySeriesIdAndUserRole(Long seriesId, String userRole);
//    @Query("SELECT rose.rating FROM ReviewOnSeriesEntity AS rose WHERE rose.series.id = ?1 AND rose.user.role = ?2")
//
//    Optional<List<Short>> findRatingsBySeriesIdAndUserRole(Long movieId, String userRole);
//    @Query("SELECT AVG(rose.rating)FROM ReviewOnSeriesEntity AS rose WHERE rose.series.id = ?1 AND rose.user.role = ?2 GROUP BY rose.series")
//    Optional<Double> findAvgRatingsBySeriesIdAndUserRole(Long movieId, String userRole);
//    @Query("SELECT COUNT(rose.rating) FROM ReviewOnSeriesEntity AS rose WHERE rose.series.id = ?1 AND rose.user.role = ?2 GROUP BY rose.series")
//    Optional<Long> findReviewsCountBySeriesIdAndUserRole(Long movieId, String userRole);

}
