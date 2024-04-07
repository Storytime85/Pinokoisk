package com.storytime.pinokoiskmainapp.repositories;

import com.storytime.pinokoiskmainapp.entities.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
    Optional<List<PersonEntity>> findPersonEntitiesByBirthday(LocalDateTime birthday);

    Optional<List<PersonEntity>> findPersonEntitiesByBirthdayBetween(LocalDateTime start, LocalDateTime end);

    Optional<List<PersonEntity>> findPersonEntitiesByBirthplace(String birthplace);
}
