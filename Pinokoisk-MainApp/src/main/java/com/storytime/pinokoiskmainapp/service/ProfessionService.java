package com.storytime.pinokoiskmainapp.service;

import com.storytime.pinokoiskmainapp.dto.simple.ProfessionDto;
import com.storytime.pinokoiskmainapp.entities.simple.ProfessionEntity;

import java.util.List;

public interface ProfessionService {
    List<ProfessionEntity> findAllProfessions();

    List<ProfessionDto> getAllProfessions();
}