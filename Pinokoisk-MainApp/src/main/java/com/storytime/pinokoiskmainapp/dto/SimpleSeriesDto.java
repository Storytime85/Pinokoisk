package com.storytime.pinokoiskmainapp.dto;

import com.storytime.pinokoiskmainapp.dto.simple.GenreDto;
import com.storytime.pinokoiskmainapp.dto.simple.ProfessionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleSeriesDto {
    private Long id;
    private String name;
    private String originalName;
    private List<GenreDto> genres;
    private List<ProfessionDto> professions;
}
