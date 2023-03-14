package com.example.kodillagoodpatterns.challenges.OrderingSystem;

import java.time.LocalDateTime;

public class Order {
    private User user;
    private LocalDateTime dateOfOrder;

    public Order(User user, LocalDateTime dateOfOrder) {
        this.user = user;
        this.dateOfOrder = dateOfOrder;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }
}