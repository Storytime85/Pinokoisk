package com.storytime.pinokoiskmainapp.service.impl;

import com.storytime.pinokoiskmainapp.dto.ReviewOnMovieDto;
import com.storytime.pinokoiskmainapp.dto.UserDto;
import com.storytime.pinokoiskmainapp.entities.UserEntity;
import com.storytime.pinokoiskmainapp.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public Optional<UserEntity> findUser(Long reviewId) {
        return Optional.empty();
    }

    @Override
    public UserDto getUser(Long reviewId) {
        return null;
    }

    @Override
    public Optional<List<UserDto>> findAllUsers() {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewOnMovieDto>> getAllUsers() {
        return Optional.empty();
    }

    @Override
    public Optional<List<UserDto>> findAllUsersWithReviewsOnMovie(Long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<ReviewOnMovieDto>> getAllUsersWithReviewsOnMovie(Long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<UserDto>> findAllUsersWithReviewsOnSeries(Long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<UserDto>> getAllUsersWithReviewsOnSeries(Long userId) {
        return Optional.empty();
    }
}
