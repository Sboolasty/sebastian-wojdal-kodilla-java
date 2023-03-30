package com.example.kodillapatterns.factory;


public class TaskFactory {

    public static final String SHOPPING = "Shopping";
    public static final String PAINTING = "Painting";
    public static final String DRIVING = "Driving";

    public Task makeTask(String taskType) {
        switch (taskType) {
            case SHOPPING:
                return new ShoppingTask("Grocery shopping", "bread", 1.0);
            case PAINTING:
                return new PaintingTask("Painting the room", "blue", "walls");
            case DRIVING:
                return new DrivingTask("Driving to the airport", "airport", "car");
            default:
                throw new IllegalArgumentException("Unsupported task type: " + taskType);
        }
    }
}