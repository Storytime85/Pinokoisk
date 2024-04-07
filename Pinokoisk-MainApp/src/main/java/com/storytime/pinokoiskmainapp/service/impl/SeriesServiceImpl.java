package com.storytime.pinokoiskmainapp.service.impl;


import com.storytime.pinokoiskmainapp.dto.SeriesDto;
import com.storytime.pinokoiskmainapp.entities.SeriesEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import com.storytime.pinokoiskmainapp.repositories.SeriesRepository;
import com.storytime.pinokoiskmainapp.service.SeriesService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class SeriesServiceImpl implements SeriesService {

    private final SeriesRepository seriesRepository;

    private final Mapper<SeriesEntity, SeriesDto> seriesMapper;

    @Override
    @CachePut(cacheNames = {"series"})
    public List<SeriesEntity> findAll() {
        return StreamSupport.stream(seriesRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<SeriesDto> getAllSeries() {
        return findAll().stream().map(seriesMapper::mapTo).toList();
    }

    @Override
    @Cacheable(key = "#seriesId", value = "one_series")
    public Optional<SeriesEntity> findOne(Long seriesId) {
        return seriesRepository.findById(seriesId);
    }

    @Override
    public SeriesDto getOne(Long seriesId) {
        return findOne(seriesId).map(seriesMapper::mapTo).orElse(null);
    }

    @Override
    @CachePut(cacheNames = {"series_by_genre"})
    public Optional<List<SeriesEntity>> findSeriesByGenre(Long genreId) {
        return seriesRepository.findSeriesEntitiesByGenresId(genreId);
    }

    @Override
    public List<SeriesDto> getSeriesByGenre(Long genreId) {
        return findSeriesByGenre(genreId).map((e) -> e.stream().map(seriesMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }

    @Override
    @CacheEvict(cacheNames = "one_series")
    public String delete(Long id) {
        seriesRepository.deleteById(id);
        return "Done.";
    }

    @Override
    public String remove(Long id) {
        return delete(id);
    }

    @Override
    public Optional<List<SeriesEntity>> findSeriesByStreaming(Long id) {
        return seriesRepository.findSeriesEntitiesByStreamingId(id);
    }

    @Override
    public List<SeriesDto> getSeriesByStreaming(Long streamingId) {
        return findSeriesByStreaming(streamingId).map(
                (e) -> e.stream().map(seriesMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }

    @Override
    public Optional<List<SeriesEntity>> findSeriesByPremiereDateBetween(LocalDateTime start, LocalDateTime end) {
        return seriesRepository.findSeriesEntitiesByPremiereDateBetween(start, end);
    }

    @Override
    public List<SeriesDto> getSeriesByPremiereDateByYear(Integer year) {
        return findSeriesByPremiereDateBetween(
                LocalDateTime.of(year, Month.JANUARY, 1, 0, 0, 0),
                LocalDateTime.of(year, Month.DECEMBER, 31, 23, 59, 59))
                .map((e) -> e.stream().map(seriesMapper::mapTo).toList()
                ).orElse(new ArrayList<>());
    }

    @Override
    public Optional<List<SeriesEntity>> findSeriesByAgeRestrictions(Long ageRestrictionsId) {
        return seriesRepository.findSeriesEntitiesByAgeRestrictionsId(ageRestrictionsId);
    }

    @Override
    public List<SeriesDto> getSeriesByAgeRestrictions(Long ageRestrictionsId) {
        return findSeriesByAgeRestrictions(ageRestrictionsId).map(
                (e) -> e.stream().map(seriesMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }

    @Override
    public Optional<List<SeriesEntity>> findSeriesByPerson(Long personId) {
        return seriesRepository.findSeriesByPspl_PersonId(personId);
    }

    @Override
    public List<SeriesDto> getSeriesByPerson(Long personId) {
        return findSeriesByPerson(personId).map(
                (e) -> e.stream().map(seriesMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }

    @Override
    public Optional<List<SeriesEntity>> findSeriesByProfessionAndPerson(Long professionId, Long personId) {
        return seriesRepository.findSeriesByPspl_ProfessionIdAndPspl_PersonId(professionId, personId);
    }

    @Override
    public List<SeriesDto> getSeriesByProfessionAndPerson(Long professionId, Long personId) {
        return findSeriesByProfessionAndPerson(professionId, personId).map(
                (e) -> e.stream().map(seriesMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }
}
