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
    Optional<UserEntity> findUser(Long reviewId);
    UserDto getUser(Long reviewId);
    Optional<List<UserDto>> findAllUsers();
    Optional<List<ReviewOnMovieDto>> getAllUsers();
    Optional<List<UserDto>> findAllUsersWithReviewsOnMovie(Long userId);
    Optional<List<ReviewOnMovieDto>> getAllUsersWithReviewsOnMovie(Long userId);
    Optional<List<UserDto>> findAllUsersWithReviewsOnSeries(Long userId);
    Optional<List<UserDto>> getAllUsersWithReviewsOnSeries(Long userId);

    //TODO:: implementation + create + delete + update
}
