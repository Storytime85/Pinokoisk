package com.storytime.pinokoiskmainapp.util;

import com.storytime.pinokoiskmainapp.dto.simple.AgeRestrictionsDto;
import com.storytime.pinokoiskmainapp.dto.simple.GenreDto;
import com.storytime.pinokoiskmainapp.dto.simple.ProfessionDto;
import com.storytime.pinokoiskmainapp.dto.simple.StreamingDto;
import com.storytime.pinokoiskmainapp.service.impl.DictionaryServiceImpl;
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
    private final DictionaryServiceImpl dictionaryServiceImpl;
    private final Map<Long, String> ageRestrictions;
    private final Map<Long, String> genres;
    private final Map<Long, String> professions;
    private final Map<Long, String> streamings;

    @Autowired
    public DictionariesFromDb(DictionaryServiceImpl dictionaryServiceImpl) {
        this.dictionaryServiceImpl = dictionaryServiceImpl;
        ageRestrictions = dictionaryServiceImpl.getAllRestrictions().stream().
                collect(Collectors.toMap(AgeRestrictionsDto::getId, AgeRestrictionsDto::getName));
        genres = dictionaryServiceImpl.getAllGenres().stream().
                collect(Collectors.toMap(GenreDto::getId, GenreDto::getName));
        professions = dictionaryServiceImpl.getAllProfessions().stream().
                collect(Collectors.toMap(ProfessionDto::getId, ProfessionDto::getName));
        streamings = dictionaryServiceImpl.getAllStreamings().stream().
                collect(Collectors.toMap(StreamingDto::getId, StreamingDto::getName));

    }
}
