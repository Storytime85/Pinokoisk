package com.storytime.pinokoiskmainapp.mappers.impl;

import com.storytime.pinokoiskmainapp.dto.simple.AgeRestrictionsDto;
import com.storytime.pinokoiskmainapp.dto.simple.GenreDto;
import com.storytime.pinokoiskmainapp.dto.simple.ProfessionDto;
import com.storytime.pinokoiskmainapp.dto.simple.StreamingDto;
import com.storytime.pinokoiskmainapp.entities.simple.AgeRestrictionsEntity;
import com.storytime.pinokoiskmainapp.entities.simple.GenreEntity;
import com.storytime.pinokoiskmainapp.entities.simple.ProfessionEntity;
import com.storytime.pinokoiskmainapp.entities.simple.StreamingEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import com.storytime.pinokoiskmainapp.mappers.impl.simple.AgeRestrictionsMapper;
import com.storytime.pinokoiskmainapp.mappers.impl.simple.GenreMapper;
import com.storytime.pinokoiskmainapp.mappers.impl.simple.ProfessionMapper;
import com.storytime.pinokoiskmainapp.mappers.impl.simple.StreamingMapper;

import java.util.List;


public abstract class ShowMapper {
    protected final Mapper<GenreEntity, GenreDto> genreMapper;
    protected final Mapper<AgeRestrictionsEntity, AgeRestrictionsDto> ageRestrictionsMapper;
    protected final Mapper<StreamingEntity, StreamingDto> streamingMapper;
    protected final Mapper<ProfessionEntity, ProfessionDto> professionMapper;

    protected ShowMapper(GenreMapper genreMapper, AgeRestrictionsMapper ageRestrictionsMapper, StreamingMapper streamingMapper, ProfessionMapper professionMapper) {
        this.genreMapper = genreMapper;
        this.ageRestrictionsMapper = ageRestrictionsMapper;
        this.streamingMapper = streamingMapper;
        this.professionMapper = professionMapper;
    }

    protected List<GenreDto> mapGenres(List<GenreEntity> genreEntities) {
        return genreEntities.stream().map(genreMapper::mapTo).toList();
    }


}
