package com.storytime.pinokoiskmainapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReviewOnSeriesDto extends FullReviewDto{
    private Long id;
    private Long seriesId;
    private String seriesName;
    public ReviewOnSeriesDto(Long id, short rating, ReviewDto review, Long seriesId, String seriesName, Long userId, String userName ) {
        super(rating, review, userId, userName);
        this.id = id;
        this.seriesId = seriesId;
        this.seriesName = seriesName;
    }

    @Override
    public FullReviewDto getFullReviewDto(){
        return new FullReviewDto(getRating(),getReview(),getUserId(),getUsername());
    }
}
