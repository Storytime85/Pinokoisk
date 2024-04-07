package com.storytime.pinokoiskmainapp.controllers.entities;

import com.storytime.pinokoiskmainapp.dto.PersonDto;
import com.storytime.pinokoiskmainapp.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public String showAllPersonsForm(Model model) {
        model.addAttribute("persons", personService.getAllPersons());
        model.addAttribute("header", "Список всех персон");
        return "collections/persons";
    }

    @GetMapping
    public String showPersonsForm() {
        return "redirect:/persons/all";
    }

    @GetMapping("/{id}")
    public String showPersonForm(Model model, @PathVariable("id") Long id) {
        PersonDto person = personService.getOne(id);
        if (person != null) {
            model.addAttribute("person", person);
            return "entities/person";
        } else {
            throw new ResponseStatusException(NOT_FOUND);
        }
    }

    @GetMapping("/year")
    public String showPersonsByBirthYear(Model model,
                                         @RequestParam("year") Integer birthYear) {
        List<PersonDto> persons = personService.getPersonByBirthYear(birthYear);
        model.addAttribute("persons", persons);
        model.addAttribute("header", "Персоны, родившиеся в " +
                birthYear + " году:");
        return "collections/persons";
    }

    @GetMapping("/birthday")
    public String showPersonsByBirthday(Model model,
                                        @RequestParam("birthday") LocalDateTime birthday) {
        List<PersonDto> persons = personService.getPersonByBirthday(birthday);
        model.addAttribute("persons", persons);
        model.addAttribute("header", "Персоны, родившиеся " +
                birthday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + ":");
        return "collections/persons";
    }

    @GetMapping("/birthplace")
    public String showPersonsByBirthplace(Model model,
                                          @RequestParam("birthplace") String birthplace) {
        List<PersonDto> persons = personService.getPersonByBirthplace(birthplace);
        model.addAttribute("persons", persons);
        model.addAttribute("header", "Персоны, родившиеся в " +
                birthplace + ":");
        return "collections/persons";
    }

}
