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
    void testAddUser() {
        String result = myService.addUser("john");
        assertEquals("User john added", result);
    }

    @Test
    void testGetAllUsers() {
        myService.addUser("alice");
        myService.addUser("bob");

        var users = myService.getAllUsers();
        assertTrue(users.size() >= 2); // Может упасть если тесты запускаются в разном порядке
    }

    @Test
    void testGetUser() {
        myService.addUser("testUser");

        // Этот тест упадет - мы обращаемся к несуществующему индексу
        String user = myService.getUser(0); // Должен работать
        String user2 = myService.getUser(5); // Упадет с IndexOutOfBoundsException
    }
}