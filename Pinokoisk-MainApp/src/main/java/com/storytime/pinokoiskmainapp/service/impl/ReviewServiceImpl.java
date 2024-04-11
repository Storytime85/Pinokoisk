package com.storytime.pinokoiskmainapp.service.impl;

import com.storytime.pinokoiskmainapp.dto.ReviewDto;
import com.storytime.pinokoiskmainapp.dto.ReviewOnMovieDto;
import com.storytime.pinokoiskmainapp.dto.ReviewOnSeriesDto;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnSeriesEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import com.storytime.pinokoiskmainapp.mappers.impl.ReviewMapper;
import com.storytime.pinokoiskmainapp.mappers.impl.ReviewOnMovieMapper;
import com.storytime.pinokoiskmainapp.mappers.impl.ReviewOnSeriesMapper;
import com.storytime.pinokoiskmainapp.repositories.reviews.ReviewOnMovieRepository;
import com.storytime.pinokoiskmainapp.repositories.reviews.ReviewOnSeriesRepository;
import com.storytime.pinokoiskmainapp.repositories.reviews.ReviewRepository;
import com.storytime.pinokoiskmainapp.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewOnMovieRepository reviewOnMovieRepository;
    private final ReviewOnSeriesRepository reviewOnSeriesRepository;

    private final Mapper<ReviewOnMovieEntity,ReviewOnMovieDto> reviewOnMovieMapper;
    private final Mapper<ReviewOnSeriesEntity,ReviewOnSeriesDto> reviewOnSeriesMapper;


    @Override
    public Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMoviesByUser(Long userId) {
        return reviewOnMovieRepository.findAllByUserId(userId);
    }

    @Override
    public List<ReviewOnMovieDto> getAllReviewsOnMoviesByUser(Long userId) {
        return findAllReviewsOnMoviesByUser(userId).map(
                (e) -> e.stream().map(reviewOnMovieMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }

    @Override
    public Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMovie(Long movieId) {
        return reviewOnMovieRepository.findAllByMovieId(movieId);
    }

    @Override
    public List<ReviewOnMovieDto> getAllReviewsOnMovie(Long movieId) {
        return findAllReviewsOnMovie(movieId).map(
                (e) -> e.stream().map(reviewOnMovieMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }

    @Override
    public Optional<List<ReviewOnSeriesEntity>> findAllReviewsOnSeriesByUser(Long userId) {
        return reviewOnSeriesRepository.findAllByUserId(userId);
    }

    @Override
    public List<ReviewOnSeriesDto> getAllReviewsOnSeriesByUser(Long userId) {
        return findAllReviewsOnSeries(userId).map(
                (e) -> e.stream().map(reviewOnSeriesMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }

    @Override
    public Optional<List<ReviewOnSeriesEntity>> findAllReviewsOnSeries(Long seriesId) {
        return reviewOnSeriesRepository.findAllBySeriesId(seriesId);
    }

    @Override
    public List<ReviewOnSeriesDto> getAllReviewsOnSeries(Long seriesId) {
        return findAllReviewsOnSeries(seriesId).map(
                (e) -> e.stream().map(reviewOnSeriesMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }


}
