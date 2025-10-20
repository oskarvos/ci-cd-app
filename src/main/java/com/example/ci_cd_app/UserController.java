package com.example.ci_cd_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private MyService myService;

    @PostMapping("/{username}")
    public String addUser(@PathVariable String username) {
        return myService.addUser(username);
    }

    @GetMapping
    public List<String> getAllUsers() {
        return myService.getAllUsers();
    }

    @GetMapping("/{index}")
    public String getUser(@PathVariable int index) {
        return myService.getUser(index);
    }
}

