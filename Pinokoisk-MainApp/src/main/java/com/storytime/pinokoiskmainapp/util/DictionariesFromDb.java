package com.storytime.pinokoiskmainapp.util;

import com.storytime.pinokoiskmainapp.dto.simple.AgeRestrictionsDto;
import com.storytime.pinokoiskmainapp.dto.simple.GenreDto;
import com.storytime.pinokoiskmainapp.dto.simple.ProfessionDto;
import com.storytime.pinokoiskmainapp.dto.simple.StreamingDto;
import com.storytime.pinokoiskmainapp.service.impl.DictionaryService;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Component
public class DictionariesFromDb {
    @Getter(AccessLevel.NONE)
    private final DictionaryService dictionaryService;
    private final Map<Long, String> ageRestrictions;
    private final Map<Long, String> genres;
    private final Map<Long, String> professions;
    private final Map<Long, String> streamings;

    @Autowired
    public DictionariesFromDb(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
        ageRestrictions = dictionaryService.getAllRestrictions().stream().
                collect(Collectors.toMap(AgeRestrictionsDto::getId, AgeRestrictionsDto::getName));
        genres = dictionaryService.getAllGenres().stream().
                collect(Collectors.toMap(GenreDto::getId, GenreDto::getName));
        professions = dictionaryService.getAllProfessions().stream().
                collect(Collectors.toMap(ProfessionDto::getId, ProfessionDto::getName));
        streamings = dictionaryService.getAllStreamings().stream().
                collect(Collectors.toMap(StreamingDto::getId, StreamingDto::getName));

    }
}
