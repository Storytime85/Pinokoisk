package com.storytime.pinokoiskmainapp.controllers.collections;

import com.storytime.pinokoiskmainapp.dto.MovieDto;
import com.storytime.pinokoiskmainapp.service.MovieService;
import com.storytime.pinokoiskmainapp.util.DictionariesFromDb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/collections/movies")
public class MoviesCollectionsController {

    private final DictionariesFromDb dictionaries;
    private final MovieService movieService;

    public MoviesCollectionsController(DictionariesFromDb dictionaries, MovieService movieService) {
        this.dictionaries = dictionaries;
        this.movieService = movieService;
    }

    @GetMapping("/genre")
    public String showMoviesCollectionsByGenre(Model model, @RequestParam("id") Long genreId) {
        List<MovieDto> movies = movieService.getMoviesByGenre(genreId);
        model.addAttribute("movies", movies);
        model.addAttribute("header", "Подборка сериалов в жанре " +
                dictionaries.getGenres().get(genreId) + ": ");
        return "collections/movies";
    }

    @GetMapping("/streaming")
    public String showMoviesCollectionsByStreaming(Model model,
                                                   @RequestParam("id") Long streamingId) {
        List<MovieDto> movies = movieService.getMoviesByStreaming(streamingId);
        model.addAttribute("movies", movies);
        model.addAttribute("header", "Подборка фильмов, вышедших на сервисе " +
                dictionaries.getStreamings().get(streamingId) + ": ");
        return "collections/movies";
    }

    @GetMapping("/year")
    public String showMoviesCollectionsByPremiereYear(Model model,
                                                      @RequestParam("year") Integer year) {
        if (year > 1900 && year <= LocalDateTime.now().getYear()) {
            List<MovieDto> movies = movieService.getMoviesByPremiereDateByYear(year);
            model.addAttribute("movies", movies);
            model.addAttribute("header", "Подборка фильмов, вышедших за " + year + " год: ");
        } else {
            model.addAttribute("movies", new ArrayList<MovieDto>());
            model.addAttribute("header", "Недопустимое значение поля год");
        }
        return "collections/movies";
    }

    @GetMapping("/restrictions")
    public String showMoviesCollectionsByAgeRestrictions(Model model,
                                                         @RequestParam("id") Long ageRestrictionsId) {
        List<MovieDto> movies = movieService.getMoviesByAgeRestrictions(ageRestrictionsId);
        model.addAttribute("movies", movies);
        model.addAttribute("header", "Подборка фильмов, имеющих возрастное ограничение " +
                dictionaries.getAgeRestrictions().get(ageRestrictionsId) + ": ");
        return "collections/movies";
    }
}
