package com.example.kodillapatterns.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        // Given
        User millenials = new Millenials("millenials");
        User yGeneration = new YGeneration("yGeneration");
        User zGeneration = new ZGeneration("zGeneration");

        // When
        String millenialsMessage = millenials.sharePost();
        String yGenerationMessage = yGeneration.sharePost();
        String zGenerationMessage = zGeneration.sharePost();

        // Then
        assertEquals("Używam Facebooka!", millenialsMessage);
        assertEquals("Używam Twittera!", yGenerationMessage);
        assertEquals("Używam Snapchata!", zGenerationMessage);
    }

    @Test
    public void testIndividualSharingStrategy() {
        // Given
        User millenials = new Millenials("millenials");

        // When
        millenials.setSocialPublisher(new TwitterPublisher());
        String message = millenials.sharePost();

        // Then
        assertEquals("Używam Twittera!", message);
    }
}