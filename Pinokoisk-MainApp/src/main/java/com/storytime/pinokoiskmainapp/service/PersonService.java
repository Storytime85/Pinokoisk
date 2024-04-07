package com.storytime.pinokoiskmainapp.service;

import com.storytime.pinokoiskmainapp.dto.PersonDto;
import com.storytime.pinokoiskmainapp.entities.PersonEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<PersonEntity> findAll();

    List<PersonDto> getAllPersons();

    Optional<PersonEntity> findOne(Long personId);

    PersonDto getOne(Long personId);

    String delete(Long id);

    String remove(Long id);

    Optional<List<PersonEntity>> findPersonByBirthday(LocalDateTime birthday);

    List<PersonDto> getPersonByBirthday(LocalDateTime birthday);

    Optional<List<PersonEntity>> findPersonByBirthYear(LocalDateTime start, LocalDateTime end);

    List<PersonDto> getPersonByBirthYear(Integer year);

    Optional<List<PersonEntity>> findPersonByBirthplace(String birthplace);

    List<PersonDto> getPersonByBirthplace(String birthplace);


}
