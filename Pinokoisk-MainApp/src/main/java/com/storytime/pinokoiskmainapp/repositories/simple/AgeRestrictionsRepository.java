package com.storytime.pinokoiskmainapp.repositories.simple;

import com.storytime.pinokoiskmainapp.entities.simple.AgeRestrictionsEntity;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface AgeRestrictionsRepository extends Repository<AgeRestrictionsEntity, Long> {
    List<AgeRestrictionsEntity> findAll();

}
