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
public class SeriesDto extends ShowDto {
    private Integer avgRunningTime;
    private Integer seasonCount;
    private Integer seriesCount;
    private Integer budgetOnEpisode;

    public SeriesDto(Long id, String name, String originalName, StreamingDto streaming, String tagline,
                     LocalDateTime premiereDate, AgeRestrictionsDto ageRestrictions, String poster,
                     List<GenreDto> genres, HashMap<ProfessionDto, List<SimplePersonDto>> persons,
                     Integer avgRunningTime, Integer seasonCount, Integer seriesCount, Integer budgetOnEpisode) {
        super(id, name, originalName, streaming, tagline, premiereDate, ageRestrictions, poster, genres, persons);
        this.avgRunningTime = avgRunningTime;
        this.seasonCount = seasonCount;
        this.seriesCount = seriesCount;
        this.budgetOnEpisode = budgetOnEpisode;
    }
}
