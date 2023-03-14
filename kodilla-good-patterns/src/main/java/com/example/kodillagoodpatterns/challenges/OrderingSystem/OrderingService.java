package com.example.kodillagoodpatterns.challenges.OrderingSystem;

import java.time.LocalDateTime;

public interface OrderingService {
    boolean order(User user, LocalDateTime date);
}