package com.storytime.pinokoiskmainapp.service.impl;

import com.storytime.pinokoiskmainapp.dto.simple.AgeRestrictionsDto;
import com.storytime.pinokoiskmainapp.dto.simple.GenreDto;
import com.storytime.pinokoiskmainapp.dto.simple.ProfessionDto;
import com.storytime.pinokoiskmainapp.dto.simple.StreamingDto;
import com.storytime.pinokoiskmainapp.entities.simple.AgeRestrictionsEntity;
import com.storytime.pinokoiskmainapp.entities.simple.GenreEntity;
import com.storytime.pinokoiskmainapp.entities.simple.ProfessionEntity;
import com.storytime.pinokoiskmainapp.entities.simple.StreamingEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import com.storytime.pinokoiskmainapp.repositories.simple.AgeRestrictionsRepository;
import com.storytime.pinokoiskmainapp.repositories.simple.GenreRepository;
import com.storytime.pinokoiskmainapp.repositories.simple.ProfessionRepository;
import com.storytime.pinokoiskmainapp.repositories.simple.StreamingRepository;
import com.storytime.pinokoiskmainapp.service.AgeRestrictionsService;
import com.storytime.pinokoiskmainapp.service.GenreService;
import com.storytime.pinokoiskmainapp.service.ProfessionService;
import com.storytime.pinokoiskmainapp.service.StreamingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DictionaryService implements AgeRestrictionsService, GenreService, ProfessionService, StreamingService {
    private final AgeRestrictionsRepository ageRestrictionsRepository;
    private final GenreRepository genreRepository;
    private final ProfessionRepository professionRepository;
    private final StreamingRepository streamingRepository;

    private final Mapper<AgeRestrictionsEntity, AgeRestrictionsDto> ageRestrictionsMapper;
    private final Mapper<GenreEntity, GenreDto> genreMapper;
    private final Mapper<ProfessionEntity, ProfessionDto> professionMapper;
    private final Mapper<StreamingEntity, StreamingDto> streamingMapper;

    @Override
    public List<AgeRestrictionsEntity> findAllRestrictions() {
        return ageRestrictionsRepository.findAll();
    }

    @Override
    public List<AgeRestrictionsDto> getAllRestrictions() {
        return findAllRestrictions().stream().map(ageRestrictionsMapper::mapTo).toList();
    }

    @Override
    public List<GenreEntity> findAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public List<GenreDto> getAllGenres() {
        return findAllGenres().stream().map(genreMapper::mapTo).toList();
    }

    @Override
    public List<ProfessionEntity> findAllProfessions() {
        return professionRepository.findAll();
    }

    @Override
    public List<ProfessionDto> getAllProfessions() {
        return findAllProfessions().stream().map(professionMapper::mapTo).toList();
    }

    @Override
    public List<StreamingEntity> findAllStreamings() {
        return streamingRepository.findAll();
    }

    @Override
    public List<StreamingDto> getAllStreamings() {
        return findAllStreamings().stream().map(streamingMapper::mapTo).toList();
    }
}
