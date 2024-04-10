package com.storytime.pinokoiskmainapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private String reviewId;
    private String reviewHeader;
    private String reviewBody;
}
