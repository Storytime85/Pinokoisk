package com.storytime.pinokoiskmainapp.repositories;


import com.storytime.pinokoiskmainapp.entities.SeriesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SeriesRepository extends CrudRepository<SeriesEntity, Long> {
    Optional<List<SeriesEntity>> findSeriesEntitiesByGenresId(Long id);

    Optional<List<SeriesEntity>> findSeriesEntitiesByStreamingId(Long id);

    Optional<List<SeriesEntity>> findSeriesEntitiesByPremiereDateBetween(LocalDateTime start, LocalDateTime end);

    Optional<List<SeriesEntity>> findSeriesEntitiesByAgeRestrictionsId(Long id);

    @Query("SELECT pspl.series from PersonSeriesProfessionLinkEntity as pspl where pspl.person.id = ?1")
    Optional<List<SeriesEntity>> findSeriesByPspl_PersonId(Long personId);

    @Query("SELECT pspl.series from PersonSeriesProfessionLinkEntity as pspl where pspl.profession.id = ?2 AND pspl.person.id = ?1")
    Optional<List<SeriesEntity>> findSeriesByPspl_ProfessionIdAndPspl_PersonId(Long professionId, Long personId);
}
