package com.storytime.pinokoiskmainapp.service.impl;

import com.storytime.pinokoiskmainapp.dto.AvgRating;
import com.storytime.pinokoiskmainapp.dto.FullReviewDto;
import com.storytime.pinokoiskmainapp.dto.ReviewOnMovieDto;
import com.storytime.pinokoiskmainapp.dto.ReviewOnSeriesDto;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnSeriesEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import com.storytime.pinokoiskmainapp.repositories.reviews.ReviewOnMovieRepository;
import com.storytime.pinokoiskmainapp.repositories.reviews.ReviewOnSeriesRepository;
import com.storytime.pinokoiskmainapp.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewOnMovieRepository reviewOnMovieRepository;
    private final ReviewOnSeriesRepository reviewOnSeriesRepository;

    private final Mapper<ReviewOnMovieEntity,ReviewOnMovieDto> reviewOnMovieMapper;
    private final Mapper<ReviewOnSeriesEntity,ReviewOnSeriesDto> reviewOnSeriesMapper;


//    @Override
//    public Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMoviesByUser(Long userId) {
//        return reviewOnMovieRepository.findAllByUserId(userId);
//    }
//
//    @Override
//    public Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMovie(Long movieId) {
//        return reviewOnMovieRepository.findAllByMovieId(movieId);
//    }

    @Override
    public Optional<List<ReviewOnMovieEntity>> findAllReviewsOnMovieByUserRole(Long movieId, String userRole) {
        return reviewOnMovieRepository.findAllByMovieIdAndUserRole(movieId, userRole);
    }

    @Override
    public List<FullReviewDto> getAllReviewsOnMovieByCritics(Long movieId) {
        return  findAllReviewsOnMovieByUserRole(movieId,"CRITIC").map(
                (e) -> e.stream().map((obj) -> reviewOnMovieMapper.mapTo(obj).getFullReviewDto()).toList())
                .orElse(new ArrayList<>());
    }

    @Override
    public List<FullReviewDto> getAllReviewsOnMovieByUsers(Long movieId) {
        return  findAllReviewsOnMovieByUserRole(movieId,"USER").map(
                        (e) -> e.stream().map((obj) -> reviewOnMovieMapper.mapTo(obj).getFullReviewDto()).toList())
                .orElse(new ArrayList<>());
    }

    @Override
    public Optional<AvgRating> findAvgRatingsByMovieAndUserRole(Long movieId, String userRole) {
        return reviewOnMovieRepository.findAvgRatingsByMovieIdAndUserRole(movieId,userRole);
    }

    @Override
    public AvgRating getRatingsByMovieAndCritics(Long movieId) {
        return findAvgRatingsByMovieAndUserRole(movieId, "CRITIC").orElse(null);
    }

    @Override
    public AvgRating getRatingsByMovieAndUsers(Long movieId) {
        return findAvgRatingsByMovieAndUserRole(movieId, "USER").orElse(null);
    }

    @Override
    public Map<Long, AvgRating> findAllRatingsWithMovieByUserRole(String userRole) {
        return reviewOnMovieRepository.findAllMoviesRating(userRole);
    }

    @Override
    public Map<Long, AvgRating> getAllRatingsWithMovieByUserRole(String userRole) {
        return findAllRatingsWithMovieByUserRole(userRole);
    }

    @Override
    public Optional<List<ReviewOnSeriesEntity>> findAllReviewsOnSeriesByUserRole(Long seriesId, String userRole) {
        return reviewOnSeriesRepository.findAllBySeriesIdAndUserRole(seriesId, userRole);
    }

    @Override
    public List<FullReviewDto> getAllReviewsOnSeriesByCritics(Long seriesId) {
        return  findAllReviewsOnSeriesByUserRole(seriesId,"CRITIC").map(
                        (e) -> e.stream().map((obj) -> reviewOnSeriesMapper.mapTo(obj).getFullReviewDto()).toList())
                .orElse(new ArrayList<>());
    }

    @Override
    public List<FullReviewDto> getAllReviewsOnSeriesByUsers(Long seriesId) {
        return  findAllReviewsOnSeriesByUserRole(seriesId,"USER").map(
                        (e) -> e.stream().map((obj) -> reviewOnSeriesMapper.mapTo(obj).getFullReviewDto()).toList())
                .orElse(new ArrayList<>());
    }


    @Override
    public Optional<AvgRating> findAvgRatingsBySeriesAndUserRole(Long movieId, String userRole) {
        return reviewOnSeriesRepository.findAvgRatingsBySeriesIdAndUserRole(movieId,userRole);
    }

    @Override
    public AvgRating getRatingsBySeriesAndCritics(Long movieId) {
        return findAvgRatingsBySeriesAndUserRole(movieId, "CRITIC").orElse(null);
    }

    @Override
    public AvgRating getRatingsBySeriesAndUsers(Long movieId) {
        return findAvgRatingsBySeriesAndUserRole(movieId, "USER").orElse(null);
    }

    @Override
    public Map<Long, AvgRating> findAllRatingsWithSeriesByUserRole(String userRole) {
        return reviewOnSeriesRepository.findAllSeriesRating(userRole);
    }

    @Override
    public Map<Long, AvgRating> getAllRatingsWithSeriesByUserRole(String userRole) {
        return findAllRatingsWithSeriesByUserRole(userRole);
    }
//
//    @Override
//    public List<ReviewOnSeriesDto> getAllReviewsOnSeriesByUser(Long userId) {
//        return findAllReviewsOnSeries(userId).map(
//                (e) -> e.stream().map(reviewOnSeriesMapper::mapTo).toList()
//        ).orElse(new ArrayList<>());
//    }

//    @Override
//    public Optional<List<ReviewOnSeriesEntity>> findAllReviewsOnSeries(Long seriesId) {
//        return reviewOnSeriesRepository.findAllBySeriesId(seriesId);
//    }
//
//    @Override
//    public List<ReviewOnSeriesDto> getAllReviewsOnSeries(Long seriesId) {
//        return findAllReviewsOnSeries(seriesId).map(
//                (e) -> e.stream().map(reviewOnSeriesMapper::mapTo).toList()
//        ).orElse(new ArrayList<>());
//    }

//    @Override
//    public Optional<Double> findAvgRatingsBySeriesAndUserRole(Long seriesId, String userRole) {
//        return reviewOnSeriesRepository.findAvgRatingsBySeriesIdAndUserRole(seriesId, userRole);
//
//    }
//
//    @Override
//    public Optional<Long> findCountRatingsBySeriesAndUserRole(Long seriesId, String userRole) {
//        return reviewOnSeriesRepository.findReviewsCountBySeriesIdAndUserRole(seriesId, userRole);
//    }
//
//
//    @Override
//    public AvgRating getRatingsBySeriesAndCritics(Long seriesId) {
//        Double avgRating = findAvgRatingsBySeriesAndUserRole(seriesId, "CRITIC").orElse(null);
//        Long count = findCountRatingsBySeriesAndUserRole(seriesId, "CRITIC").orElse(null);
//        if (avgRating != null && count !=null ){
//            return new AvgRating(avgRating,count);
//        } else {
//            return null;
//        }
//    }
//    @Override
//    public AvgRating getRatingsBySeriesAndUsers(Long seriesId) {
//        Double avgRating = findAvgRatingsBySeriesAndUserRole(seriesId, "USER").orElse(null);
//        Long count = findCountRatingsBySeriesAndUserRole(seriesId, "USER").orElse(null);
//        if (avgRating != null && count !=null ){
//            return new AvgRating(avgRating,count);
//        } else {
//            return null;
//        }
//    }


}
