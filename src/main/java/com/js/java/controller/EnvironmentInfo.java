package com.js.java.controller;

import com.js.java.util.TaskLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/env")
public class EnvironmentInfo {

    @Autowired
    private TaskLogger taskLogger;

    @Value("${app.environment}")
    private String environment;

    @GetMapping
    public String getEnvironment() {
        return environment;
    }

    @GetMapping("/log")
    public String submitLog(){
        taskLogger.log("Log submitted");
        return "Logged";
    }
}
