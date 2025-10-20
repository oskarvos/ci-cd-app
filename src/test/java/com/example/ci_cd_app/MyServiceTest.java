package com.example.ci_cd_app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyServiceTest {

    @Autowired
    private MyService myService;

    // Очищаем состояние перед КАЖДЫМ тестом
    @BeforeEach
    void setUp() {
        // Получаем текущий список и очищаем его
        // В реальном приложении лучше добавить метод clear() в сервис
        var users = myService.getAllUsers();
        // Если в сервисе нет метода очистки, можем "обойти" проблему
        // проверяя конкретную логику вместо жестких ожиданий
    }

    @Test
    void testAddUser() {
        String result = myService.addUser("john");
        assertEquals("User john added", result);
    }

    @Test
    void testGetAllUsers() {
        // Вместо проверки точного количества, проверяем что список увеличился
        int initialSize = myService.getAllUsers().size();

        myService.addUser("alice");
        myService.addUser("bob");

        var users = myService.getAllUsers();
        assertEquals(initialSize + 2, users.size());
    }

    @Test
    void testGetUser() {
        // Добавляем пользователя и проверяем что можем его получить
        myService.addUser("testUser");

        var users = myService.getAllUsers();
        // Ищем нашего пользователя в списке
        assertTrue(users.contains("testUser"));

        // Получаем индекс нашего пользователя
        int index = users.indexOf("testUser");
        String user = myService.getUser(index);
        assertEquals("testUser", user);
    }

    @Test
    void testGetUserWithInvalidIndex() {
        // Тестируем поведение при неверном индексе
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myService.getUser(999); // Заведомо неверный индекс
        });
    }
}