package com.example.kodillagoodpatterns.challenges.Food2Door;

public class OrderProcessor {
    public boolean processOrder(Order order) {
        Supplier supplier = order.getSupplier();
        return supplier.process(order);
    }
}