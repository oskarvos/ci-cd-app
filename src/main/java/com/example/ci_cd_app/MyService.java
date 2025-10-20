package com.example.ci_cd_app;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyService {

    private List<String> users = new ArrayList<>();

    public String addUser(String username) {
        // Намеренный баг: не проверяем существование пользователя
        users.add(username);
        return "User " + username + " added";
    }

    public List<String> getAllUsers() {
        return users;
    }

    public String getUser(int index) {
        // Опасный код: может упасть с IndexOutOfBoundsException
        return users.get(index);
    }
}

