package com.storytime.pinokoiskmainapp.controllers.entities;

import com.storytime.pinokoiskmainapp.dto.AvgRating;
import com.storytime.pinokoiskmainapp.dto.FullReviewDto;
import com.storytime.pinokoiskmainapp.dto.MovieDto;
import com.storytime.pinokoiskmainapp.dto.SeriesDto;
import com.storytime.pinokoiskmainapp.entities.reviews.ReviewEntity;
import com.storytime.pinokoiskmainapp.service.ReviewService;
import com.storytime.pinokoiskmainapp.service.SeriesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
@RequestMapping("/series")
@AllArgsConstructor
public class SeriesController extends EntityController{
    private final SeriesService seriesService;
    private final ReviewService reviewService;

    @GetMapping
    public String seriesList() {
        return "redirect:/series/all";
    }

    @GetMapping("/all")
    public String allSeriesList(Model model) {
        Map<Long, AvgRating> users = reviewService.getAllRatingsWithSeriesByUserRole("USER");
        Map<Long, AvgRating> critics = reviewService.getAllRatingsWithSeriesByUserRole("CRITIC");
        model.addAttribute("series", seriesService.getAllSeries());
        model.addAttribute("header", "Список всех сериалов");
        model.addAttribute("userRatings", users);
        model.addAttribute("criticRatings", critics);
        model.addAttribute("allRatings", squishUsersAndCritics(users, critics));
        return "collections/series";
    }



    @GetMapping("/{id}")
    public String showSeriesForm(Model model, @PathVariable("id") Long id) {
        SeriesDto series = seriesService.getOne(id);
        if (series != null) {
            AvgRating users = reviewService.getRatingsBySeriesAndUsers(id);
            AvgRating critics = reviewService.getRatingsBySeriesAndCritics(id);
            AvgRating all = new AvgRating(users,critics);

            model.addAttribute("one_series", series);
            model.addAttribute("userRating", users);
            model.addAttribute("criticRating", critics);
            model.addAttribute("avgAll", all);

            return "entities/series";
        } else {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }
    @GetMapping("/reviews/{id}")
    public String showReviewsForm(Model model, @PathVariable("id") Long id) {
        SeriesDto seriesDto = seriesService.getOne(id);
        if (seriesDto != null) {
            List<FullReviewDto> userReviews = reviewService.getAllReviewsOnSeriesByUsers(id);
            List<FullReviewDto> criticReviews = reviewService.getAllReviewsOnSeriesByCritics(id);
            model.addAttribute("type", "сериал");
            model.addAttribute("name", seriesDto.getName());
            model.addAttribute("userReviews", userReviews);
            model.addAttribute("criticReviews", criticReviews);
            return "entities/reviews";
        } else {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }
}
