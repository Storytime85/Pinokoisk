package com.storytime.pinokoiskmainapp.service;

import com.storytime.pinokoiskmainapp.dto.simple.GenreDto;
import com.storytime.pinokoiskmainapp.entities.simple.GenreEntity;

import java.util.List;

public interface GenreService {
    List<GenreEntity> findAllGenres();

    List<GenreDto> getAllGenres();

}