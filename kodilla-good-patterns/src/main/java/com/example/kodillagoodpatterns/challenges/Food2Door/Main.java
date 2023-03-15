package com.example.kodillagoodpatterns.challenges.Food2Door;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(new ExtraFoodShop(), 10, "apples");
        OrderProcessor processor = new OrderProcessor();
        boolean result = processor.processOrder(order);
        if (result) {
            System.out.println("Order processed successfully");
        } else {
            System.out.println("Order processing failed");
        }
    }
}