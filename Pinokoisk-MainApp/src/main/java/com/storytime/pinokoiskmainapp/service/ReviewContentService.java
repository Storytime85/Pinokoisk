package com.storytime.pinokoiskmainapp.service;

import com.storytime.pinokoiskmainapp.dto.ReviewDto;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewEntity;

import java.util.Optional;

public interface ReviewContentService {
    Optional<ReviewEntity> findReviewText(String reviewId);
    ReviewDto getReviewText(String reviewId);

}
