package com.example.kodillagoodpatterns.challenges.OrderingSystem;

import com.example.kodillagoodpatterns.challenges.OrderingSystem.*;

public class Main {
    public static void main(String[] args) {

        OrderRetriever orderRetriever = new OrderRetriever();
        Order order = orderRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(new MailInformation(),
                new ClothesOrderingService(), new ClothesOrdersRepository());
        orderProcessor.process(order);
    }
}



