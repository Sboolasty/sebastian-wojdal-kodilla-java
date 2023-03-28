package com.example.kodillapatterns.strategy;

sealed public class ZGeneration extends User {
    public ZGeneration(String userName) {
        super(userName);
        setSocialPublisher(new SnapchatPublisher());
    }
}
