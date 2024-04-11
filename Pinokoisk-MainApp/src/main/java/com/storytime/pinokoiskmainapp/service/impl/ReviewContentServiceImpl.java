package com.storytime.pinokoiskmainapp.service.impl;

import com.storytime.pinokoiskmainapp.dto.ReviewDto;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewEntity;
import com.storytime.pinokoiskmainapp.mappers.impl.ReviewMapper;
import com.storytime.pinokoiskmainapp.repositories.reviews.ReviewRepository;
import com.storytime.pinokoiskmainapp.service.ReviewContentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class ReviewContentServiceImpl implements ReviewContentService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    @Override
    public Optional<ReviewEntity> findReviewText(String reviewId) {
        return reviewRepository.findById(reviewId);
    }

    @Override
    public ReviewDto getReviewText(String reviewId) {
        return findReviewText(reviewId).map(reviewMapper::mapTo).orElse(null);
    }

}
