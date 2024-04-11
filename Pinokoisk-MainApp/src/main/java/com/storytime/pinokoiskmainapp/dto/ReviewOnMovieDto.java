package com.storytime.pinokoiskmainapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewOnMovieDto {
    private Long id;
    private Short rating;
    private ReviewDto review;
    private Long movieId;
    private String movieName;
    private Long userId;
    private String userName;

}
