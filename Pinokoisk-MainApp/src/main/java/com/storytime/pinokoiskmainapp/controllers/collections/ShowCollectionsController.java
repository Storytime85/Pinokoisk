package com.storytime.pinokoiskmainapp.controllers.collections;

import com.storytime.pinokoiskmainapp.dto.PersonDto;
import com.storytime.pinokoiskmainapp.service.MovieService;
import com.storytime.pinokoiskmainapp.service.PersonService;
import com.storytime.pinokoiskmainapp.service.SeriesService;
import com.storytime.pinokoiskmainapp.util.DictionariesFromDb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
@RequestMapping("/collections")
public class ShowCollectionsController {
    private final DictionariesFromDb dictionaries;
    private final PersonService personService;

    private final MovieService movieService;

    private final SeriesService seriesService;

    public ShowCollectionsController(DictionariesFromDb dictionaries, PersonService personService, MovieService movieService, SeriesService seriesService) {
        this.dictionaries = dictionaries;
        this.personService = personService;
        this.movieService = movieService;
        this.seriesService = seriesService;
    }

    @GetMapping
    public String showCollectionsPage(Model model) {
        model.addAttribute("streamings", dictionaries.getStreamings());
        model.addAttribute("genres", dictionaries.getGenres());
        model.addAttribute("age_restrictions", dictionaries.getAgeRestrictions());
        return "collections/collections";
    }

    @GetMapping("/shows")
    public String showCollectionOfShowsForPerson(Model model, @RequestParam(name = "id") Long personId) {
        PersonDto person = personService.getOne(personId);
        if (person != null) {
            model.addAttribute("movies", person.getMovies());
            model.addAttribute("series", person.getSeries());
            model.addAttribute("header", "Проекты, в которых участвовал(а) " +
                    person.getName() + ": ");
            model.addAttribute("enableProfessions", true);
            return "collections/personshows";
        } else {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

    @GetMapping("/pp")
    public String showCollectionOfShowsForPersonAndProfession(Model model,
                                                              @RequestParam(name = "person") Long personId,
                                                              @RequestParam(name = "profession") Long professionId) {
        PersonDto person = personService.getOne(personId);
        if (person != null) {
            model.addAttribute("movies", movieService.getMovieByProfessionAndPerson(personId, professionId));
            model.addAttribute("series", seriesService.getSeriesByProfessionAndPerson(personId, professionId));
            model.addAttribute("header", "Проекты, в которых участвовал(а) " +
                    person.getName() + " на позиции " + dictionaries.getProfessions().get(professionId) + ": ");
            model.addAttribute("enableProfessions", false);
            return "collections/personshows";
        } else {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

}
