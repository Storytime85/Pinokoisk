package com.storytime.pinokoiskmainapp.service.impl;

import com.storytime.pinokoiskmainapp.dto.MovieDto;
import com.storytime.pinokoiskmainapp.entities.MovieEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import com.storytime.pinokoiskmainapp.repositories.MovieRepository;
import com.storytime.pinokoiskmainapp.service.MovieService;
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
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    private final Mapper<MovieEntity, MovieDto> movieMapper;


    @Override
    @CachePut(cacheNames = {"movies"})
    public List<MovieEntity> findAll() {
        return StreamSupport.stream(movieRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return findAll().stream().map(movieMapper::mapTo).toList();
    }

    @Override
    @Cacheable(key = "#movieId", value = "movie")
    public Optional<MovieEntity> findOne(Long movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public MovieDto getOne(Long movieId) {
        return findOne(movieId).map(movieMapper::mapTo).orElse(null);
    }

    @Override
    @CachePut(cacheNames = {"movies_by_genre"})
    public Optional<List<MovieEntity>> findMoviesByGenre(Long genreId) {
        return movieRepository.findMovieEntitiesByGenresId(genreId);
    }

    @Override
    public List<MovieDto> getMoviesByGenre(Long genreId) {
        return findMoviesByGenre(genreId).map((e) -> e.stream().map(movieMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }

    @Override
    @CacheEvict(cacheNames = "movie")
    public String delete(Long id) {
        movieRepository.deleteById(id);
        return "Done.";
    }

    @Override
    public String remove(Long id) {
        return delete(id);
    }

    @Override
    public Optional<List<MovieEntity>> findMovieByStreaming(Long streamingId) {
        return movieRepository.findMovieEntitiesByStreamingId(streamingId);

    }

    @Override
    public List<MovieDto> getMoviesByStreaming(Long streamingId) {
        return findMovieByStreaming(streamingId).map(
                (e) -> e.stream().map(movieMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }

    @Override
    public Optional<List<MovieEntity>> findMovieByPremiereDateBetween(LocalDateTime start, LocalDateTime end) {
        return movieRepository.findMovieEntitiesByPremiereDateBetween(start, end);
    }

    @Override
    public List<MovieDto> getMoviesByPremiereDateByYear(Integer year) {
        return findMovieByPremiereDateBetween(
                LocalDateTime.of(year, Month.JANUARY, 1, 0, 0, 0),
                LocalDateTime.of(year, Month.DECEMBER, 31, 23, 59, 59))
                .map((e) -> e.stream().map(movieMapper::mapTo).toList()
                ).orElse(new ArrayList<>());
    }

    @Override
    public Optional<List<MovieEntity>> findMovieByAgeRestrictions(Long ageRestrictionsId) {
        return movieRepository.findMovieEntitiesByAgeRestrictionsId(ageRestrictionsId);
    }

    @Override
    public List<MovieDto> getMoviesByAgeRestrictions(Long ageRestrictionsId) {
        return findMovieByAgeRestrictions(ageRestrictionsId).map(
                (e) -> e.stream().map(movieMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }

    @Override
    public Optional<List<MovieEntity>> findMovieByPerson(Long personId) {
        return movieRepository.findMoviesByPmplPersonId(personId);
    }

    @Override
    public List<MovieDto> getMovieByPerson(Long personId) {
        return findMovieByPerson(personId).map(
                (e) -> e.stream().map(movieMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }

    @Override
    public Optional<List<MovieEntity>> findMovieByProfessionAndPerson(Long professionId, Long personId) {
        return movieRepository.findMoviesByPmplProfessionIdAndPmplPersonId(professionId, personId);
    }

    @Override
    public List<MovieDto> getMovieByProfessionAndPerson(Long professionId, Long personId) {
        return findMovieByProfessionAndPerson(professionId, personId).map(
                (e) -> e.stream().map(movieMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }

}
