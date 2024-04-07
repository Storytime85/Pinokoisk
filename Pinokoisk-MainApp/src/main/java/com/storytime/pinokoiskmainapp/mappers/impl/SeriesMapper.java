package com.storytime.pinokoiskmainapp.mappers.impl;

import com.storytime.pinokoiskmainapp.dto.SeriesDto;
import com.storytime.pinokoiskmainapp.dto.SimplePersonDto;
import com.storytime.pinokoiskmainapp.dto.simple.ProfessionDto;
import com.storytime.pinokoiskmainapp.entities.SeriesEntity;
import com.storytime.pinokoiskmainapp.entities.links.PersonSeriesProfessionLinkEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import com.storytime.pinokoiskmainapp.mappers.impl.simple.AgeRestrictionsMapper;
import com.storytime.pinokoiskmainapp.mappers.impl.simple.GenreMapper;
import com.storytime.pinokoiskmainapp.mappers.impl.simple.ProfessionMapper;
import com.storytime.pinokoiskmainapp.mappers.impl.simple.StreamingMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class SeriesMapper extends ShowMapper implements Mapper<SeriesEntity, SeriesDto> {

    public SeriesMapper(GenreMapper genreMapper, AgeRestrictionsMapper ageRestrictionsMapper, StreamingMapper streamingMapper, ProfessionMapper professionMapper) {
        super(genreMapper, ageRestrictionsMapper, streamingMapper, professionMapper);
    }

    @Override
    public SeriesDto mapTo(SeriesEntity seriesEntity) {
        return new SeriesDto(
                seriesEntity.getId(),
                seriesEntity.getName(),
                seriesEntity.getOriginalName(),
                streamingMapper.mapTo(seriesEntity.getStreaming()),
                seriesEntity.getTagline(),
                seriesEntity.getPremiereDate(),
                ageRestrictionsMapper.mapTo(seriesEntity.getAgeRestrictions()),
                seriesEntity.getPoster(),
                mapGenres(seriesEntity.getGenres()),
                mapPersons(seriesEntity.getPspl()),
                seriesEntity.getAvgRunningTime(),
                seriesEntity.getSeasonCount(),
                seriesEntity.getSeriesCount(),
                seriesEntity.getBudgetOnEpisode()
        );
    }

    protected HashMap<ProfessionDto, List<SimplePersonDto>> mapPersons(
            List<PersonSeriesProfessionLinkEntity> pspl) {
        HashMap<ProfessionDto, List<SimplePersonDto>> map = new HashMap<>();
        for (PersonSeriesProfessionLinkEntity s : pspl) {
            ProfessionDto professionDto = professionMapper.mapTo(s.getProfession());
            map.computeIfAbsent(professionDto, k -> new ArrayList<>()).
                    add(new SimplePersonDto(s.getPerson().getId(), s.getPerson().getName()));
        }
        return map;
    }

    @Override
    public SeriesEntity mapFrom(SeriesDto seriesDto) {
        return null;
    }
}
