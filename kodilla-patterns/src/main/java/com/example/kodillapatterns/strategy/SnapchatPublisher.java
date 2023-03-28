package com.example.kodillapatterns.strategy;

public class SnapchatPublisher implements SocialPublisher {
    @Override
    public void share() {
        System.out.println("Używam Snapchata!");
    }
}
