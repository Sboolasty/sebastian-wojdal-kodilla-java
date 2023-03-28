package com.example.kodillapatterns.strategy;

public class FacebookPublisher implements SocialPublisher {
    @Override
    public void share() {
        System.out.println("Używam Facebooka!");
    }
}
