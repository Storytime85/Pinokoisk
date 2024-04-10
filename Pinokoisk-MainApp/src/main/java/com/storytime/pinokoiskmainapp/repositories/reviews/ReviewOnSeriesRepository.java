package com.storytime.pinokoiskmainapp.repositories.reviews;

import com.storytime.pinokoiskmainapp.entities.reviews.ReviewOnSeriesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewOnSeriesRepository extends CrudRepository<ReviewOnSeriesEntity, Long> {
}
