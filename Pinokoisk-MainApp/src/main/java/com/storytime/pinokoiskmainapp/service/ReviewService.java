package com.storytime.pinokoiskmainapp.service;

import com.storytime.pinokoiskmainapp.dto.AvgRating;
import com.storytime.pinokoiskmainapp.dto.FullReviewDto;
import com.storytime.pinokoiskmainapp.dto.ReviewOnMovieDto;
import com.storytime.pinokoiskmainapp.dto.ReviewOnSeriesDto;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnSeriesEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;
public interface ReviewService {
//    Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMoviesByUser(Long userId);
    Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMovieByUserRole(Long movieId, String userRole);
    List<FullReviewDto> getAllReviewsOnMovieByCritics(Long movieId);
    List<FullReviewDto> getAllReviewsOnMovieByUsers(Long movieId);
    Optional<AvgRating> findAvgRatingsByMovieAndUserRole(Long movieId, String userRole);
    AvgRating getRatingsByMovieAndCritics(Long movieId);
    AvgRating getRatingsByMovieAndUsers(Long movieId);
    Map<Long,AvgRating> findAllRatingsWithMovieByUserRole(String userRole);
    Map<Long,AvgRating> getAllRatingsWithMovieByUserRole(String userRole);

//    Optional<List<ReviewOnSeriesEntity>> findAllReviewsOnSeriesByUser(Long userId);
//    List<ReviewOnSeriesDto> getAllReviewsOnSeriesByUser(Long userId);
    Optional<List<ReviewOnSeriesEntity>> findAllReviewsOnSeriesByUserRole(Long seriesId, String userRole);
    List<FullReviewDto> getAllReviewsOnSeriesByCritics(Long seriesId);
    List<FullReviewDto> getAllReviewsOnSeriesByUsers(Long seriesId);
    Optional<AvgRating> findAvgRatingsBySeriesAndUserRole(Long movieId, String userRole);
    AvgRating getRatingsBySeriesAndCritics(Long movieId);
    AvgRating getRatingsBySeriesAndUsers(Long movieId);
    Map<Long,AvgRating> findAllRatingsWithSeriesByUserRole(String userRole);
    Map<Long,AvgRating> getAllRatingsWithSeriesByUserRole(String userRole);
    //TODO: implementation and create + delete + update

}
