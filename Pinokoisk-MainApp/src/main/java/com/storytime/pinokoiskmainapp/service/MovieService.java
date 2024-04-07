package com.storytime.pinokoiskmainapp.service;

import com.storytime.pinokoiskmainapp.dto.MovieDto;
import com.storytime.pinokoiskmainapp.entities.MovieEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieEntity> findAll();

    List<MovieDto> getAllMovies();

    Optional<MovieEntity> findOne(Long movieId);

    MovieDto getOne(Long movieId);

    Optional<List<MovieEntity>> findMoviesByGenre(Long genreId);

    List<MovieDto> getMoviesByGenre(Long genreId);

    String delete(Long id);

    String remove(Long id);

    Optional<List<MovieEntity>> findMovieByStreaming(Long streamingId);

    List<MovieDto> getMoviesByStreaming(Long streamingId);

    Optional<List<MovieEntity>> findMovieByPremiereDateBetween(LocalDateTime start, LocalDateTime end);

    List<MovieDto> getMoviesByPremiereDateByYear(Integer year);

    Optional<List<MovieEntity>> findMovieByAgeRestrictions(Long ageRestrictionsId);

    List<MovieDto> getMoviesByAgeRestrictions(Long ageRestrictionsId);

    Optional<List<MovieEntity>> findMovieByPerson(Long personId);

    List<MovieDto> getMovieByPerson(Long personId);

    Optional<List<MovieEntity>> findMovieByProfessionAndPerson(Long professionId, Long personId);

    List<MovieDto> getMovieByProfessionAndPerson(Long professionId, Long personId);
}
