package com.storytime.pinokoiskmainapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReviewOnMovieDto extends FullReviewDto{
    private Long id;
    private Long movieId;
    private String movieName;
    public ReviewOnMovieDto(Long id, short rating, ReviewDto review, Long movieId, String movieName, Long userId, String userName ) {
        super(rating, review, userId, userName);
        this.id = id;
        this.movieId = movieId;
        this.movieName = movieName;
    }
    @Override
    public FullReviewDto getFullReviewDto(){
        return new FullReviewDto(getRating(),getReview(),getUserId(),getUsername());
    }
}
