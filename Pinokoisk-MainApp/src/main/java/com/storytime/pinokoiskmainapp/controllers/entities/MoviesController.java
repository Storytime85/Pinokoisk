package com.storytime.pinokoiskmainapp.controllers.entities;

import com.storytime.pinokoiskmainapp.dto.MovieDto;
import com.storytime.pinokoiskmainapp.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
@RequestMapping("/movies")
public class MoviesController {
    private final MovieService movieService;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String filmsList() {
        return "redirect:/movies/all";
    }

    @GetMapping("/all")
    public String allFilmsList(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("header", "Список всех фильмов");
        return "collections/movies";
    }

    @GetMapping("/{id}")
    public String showMovieForm(Model model, @PathVariable("id") Long id) {
        MovieDto movie = movieService.getOne(id);
        if (movie != null) {
            model.addAttribute("movie", movie);
            return "entities/movie";
        } else {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }
}
