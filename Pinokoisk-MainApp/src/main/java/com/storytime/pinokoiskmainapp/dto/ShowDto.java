package com.storytime.pinokoiskmainapp.dto;

import com.storytime.pinokoiskmainapp.dto.simple.AgeRestrictionsDto;
import com.storytime.pinokoiskmainapp.dto.simple.GenreDto;
import com.storytime.pinokoiskmainapp.dto.simple.ProfessionDto;
import com.storytime.pinokoiskmainapp.dto.simple.StreamingDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public abstract class ShowDto {
    private Long id;
    private String name;
    private String originalName;
    private StreamingDto streaming;
    private String tagline;
    private LocalDateTime premiereDate;
    private AgeRestrictionsDto ageRestrictions;
    private String poster;
    private List<GenreDto> genres;
    private HashMap<ProfessionDto, List<SimplePersonDto>> persons;
}
