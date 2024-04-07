package com.storytime.pinokoiskmainapp.controllers.collections;

import com.storytime.pinokoiskmainapp.dto.MovieDto;
import com.storytime.pinokoiskmainapp.dto.SeriesDto;
import com.storytime.pinokoiskmainapp.service.SeriesService;
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
@RequestMapping("/collections/series")
public class SeriesCollectionsController {
    private final DictionariesFromDb dictionaries;
    private final SeriesService seriesService;

    public SeriesCollectionsController(DictionariesFromDb dictionaries, SeriesService seriesService) {
        this.dictionaries = dictionaries;
        this.seriesService = seriesService;
    }


    @GetMapping("/genre")
    public String showSeriesCollectionsByGenre(Model model,
                                               @RequestParam("id") Long genreId) {
        List<SeriesDto> series = seriesService.getSeriesByGenre(genreId);
        model.addAttribute("series", series);
        model.addAttribute("header", "Подборка сериалов в жанре " +
                dictionaries.getGenres().get(genreId) + ": ");
        return "collections/series";
    }

    @GetMapping("/streaming")
    public String showSeriesCollectionsByStreaming(Model model,
                                                   @RequestParam("id") Long streamingId) {
        List<SeriesDto> series = seriesService.getSeriesByStreaming(streamingId);
        model.addAttribute("series", series);
        model.addAttribute("header", "Подборка сериалов, вышедших на сервисе " +
                dictionaries.getStreamings().get(streamingId) + ": ");
        return "collections/series";
    }

    @GetMapping("/year")
    public String showSeriesCollectionsByPremiereYear(Model model,
                                                      @RequestParam("year") Integer year) {
        if (year > 1900 && year <= LocalDateTime.now().getYear()) {
            List<SeriesDto> series = seriesService.getSeriesByPremiereDateByYear(year);
            model.addAttribute("series", series);
            model.addAttribute("header", "Подборка сериалов, вышедших за " + year + " год: ");
        } else {
            model.addAttribute("series", new ArrayList<MovieDto>());
            model.addAttribute("header", "Недопустимое значение поля год");
        }
        return "collections/series";
    }

    @GetMapping("/restrictions")
    public String showSeriesCollectionsByAgeRestrictions(Model model,
                                                         @RequestParam("id") Long ageRestrictionsId) {
        List<SeriesDto> series = seriesService.getSeriesByAgeRestrictions(ageRestrictionsId);
        model.addAttribute("series", series);
        model.addAttribute("header", "Подборка сериалов, имеющих возрастное ограничение " +
                dictionaries.getAgeRestrictions().get(ageRestrictionsId) + ": ");
        return "collections/series";
    }
}
