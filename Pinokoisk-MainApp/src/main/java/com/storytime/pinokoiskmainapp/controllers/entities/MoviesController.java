package com.storytime.pinokoiskmainapp.controllers.entities;

import com.storytime.pinokoiskmainapp.dto.AvgRating;
import com.storytime.pinokoiskmainapp.dto.FullReviewDto;
import com.storytime.pinokoiskmainapp.dto.MovieDto;
import com.storytime.pinokoiskmainapp.service.MovieService;
import com.storytime.pinokoiskmainapp.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.AccumulatorOperators;
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
@RequestMapping("/movies")
@AllArgsConstructor
public class MoviesController extends EntityController{
    private final MovieService movieService;
    private final ReviewService reviewService;
    @GetMapping
    public String filmsList() {
        return "redirect:/movies/all";
    }

    @GetMapping("/all")
    public String allFilmsList(Model model) {
        Map<Long, AvgRating> users = reviewService.getAllRatingsWithMovieByUserRole("USER");
        Map<Long, AvgRating> critics = reviewService.getAllRatingsWithMovieByUserRole("CRITIC");
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("header", "Список всех фильмов");
        model.addAttribute("userRatings", users);
        model.addAttribute("criticRatings", critics);
        model.addAttribute("allRatings", squishUsersAndCritics(users, critics));
        return "collections/movies";
    }

    @GetMapping("/{id}")
    public String showMovieForm(Model model, @PathVariable("id") Long id) {
        MovieDto movie = movieService.getOne(id);
        if (movie != null) {
            AvgRating users = reviewService.getRatingsByMovieAndUsers(id);
            AvgRating critics = reviewService.getRatingsByMovieAndCritics(id);
            AvgRating all = new AvgRating(users,critics);

            model.addAttribute("movie", movie);
            model.addAttribute("userRating", users);
            model.addAttribute("criticRating", critics);
            model.addAttribute("avgAll", all);

            return "entities/movie";
        } else {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{id}")
    public String showReviewsForm(Model model, @PathVariable("id") Long id) {
        MovieDto movieDto = movieService.getOne(id);
        if(movieDto!=null) {
            List<FullReviewDto> userReviews = reviewService.getAllReviewsOnMovieByUsers(id);
            List<FullReviewDto> criticReviews = reviewService.getAllReviewsOnMovieByCritics(id);
            model.addAttribute("type", "фильм");
            model.addAttribute("name", movieDto.getName());
            model.addAttribute("userReviews", userReviews);
            model.addAttribute("criticReviews", criticReviews);
            return "entities/reviews";
        } else {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }
}
