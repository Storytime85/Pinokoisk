package com.storytime.pinokoiskmainapp.repositories.reviews.complex;

import com.storytime.pinokoiskmainapp.dto.AvgRating;
import com.storytime.pinokoiskmainapp.entities.MovieEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.aspectj.runtime.internal.Conversions.longValue;
@Slf4j
@Component
public class ReviewOnMovieComplexRepositoryImpl implements ReviewOnMovieComplexRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Map<Long, AvgRating> findAllMoviesRating(String userRole) {
        String query = "select rome.movie.id as movie, AVG(rome.rating) as avg, COUNT(rome.rating) as count" +
                "    FROM ReviewOnMovieEntity as rome" +
                "    where rome.user.role LIKE '" + userRole + "' " +
                "group BY rome.movie";

            return entityManager.createQuery(query, Tuple.class)
                    .getResultStream()
                    .collect(
                            Collectors.toMap(
                                    tuple -> (Long) tuple.get("movie"),
                                    tuple -> new AvgRating((Double) tuple.get("avg"), (Long)tuple.get("count"))
                            )
                    );
    }
    @Override
    public Optional<AvgRating> findAvgRatingsByMovieIdAndUserRole(Long movieId, String userRole) {
        String query = "SELECT AVG(rome.rating) as avg, COUNT(rome.rating) FROM ReviewOnMovieEntity " +
                "AS rome WHERE rome.movie.id = " + movieId + " AND rome.user.role = '" + userRole + "' GROUP BY rome.movie";
        try {
            return Optional.of((AvgRating) entityManager.createQuery(query,Tuple.class)
                    .unwrap(org.hibernate.query.Query.class)
                    .setTupleTransformer((tuple, aliases) -> new AvgRating((Double)tuple[0],(Long)tuple[1])
                    ).getSingleResult());
        } catch (NoResultException ex) {
           log.info("No result found in findAvgRatingsByMovieIdAndUserRole " +
                   "for movieId = " + movieId + ", and userRole = " + userRole);
        }
        return Optional.empty();
    }
}
