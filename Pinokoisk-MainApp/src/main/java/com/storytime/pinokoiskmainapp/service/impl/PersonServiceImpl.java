package com.storytime.pinokoiskmainapp.service.impl;

import com.storytime.pinokoiskmainapp.dto.PersonDto;
import com.storytime.pinokoiskmainapp.entities.PersonEntity;
import com.storytime.pinokoiskmainapp.mappers.Mapper;
import com.storytime.pinokoiskmainapp.repositories.PersonRepository;
import com.storytime.pinokoiskmainapp.service.PersonService;
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
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final Mapper<PersonEntity, PersonDto> personMapper;

    @Override
    @CachePut(cacheNames = {"persons"})
    public List<PersonEntity> findAll() {
        return StreamSupport.stream(personRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return findAll().stream().map(personMapper::mapTo).toList();
    }

    @Override
    @Cacheable(key = "#personId", value = "person")
    public Optional<PersonEntity> findOne(Long personId) {
        return personRepository.findById(personId);
    }

    @Override
    public PersonDto getOne(Long personId) {
        return findOne(personId).map(personMapper::mapTo).orElse(null);
    }

    @Override
    @CacheEvict(cacheNames = "person")
    public String delete(Long id) {
        personRepository.deleteById(id);
        return "Done.";
    }

    @Override
    public String remove(Long id) {
        return delete(id);
    }

    @Override
    public Optional<List<PersonEntity>> findPersonByBirthday(LocalDateTime birthday) {
        return personRepository.findPersonEntitiesByBirthday(birthday);
    }

    @Override
    public List<PersonDto> getPersonByBirthday(LocalDateTime birthday) {
        return findPersonByBirthday(birthday).map(
                (e) -> e.stream().map(personMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }

    @Override
    public Optional<List<PersonEntity>> findPersonByBirthYear(LocalDateTime start, LocalDateTime end) {
        return personRepository.findPersonEntitiesByBirthdayBetween(start, end);
    }

    @Override
    public List<PersonDto> getPersonByBirthYear(Integer year) {
        return findPersonByBirthYear(
                LocalDateTime.of(year, Month.JANUARY, 1, 0, 0, 0),
                LocalDateTime.of(year, Month.DECEMBER, 31, 23, 59, 59))
                .map((e) -> e.stream().map(personMapper::mapTo).toList()
                ).orElse(new ArrayList<>());
    }

    @Override
    public Optional<List<PersonEntity>> findPersonByBirthplace(String birthplace) {
        return personRepository.findPersonEntitiesByBirthplace(birthplace);
    }

    @Override
    public List<PersonDto> getPersonByBirthplace(String birthplace) {
        return findPersonByBirthplace(birthplace).map(
                (e) -> e.stream().map(personMapper::mapTo).toList()
        ).orElse(new ArrayList<>());
    }


}
