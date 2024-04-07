package com.storytime.pinokoiskmainapp.repositories.simple;

import com.storytime.pinokoiskmainapp.entities.simple.ProfessionEntity;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface ProfessionRepository extends Repository<ProfessionEntity, Long> {
    List<ProfessionEntity> findAll();

}
