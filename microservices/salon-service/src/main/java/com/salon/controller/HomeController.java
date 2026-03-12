package com.salon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String HomeControllerHandler() {
        return "Hello sir. This is the saloon app. Salon microservice";
    }
}
