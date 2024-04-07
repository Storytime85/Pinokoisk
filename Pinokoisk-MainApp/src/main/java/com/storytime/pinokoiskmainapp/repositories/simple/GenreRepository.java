package com.storytime.pinokoiskmainapp.repositories.simple;

import com.storytime.pinokoiskmainapp.entities.simple.GenreEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface GenreRepository extends Repository<GenreEntity, Long> {
    List<GenreEntity> findAll();

}
