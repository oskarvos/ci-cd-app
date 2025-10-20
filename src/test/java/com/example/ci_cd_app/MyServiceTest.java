package com.example.ci_cd_app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyServiceTest {

    @Autowired
    private MyService myService;

    @Test
    void testGetUser() {
        myService.addUser("testUser");

        // Исправленная версия
        String user = myService.getUser(0);
        assertEquals("testUser", user);

        // Тест на исключение
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myService.getUser(5);
        });
    }

    @Test
    void testGetAllUsers() {
        // Очищаем перед тестом для изоляции
        var users = myService.getAllUsers();
        // Предполагаем, что список может быть не пустым из-за других тестов
        int initialSize = users.size();

        myService.addUser("alice");
        myService.addUser("bob");

        users = myService.getAllUsers();
        assertEquals(initialSize + 2, users.size());
    }
}