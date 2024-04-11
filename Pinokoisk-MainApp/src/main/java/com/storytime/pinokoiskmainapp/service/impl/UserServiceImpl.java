package com.storytime.pinokoiskmainapp.service.impl;

import com.storytime.pinokoiskmainapp.dto.UserDto;
import com.storytime.pinokoiskmainapp.entities.UserEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import com.storytime.pinokoiskmainapp.mappers.impl.UserMapper;
import com.storytime.pinokoiskmainapp.repositories.UserRepository;
import com.storytime.pinokoiskmainapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final Mapper<UserEntity,UserDto> userMapper;

    @Override
    public Optional<UserEntity> findUser(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public UserDto getUser(Long userId) {
        return findUser(userId).map(userMapper::mapTo).orElse(null);
    }


    @Override
    public Optional<List<UserEntity>> findAllUsersWithReviewsOnMovie(Long movieId) {
        return userRepository.findUserEntitiesByReviewsWithMovieId(movieId);
    }

    @Override
    public List<UserDto> getAllUsersWithReviewsOnMovie(Long movieId) {
        return findAllUsersWithReviewsOnMovie(movieId).map(
                (e) -> e.stream().map(userMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }

    @Override
    public Optional<List<UserEntity>> findAllUsersWithReviewsOnSeries(Long seriesId) {
        return userRepository.findUserEntitiesByReviewsWithSeriesId(seriesId);
    }

    @Override
    public List<UserDto> getAllUsersWithReviewsOnSeries(Long seriesId) {
        return findAllUsersWithReviewsOnSeries(seriesId).map(
                (e) -> e.stream().map(userMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }

}
