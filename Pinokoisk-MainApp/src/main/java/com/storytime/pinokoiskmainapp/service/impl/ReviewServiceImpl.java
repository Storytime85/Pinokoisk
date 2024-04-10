package com.storytime.pinokoiskmainapp.service.impl;

import com.storytime.pinokoiskmainapp.dto.ReviewOnMovieDto;
import com.storytime.pinokoiskmainapp.dto.ReviewOnSeriesDto;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnSeriesEntity;
import com.storytime.pinokoiskmainapp.repositories.reviews.ReviewOnMovieRepository;
import com.storytime.pinokoiskmainapp.repositories.reviews.ReviewOnSeriesRepository;
import com.storytime.pinokoiskmainapp.repositories.reviews.ReviewRepository;
import com.storytime.pinokoiskmainapp.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewOnMovieRepository reviewOnMovierepository;
    private final ReviewOnSeriesRepository reviewOnSeriesRepository;


    @Override
    public Optional<ReviewOnMovieEntity> findReviewOnMovie(Long reviewId) {
        return Optional.empty();
    }

    @Override
    public ReviewOnMovieDto getReviewOnMovie(Long reviewId) {
        return null;
    }

    @Override
    public Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMovies() {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewOnMovieDto>> getAllReviewsOnMovies() {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMoviesByUser(Long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewOnMovieDto>> getAllReviewsOnMoviesByUser(Long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMovieByMovie(Long movieId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewOnMovieDto>> getAllReviewsOnMovieByMovie(Long movieId) {
        return Optional.empty();
    }

    @Override
    public Optional<ReviewOnSeriesEntity> findReviewOnSeries(Long reviewId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewOnSeriesEntity>> findAllReviewsOnSeries() {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewOnSeriesDto>> getAllReviewsOnSeries(Long seriesId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewOnSeriesEntity>> findAllReviewsOnSeriesByUser(Long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewOnSeriesDto>> getAllReviewsOnSeriesByUser(Long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewOnSeriesEntity>> findAllReviewsOnSeriesBySeries(Long seriesId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewOnSeriesDto>> getAllReviewsOnSeriesBySeries(Long seriesId) {
        return Optional.empty();
    }
}
