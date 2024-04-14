package com.storytime.pinokoiskmainapp.repositories.reviews.complex;

import com.storytime.pinokoiskmainapp.dto.AvgRating;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ReviewOnSeriesComplexRepositoryImpl implements ReviewOnSeriesComplexRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Map<Long, AvgRating> findAllSeriesRating(String userRole) {
        String query = "select rose.series.id as series, AVG(rose.rating) as avg, COUNT(rose.rating) as count" +
                "    FROM ReviewOnSeriesEntity as rose" +
                "    where rose.user.role LIKE '" + userRole + "' " +
                "group BY rose.series";

        return entityManager.createQuery(query, Tuple.class)
                .getResultStream()
                .collect(
                        Collectors.toMap(
                                tuple -> (Long) tuple.get("series"),
                                tuple -> new AvgRating((Double) tuple.get("avg"), (Long)tuple.get("count"))
                        )
                );
    }
    @Override
    public Optional<AvgRating> findAvgRatingsBySeriesIdAndUserRole(Long movieId, String userRole) {
        String query = "SELECT AVG(rose.rating) as avg, COUNT(rose.rating) FROM ReviewOnSeriesEntity " +
                "AS rose WHERE rose.series.id = " + movieId + " AND rose.user.role = '" + userRole + "' GROUP BY rose.series";
        try {
            return Optional.of((AvgRating) entityManager.createQuery(query,Tuple.class)
                    .unwrap(org.hibernate.query.Query.class)
                    .setTupleTransformer((tuple, aliases) -> new AvgRating((Double)tuple[0],(Long)tuple[1])
                    ).getSingleResult());
        } catch (NoResultException ex) {
            log.info("No result found in findAvgRatingsBySeriesIdAndUserRole " +
                    "for movieId = " + movieId + ", and userRole = " + userRole);
        }
        return Optional.empty();



    }

}
