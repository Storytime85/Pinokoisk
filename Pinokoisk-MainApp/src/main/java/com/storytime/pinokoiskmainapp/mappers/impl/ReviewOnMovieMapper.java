package com.storytime.pinokoiskmainapp.mappers.impl;

import com.storytime.pinokoiskmainapp.dto.ReviewDto;
import com.storytime.pinokoiskmainapp.dto.ReviewOnMovieDto;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import com.storytime.pinokoiskmainapp.service.ReviewService;

public class ReviewOnMovieMapper implements Mapper<ReviewOnMovieEntity, ReviewOnMovieDto> {
    private ReviewService reviewService;

    @Override
    public ReviewOnMovieDto mapTo(ReviewOnMovieEntity reviewOnMovieEntity) {
        return null;
    }

    @Override
    public ReviewOnMovieEntity mapFrom(ReviewOnMovieDto reviewOnMovieDto) {
        return null;
    }
}
