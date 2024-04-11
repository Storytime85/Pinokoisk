package com.storytime.pinokoiskmainapp.repositories.reviews;

import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnMovieEntity;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnSeriesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewOnSeriesRepository extends CrudRepository<ReviewOnSeriesEntity, Long> {

    Optional<List<ReviewOnSeriesEntity>> findAllByUserId(Long userId);

    Optional<List<ReviewOnSeriesEntity>> findAllBySeriesId(Long userId);

}
