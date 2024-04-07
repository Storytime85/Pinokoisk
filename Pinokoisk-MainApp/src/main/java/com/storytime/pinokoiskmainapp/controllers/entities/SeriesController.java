package com.storytime.pinokoiskmainapp.controllers.entities;

import com.storytime.pinokoiskmainapp.dto.SeriesDto;
import com.storytime.pinokoiskmainapp.service.SeriesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
@RequestMapping("/series")
public class SeriesController {
    private final SeriesService seriesService;

    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping
    public String seriesList() {
        return "redirect:/series/all";
    }

    @GetMapping("/all")
    public String allSeriesList(Model model) {
        model.addAttribute("series", seriesService.getAllSeries());
        model.addAttribute("header", "Список всех сериалов");
        return "collections/series";
    }

    @GetMapping("/{id}")
    public String showSeriesForm(Model model, @PathVariable("id") Long id) {
        SeriesDto series = seriesService.getOne(id);
        if (series != null) {
            model.addAttribute("one_series", series);
            return "entities/series";
        } else {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }


}
