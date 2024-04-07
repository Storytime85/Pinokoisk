package com.storytime.pinokoiskmainapp.dto;


import com.storytime.pinokoiskmainapp.dto.simple.AgeRestrictionsDto;
import com.storytime.pinokoiskmainapp.dto.simple.GenreDto;
import com.storytime.pinokoiskmainapp.dto.simple.ProfessionDto;
import com.storytime.pinokoiskmainapp.dto.simple.StreamingDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor

public class MovieDto extends ShowDto {
    private Integer budget;
    private Integer boxOffice;
    private Integer runningTime;
    private LocalDateTime onlineRelease;

    public MovieDto(Long id, String name, String originalName, StreamingDto streaming, String tagline,
                    LocalDateTime premiereDate, AgeRestrictionsDto ageRestrictions, String poster,
                    List<GenreDto> genres, HashMap<ProfessionDto, List<SimplePersonDto>> persons,
                    Integer budget, Integer boxOffice, Integer runningTime, LocalDateTime onlineRelease) {
        super(id, name, originalName, streaming, tagline, premiereDate, ageRestrictions, poster, genres, persons);
        this.budget = budget;
        this.boxOffice = boxOffice;
        this.runningTime = runningTime;
        this.onlineRelease = onlineRelease;
    }
}
