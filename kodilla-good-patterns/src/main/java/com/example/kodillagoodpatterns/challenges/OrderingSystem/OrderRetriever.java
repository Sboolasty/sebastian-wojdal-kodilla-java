package com.example.kodillagoodpatterns.challenges.OrderingSystem;

import java.time.LocalDateTime;

public class OrderRetriever {

    public Order retrieve() {
        User user = new User("alatomala", "Ala", "Tomala");

        LocalDateTime orderDate = LocalDateTime.of(2018, 3, 12, 9, 15);

        return new Order(user, orderDate);
    }
}