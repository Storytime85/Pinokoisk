package com.storytime.pinokoiskmainapp.service;

import com.storytime.pinokoiskmainapp.dto.ReviewDto;
import com.storytime.pinokoiskmainapp.dto.ReviewOnMovieDto;
import com.storytime.pinokoiskmainapp.dto.ReviewOnSeriesDto;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnSeriesEntity;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

//    Optional<ReviewOnMovieEntity> findReviewOnMovie(Long reviewId);
//    ReviewOnMovieDto getReviewOnMovie(Long reviewId);
//    Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMovies();
//    List<ReviewOnMovieDto> getAllReviewsOnMovies();
    Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMoviesByUser(Long userId);
    List<ReviewOnMovieDto> getAllReviewsOnMoviesByUser(Long userId);
    Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMovie(Long movieId);
    List<ReviewOnMovieDto> getAllReviewsOnMovie(Long movieId);


//    Optional<ReviewOnSeriesEntity> findReviewOnSeries(Long reviewId);
//    ReviewOnSeriesDto getReviewOnSeries(Long reviewId);
//    Optional<List<ReviewOnSeriesEntity>> findAllReviewsOnSeries();
//    List<ReviewOnSeriesDto> getAllReviewsOnSeries(Long seriesId);
    Optional<List<ReviewOnSeriesEntity>> findAllReviewsOnSeriesByUser(Long userId);
    List<ReviewOnSeriesDto> getAllReviewsOnSeriesByUser(Long userId);
    Optional<List<ReviewOnSeriesEntity>> findAllReviewsOnSeries(Long seriesId);
    List<ReviewOnSeriesDto> getAllReviewsOnSeries(Long seriesId);

    //TODO: implementation and create + delete + update

}
