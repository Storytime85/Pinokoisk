package com.storytime.pinokoiskmainapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String userName;
    private String role;
    private String avatar;
    private List<ReviewOnMovieDto> movieReviews;
    private List<ReviewOnSeriesDto> seriesReviews;

//    @OneToMany(mappedBy = "user")
//    private List<ReviewOnMovieEntity> movieReviews;
//    @OneToMany(mappedBy = "user")
//    private List<ReviewOnSeriesEntity> seriesReviews;
}
