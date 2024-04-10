package com.storytime.pinokoiskmainapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewOnSeriesDto {
    private Long id;
    private short rating;
    private ReviewDto review;
    private Long seriesId;
    private String seriesName;
    private Long userId;
    private String userName;
}
