package com.storytime.pinokoiskmainapp.mappers.impl;

import com.storytime.pinokoiskmainapp.dto.ReviewOnSeriesDto;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnSeriesEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import com.storytime.pinokoiskmainapp.service.ReviewContentService;
import org.springframework.stereotype.Component;

@Component
public class ReviewOnSeriesMapper implements Mapper<ReviewOnSeriesEntity, ReviewOnSeriesDto> {
    private final ReviewContentService reviewService;

    public ReviewOnSeriesMapper(ReviewContentService reviewService) {
        this.reviewService = reviewService;
    }


    @Override
    public ReviewOnSeriesDto mapTo(ReviewOnSeriesEntity reviewOnSeriesEntity) {
        return new ReviewOnSeriesDto(
                reviewOnSeriesEntity.getId(),
                reviewOnSeriesEntity.getRating(),
                reviewService.getReviewText(reviewOnSeriesEntity.getReview()),
                reviewOnSeriesEntity.getSeries().getId(),
                reviewOnSeriesEntity.getSeries().getName(),
                reviewOnSeriesEntity.getUser().getId(),
                reviewOnSeriesEntity.getUser().getUserName()
        );
    }

    @Override
    public ReviewOnSeriesEntity mapFrom(ReviewOnSeriesDto reviewOnSeriesDto) {
        return null;
    }
}
