package com.storytime.pinokoiskmainapp.mappers.impl.simple;

import com.storytime.pinokoiskmainapp.dto.simple.GenreDto;
import com.storytime.pinokoiskmainapp.entities.simple.GenreEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper implements Mapper<GenreEntity, GenreDto> {
    @Override
    public GenreDto mapTo(GenreEntity genreEntity) {
        return new GenreDto(genreEntity.getId(), genreEntity.getGenre());

    }

    @Override
    public GenreEntity mapFrom(GenreDto genreDto) {
        return null;

    }
}