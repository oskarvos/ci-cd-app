package com.example.ci_cd_app;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class ProblematicTest {

    @Test
    void testFileExists() {
        // Этот тест упадет на CI, потому что файла там нет
        File file = new File("src/test/resources/config.properties");
        assertTrue(file.exists(), "Config file should exist");
    }

    @Test
    void testTiming() throws InterruptedException {
        // Может упасть на медленном CI сервере
        Thread.sleep(5000); // Долгий тест
        assertTrue(true);
    }
}