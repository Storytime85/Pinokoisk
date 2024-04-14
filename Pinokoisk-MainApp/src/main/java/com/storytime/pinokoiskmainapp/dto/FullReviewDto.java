package com.storytime.pinokoiskmainapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullReviewDto {
    private short rating;
    private ReviewDto review;
    private Long userId;
    private String username;
    public FullReviewDto getFullReviewDto(){
        return this;
    }
}
