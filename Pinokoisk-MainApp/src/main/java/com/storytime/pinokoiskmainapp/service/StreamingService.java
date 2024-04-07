package com.storytime.pinokoiskmainapp.service;

import com.storytime.pinokoiskmainapp.dto.simple.StreamingDto;
import com.storytime.pinokoiskmainapp.entities.simple.StreamingEntity;

import java.util.List;

public interface StreamingService {
    List<StreamingEntity> findAllStreamings();

    List<StreamingDto> getAllStreamings();
}