package com.storytime.pinokoiskmainapp.service;

import com.storytime.pinokoiskmainapp.dto.ReviewDto;
import com.storytime.pinokoiskmainapp.dto.ReviewOnMovieDto;
import com.storytime.pinokoiskmainapp.dto.UserDto;
import com.storytime.pinokoiskmainapp.entities.UserEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<UserEntity> findUser(Long userId);
    UserDto getUser(Long userId);
    Optional<List<UserEntity>> findAllUsersWithReviewsOnMovie(Long movieId);
    List<UserDto> getAllUsersWithReviewsOnMovie(Long movieId);
    Optional<List<UserEntity>> findAllUsersWithReviewsOnSeries(Long seriesId);
    List<UserDto> getAllUsersWithReviewsOnSeries(Long seriesId);

    //TODO:: implementation + create + delete + update
}
