package com.storytime.pinokoiskmainapp.mappers.impl;

import com.storytime.pinokoiskmainapp.dto.ReviewOnMovieDto;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import com.storytime.pinokoiskmainapp.service.ReviewContentService;
import org.springframework.stereotype.Component;

@Component
public class ReviewOnMovieMapper implements Mapper<ReviewOnMovieEntity, ReviewOnMovieDto> {
    private final ReviewContentService reviewService;

    public ReviewOnMovieMapper(ReviewContentService reviewService) {
        this.reviewService = reviewService;
    }


    @Override
    public ReviewOnMovieDto mapTo(ReviewOnMovieEntity reviewOnMovieEntity) {
        return new ReviewOnMovieDto(
                reviewOnMovieEntity.getId(),
                reviewOnMovieEntity.getRating(),
                reviewService.getReviewText(reviewOnMovieEntity.getReview()),
                reviewOnMovieEntity.getMovie().getId(),
                reviewOnMovieEntity.getMovie().getName(),
                reviewOnMovieEntity.getUser().getId(),
                reviewOnMovieEntity.getUser().getUserName()
        );
    }

    @Override
    public ReviewOnMovieEntity mapFrom(ReviewOnMovieDto reviewOnMovieDto) {
        return null;
    }
}
