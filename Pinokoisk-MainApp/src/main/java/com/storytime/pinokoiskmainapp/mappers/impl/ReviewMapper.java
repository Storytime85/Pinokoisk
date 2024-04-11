package com.storytime.pinokoiskmainapp.mappers.impl;

import com.storytime.pinokoiskmainapp.dto.ReviewDto;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper implements Mapper<ReviewEntity, ReviewDto> {
    @Override
    public ReviewDto mapTo(ReviewEntity reviewEntity) {
        return new ReviewDto(
                reviewEntity.getId(),
                reviewEntity.getHeader(),
                reviewEntity.getBody()
        );
    }

    @Override
    public ReviewEntity mapFrom(ReviewDto reviewDto) {
        return null;
    }
}
