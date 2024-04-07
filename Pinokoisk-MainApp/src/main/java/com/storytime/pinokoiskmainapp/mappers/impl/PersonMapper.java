package com.storytime.pinokoiskmainapp.mappers.impl;

import com.storytime.pinokoiskmainapp.dto.PersonDto;
import com.storytime.pinokoiskmainapp.dto.SimpleMovieDto;
import com.storytime.pinokoiskmainapp.dto.SimpleSeriesDto;
import com.storytime.pinokoiskmainapp.dto.simple.GenreDto;
import com.storytime.pinokoiskmainapp.dto.simple.ProfessionDto;
import com.storytime.pinokoiskmainapp.entities.PersonEntity;
import com.storytime.pinokoiskmainapp.entities.links.PersonMovieProfessionLinkEntity;
import com.storytime.pinokoiskmainapp.entities.links.PersonSeriesProfessionLinkEntity;
import com.storytime.pinokoiskmainapp.entities.simple.GenreEntity;
import com.storytime.pinokoiskmainapp.entities.simple.ProfessionEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import com.storytime.pinokoiskmainapp.mappers.impl.simple.ProfessionMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PersonMapper implements Mapper<PersonEntity, PersonDto> {

    private final Mapper<ProfessionEntity, ProfessionDto> professionMapper;
    private final Mapper<GenreEntity, GenreDto> genreMapper;

    public PersonMapper(ProfessionMapper professionMapper, Mapper<GenreEntity, GenreDto> genreMapper) {
        this.professionMapper = professionMapper;
        this.genreMapper = genreMapper;
    }

    @Override
    public PersonDto mapTo(PersonEntity personEntity) {
        return new PersonDto(
                personEntity.getId(),
                personEntity.getName(),
                personEntity.getBirthday(),
                personEntity.getBirthplace(),
                personEntity.getPhoto(),
                pmplToSimpleMovieDTO(personEntity.getPmpl()),
                psplToSimpleMovieDTO(personEntity.getPspl()));
    }

    //region Don't like this solution, maybe needs more elegant approach
    private List<SimpleMovieDto> pmplToSimpleMovieDTO(List<PersonMovieProfessionLinkEntity> pmpl) {
        Map<Entry, List<ProfessionDto>> professionMap = new HashMap<>();
        Map<Entry, List<GenreDto>> genreMap = new HashMap<>();
        pmpl.forEach((l) -> {
            Entry entry = new Entry(l.getMovie().getId(), l.getMovie().getName(), l.getMovie().getOriginalName());
            List<ProfessionDto> temp = professionMap.containsKey(entry) ? professionMap.get(entry) : new ArrayList<>();
            temp.add(professionMapper.mapTo(l.getProfession()));
            professionMap.put(entry, temp);
            if (!genreMap.containsKey(entry)) {
                genreMap.put(entry, l.getMovie().getGenres().stream().map(genreMapper::mapTo).toList());
            }
        });
        List<SimpleMovieDto> list = new ArrayList<>();
        professionMap.forEach((v, k) -> {
            list.add(new SimpleMovieDto(v.id, v.name, v.originalName, genreMap.get(v), k));
        });
        return list;
    }

    private List<SimpleSeriesDto> psplToSimpleMovieDTO(List<PersonSeriesProfessionLinkEntity> pspl) {
        Map<Entry, List<ProfessionDto>> professionMap = new HashMap<>();
        Map<Entry, List<GenreDto>> genreMap = new HashMap<>();
        pspl.forEach((l) -> {
            Entry entry = new Entry(l.getSeries().getId(), l.getSeries().getName(), l.getSeries().getOriginalName());
            List<ProfessionDto> temp = professionMap.containsKey(entry) ? professionMap.get(entry) : new ArrayList<>();
            temp.add(professionMapper.mapTo(l.getProfession()));
            professionMap.put(entry, temp);
            if (!genreMap.containsKey(entry)) {
                genreMap.put(entry, l.getSeries().getGenres().stream().map(genreMapper::mapTo).toList());
            }
        });
        List<SimpleSeriesDto> list = new ArrayList<>();
        professionMap.forEach((v, k) -> {
            list.add(new SimpleSeriesDto(v.id, v.name, v.originalName, genreMap.get(v), k));
        });
        return list;
    }


    //endregion
    @Override
    public PersonEntity mapFrom(PersonDto personDto) {
        //TODO: TEMP
        return null;
    }

    @Data
    @AllArgsConstructor
    @EqualsAndHashCode
    private static class Entry {
        Long id;
        String name;
        String originalName;
    }
}
