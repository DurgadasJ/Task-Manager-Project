package com.js.java.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/env")
public class EnvironmentInfo {

    @Value("${app.environment}")
    private String environment;

    @GetMapping
    public String getEnvironment() {
        return environment;
    }
}
