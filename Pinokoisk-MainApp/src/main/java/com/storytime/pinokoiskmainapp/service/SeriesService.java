package com.storytime.pinokoiskmainapp.service;

import com.storytime.pinokoiskmainapp.dto.SeriesDto;
import com.storytime.pinokoiskmainapp.entities.SeriesEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SeriesService {
    List<SeriesEntity> findAll();

    List<SeriesDto> getAllSeries();

    Optional<SeriesEntity> findOne(Long seriesId);

    SeriesDto getOne(Long seriesId);

    Optional<List<SeriesEntity>> findSeriesByGenre(Long genreId);

    List<SeriesDto> getSeriesByGenre(Long genreId);

    String delete(Long id);

    String remove(Long id);

    Optional<List<SeriesEntity>> findSeriesByStreaming(Long streamingId);

    List<SeriesDto> getSeriesByStreaming(Long streamingId);

    Optional<List<SeriesEntity>> findSeriesByPremiereDateBetween(LocalDateTime start, LocalDateTime end);

    List<SeriesDto> getSeriesByPremiereDateByYear(Integer year);

    Optional<List<SeriesEntity>> findSeriesByAgeRestrictions(Long ageRestrictionsId);

    List<SeriesDto> getSeriesByAgeRestrictions(Long ageRestrictionsId);

    Optional<List<SeriesEntity>> findSeriesByPerson(Long personId);

    List<SeriesDto> getSeriesByPerson(Long personId);

    Optional<List<SeriesEntity>> findSeriesByProfessionAndPerson(Long professionId, Long personId);

    List<SeriesDto> getSeriesByProfessionAndPerson(Long professionId, Long personId);
}
