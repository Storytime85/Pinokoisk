package com.storytime.pinokoiskmainapp.dto;

import com.storytime.pinokoiskmainapp.dto.simple.GenreDto;
import com.storytime.pinokoiskmainapp.dto.simple.ProfessionDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class PersonDto {
    private Long id;
    private String name;
    private LocalDateTime birthday;
    private String birthplace;
    private String photo;
    private List<SimpleMovieDto> movies;
    private List<SimpleSeriesDto> series;
    private List<GenreDto> genres;
    private List<ProfessionDto> professions;


    public PersonDto(Long id, String name, LocalDateTime birthday, String birthplace, String photo, List<SimpleMovieDto> movies, List<SimpleSeriesDto> series) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.photo = photo;
        this.movies = movies;
        this.series = series;
        makeListOfProfessions();
        makeListOfGenres();
    }

    private void makeListOfGenres() {
        genres = new ArrayList<>();
        movies.forEach(m -> {
            m.getGenres().forEach(g -> {
                if (!genres.contains(g)) {
                    genres.add(g);
                }
            });
        });
        series.forEach(s -> {
            s.getGenres().forEach(g -> {
                if (!genres.contains(g)) {
                    genres.add(g);
                }
            });
        });

    }

    private void makeListOfProfessions() {
        professions = new ArrayList<>();
        movies.forEach(m -> {
            m.getProfessions().forEach(p -> {
                if (!professions.contains(p)) {
                    professions.add(p);
                }
            });
        });
        series.forEach(s -> {
            s.getProfessions().forEach(p -> {
                if (!professions.contains(p)) {
                    professions.add(p);
                }
            });
        });
    }

    public int countOfShows() {
        return movies.size() + series.size();
    }

}
