package com.storytime.pinokoiskmainapp.repositories.simple;

import com.storytime.pinokoiskmainapp.entities.simple.StreamingEntity;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface StreamingRepository extends Repository<StreamingEntity, Long> {
    List<StreamingEntity> findAll();
}
