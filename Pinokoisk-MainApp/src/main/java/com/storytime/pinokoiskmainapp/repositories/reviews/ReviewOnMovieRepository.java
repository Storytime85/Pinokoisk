package com.storytime.pinokoiskmainapp.repositories.reviews;

import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewOnMovieRepository extends CrudRepository<ReviewOnMovieEntity, Long> {
}
