package com.example.kodillapatterns.singleton;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        // Given
        Logger logger = Logger.getInstance();
        logger.log("First log");

        // When
        String lastLog = logger.getLastLog();

        // Then
        Assertions.assertEquals("First log", lastLog);
    }

    @Test
    public void testGetLastLogWithMultipleLogs() {
        // Given
        Logger logger = Logger.getInstance();
        logger.log("First log");
        logger.log("Second log");

        // When
        String lastLog = logger.getLastLog();

        // Then
        Assertions.assertEquals("Second log", lastLog);
    }
}