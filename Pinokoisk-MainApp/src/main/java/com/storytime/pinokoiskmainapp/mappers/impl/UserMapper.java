package com.storytime.pinokoiskmainapp.mappers.impl;

import com.storytime.pinokoiskmainapp.dto.UserDto;
import com.storytime.pinokoiskmainapp.entities.UserEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class UserMapper implements Mapper<UserEntity, UserDto> {
    private final ReviewOnMovieMapper reviewOnMovieMapper;
    private final  ReviewOnSeriesMapper reviewOnSeriesMapper;

    public UserMapper(ReviewOnMovieMapper reviewOnMovieMapper, ReviewOnSeriesMapper reviewOnSeriesMapper) {
        this.reviewOnMovieMapper = reviewOnMovieMapper;
        this.reviewOnSeriesMapper = reviewOnSeriesMapper;
    }

    @Override
    public UserDto mapTo(UserEntity userEntity) {
        return new UserDto(
                userEntity.getId(),
                userEntity.getUserName(),
                userEntity.getRole(),
                userEntity.getAvatar(),
                userEntity.getMovieReviews().stream().map(reviewOnMovieMapper::mapTo).collect(Collectors.toList()),
                userEntity.getSeriesReviews().stream().map(reviewOnSeriesMapper::mapTo).collect(Collectors.toList())
        );
    }

    @Override
    public UserEntity mapFrom(UserDto userDto) {
        return null;
    }
}
