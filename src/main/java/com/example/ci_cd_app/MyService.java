package com.example.ci_cd_app;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyService {

    private List<String> users = new ArrayList<>();

    public String addUser(String username) {
        users.add(username);
        return "User " + username + " added";
    }

    public List<String> getAllUsers() {
        return new ArrayList<>(users); // Возвращаем копию для безопасности
    }

    public String getUser(int index) {
        return users.get(index);
    }

    // ДОБАВЛЯЕМ МЕТОД ДЛЯ ТЕСТОВ - очищает список пользователей
    public void clearUsers() {
        users.clear();
    }
}


