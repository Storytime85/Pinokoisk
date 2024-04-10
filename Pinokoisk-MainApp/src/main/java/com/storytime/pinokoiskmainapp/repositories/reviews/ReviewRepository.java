package com.storytime.pinokoiskmainapp.repositories.reviews;

import com.storytime.pinokoiskmainapp.entities.reviews.ReviewEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends CrudRepository<ReviewEntity,String> {
    Optional<ReviewEntity> findAllByUserId(Long userId);

}
