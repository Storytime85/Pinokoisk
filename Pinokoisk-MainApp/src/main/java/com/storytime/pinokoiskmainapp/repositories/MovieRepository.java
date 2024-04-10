package com.storytime.pinokoiskmainapp.repositories;

import com.storytime.pinokoiskmainapp.entities.MovieEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Long> {
    Optional<List<MovieEntity>> findMovieEntitiesByGenresId(Long id);

    Optional<List<MovieEntity>> findMovieEntitiesByStreamingId(Long id);

    Optional<List<MovieEntity>> findMovieEntitiesByPremiereDateBetween(LocalDateTime start, LocalDateTime end);

    Optional<List<MovieEntity>> findMovieEntitiesByAgeRestrictionsId(Long id);

    @Query("SELECT pmpl.movie from PersonMovieProfessionLinkEntity as pmpl where pmpl.person.id = ?1")
    Optional<List<MovieEntity>> findMoviesByPmplPersonId(Long personId);

    @Query("SELECT pmpl.movie from PersonMovieProfessionLinkEntity as pmpl where pmpl.profession.id =?2 AND pmpl.person.id = ?1")
    Optional<List<MovieEntity>> findMoviesByPmplProfessionIdAndPmplPersonId(Long professionId, Long personId);
}
