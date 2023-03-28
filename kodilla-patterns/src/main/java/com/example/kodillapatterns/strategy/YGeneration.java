package com.example.kodillapatterns.strategy;

sealed public class YGeneration extends User {
    public YGeneration(String userName) {
        super(userName);
        setSocialPublisher(new TwitterPublisher());
    }
}
