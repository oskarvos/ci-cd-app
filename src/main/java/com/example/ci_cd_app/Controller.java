package com.example.ci_cd_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String home() {
        return "CI/CD Demo Application is running!";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello, " + name + "! Welcome to CI/CD world!";
    }

    @GetMapping("/calculator/add/{a}/{b}")
    public String add(@PathVariable int a, @PathVariable int b) {
        return "Result: " + (a + b);
    }

}
