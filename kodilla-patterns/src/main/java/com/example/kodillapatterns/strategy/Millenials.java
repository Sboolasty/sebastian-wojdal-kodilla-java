package com.example.kodillapatterns.strategy;

sealed public class Millenials extends User {
    public Millenials(String userName) {
        super(userName);
        setSocialPublisher(new FacebookPublisher());
    }
}
