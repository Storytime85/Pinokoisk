package com.storytime.pinokoiskmainapp.service;

import com.storytime.pinokoiskmainapp.dto.ReviewOnMovieDto;
import com.storytime.pinokoiskmainapp.dto.ReviewOnSeriesDto;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnSeriesEntity;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Optional<ReviewOnMovieEntity> findReviewOnMovie(Long reviewId);
    ReviewOnMovieDto getReviewOnMovie(Long reviewId);
    Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMovies();
    Optional<List<ReviewOnMovieDto>> getAllReviewsOnMovies();
    Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMoviesByUser(Long userId);
    Optional<List<ReviewOnMovieDto>> getAllReviewsOnMoviesByUser(Long userId);
    Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMovieByMovie(Long movieId);
    Optional<List<ReviewOnMovieDto>> getAllReviewsOnMovieByMovie(Long movieId);

    Optional<ReviewOnSeriesEntity> findReviewOnSeries(Long reviewId);
    Optional<List<ReviewOnSeriesEntity>> findAllReviewsOnSeries();
    Optional<List<ReviewOnSeriesDto>> getAllReviewsOnSeries(Long seriesId);
    Optional<List<ReviewOnSeriesEntity>> findAllReviewsOnSeriesByUser(Long userId);
    Optional<List<ReviewOnSeriesDto>> getAllReviewsOnSeriesByUser(Long userId);
    Optional<List<ReviewOnSeriesEntity>> findAllReviewsOnSeriesBySeries(Long seriesId);
    Optional<List<ReviewOnSeriesDto>> getAllReviewsOnSeriesBySeries(Long seriesId);

    //TODO: implementation and create + delete + update

}
