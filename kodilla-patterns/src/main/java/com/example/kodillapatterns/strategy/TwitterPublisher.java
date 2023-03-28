package com.example.kodillapatterns.strategy;

public class TwitterPublisher implements SocialPublisher {
    @Override
    public void share() {
        System.out.println("Używam Twittera!");
    }
}
