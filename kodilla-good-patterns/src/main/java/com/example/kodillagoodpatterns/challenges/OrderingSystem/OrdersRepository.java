package com.example.kodillagoodpatterns.challenges.OrderingSystem;

import java.time.LocalDateTime;

public interface OrdersRepository {
    boolean createOrder(User user, LocalDateTime date);
}