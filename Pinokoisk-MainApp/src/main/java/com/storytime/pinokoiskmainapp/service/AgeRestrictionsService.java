package com.storytime.pinokoiskmainapp.service;

import com.storytime.pinokoiskmainapp.dto.simple.AgeRestrictionsDto;
import com.storytime.pinokoiskmainapp.entities.simple.AgeRestrictionsEntity;

import java.util.List;

public interface AgeRestrictionsService {
    List<AgeRestrictionsEntity> findAllRestrictions();

    List<AgeRestrictionsDto> getAllRestrictions();

}
