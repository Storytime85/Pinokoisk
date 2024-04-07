package com.storytime.pinokoiskmainapp.mappers.impl;

import com.storytime.pinokoiskmainapp.dto.MovieDto;
import com.storytime.pinokoiskmainapp.dto.SimplePersonDto;
import com.storytime.pinokoiskmainapp.dto.simple.ProfessionDto;
import com.storytime.pinokoiskmainapp.entities.MovieEntity;
import com.storytime.pinokoiskmainapp.entities.links.PersonMovieProfessionLinkEntity;
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
public class MovieMapper extends ShowMapper implements Mapper<MovieEntity, MovieDto> {

    public MovieMapper(GenreMapper genreMapper, AgeRestrictionsMapper ageRestrictionsMapper, StreamingMapper streamingMapper, ProfessionMapper professionMapper) {
        super(genreMapper, ageRestrictionsMapper, streamingMapper, professionMapper);
    }

    @Override
    public MovieDto mapTo(MovieEntity movieEntity) {
        return new MovieDto(
                movieEntity.getId(),
                movieEntity.getName(),
                movieEntity.getOriginalName(),
                streamingMapper.mapTo(movieEntity.getStreaming()),
                movieEntity.getTagline(),
                movieEntity.getPremiereDate(),
                ageRestrictionsMapper.mapTo(movieEntity.getAgeRestrictions()),
                movieEntity.getPoster(),
                mapGenres(movieEntity.getGenres()),
                mapPersons(movieEntity.getPmpl()),
                movieEntity.getBudget(),
                movieEntity.getBoxOffice(),
                movieEntity.getRunningTime(),
                movieEntity.getOnlineRelease()
        );
    }

    protected HashMap<ProfessionDto, List<SimplePersonDto>> mapPersons(
            List<PersonMovieProfessionLinkEntity> pmpl) {
        HashMap<ProfessionDto, List<SimplePersonDto>> map = new HashMap<>();
        for (PersonMovieProfessionLinkEntity m : pmpl) {
            ProfessionDto professionDto = professionMapper.mapTo(m.getProfession());
            map.computeIfAbsent(professionDto, k -> new ArrayList<>()).
                    add(new SimplePersonDto(m.getPerson().getId(), m.getPerson().getName()));
        }
        return map;
    }

    @Override
    public MovieEntity mapFrom(MovieDto movieDto) {
        return null;

    }
}
