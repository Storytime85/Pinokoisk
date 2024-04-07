package com.storytime.pinokoiskmainapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//temporal controller for dummy endpoints
@Controller
public class HttpController {

    @GetMapping("/search")
    public String search() {
        return "search";
    }


}
