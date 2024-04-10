package com.storytime.pinokoiskmainapp.mappers.impl;

import com.storytime.pinokoiskmainapp.dto.UserDto;
import com.storytime.pinokoiskmainapp.entities.UserEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;

public class UserMapper implements Mapper<UserEntity, UserDto> {
    @Override
    public UserDto mapTo(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserEntity mapFrom(UserDto userDto) {
        return null;
    }
}
