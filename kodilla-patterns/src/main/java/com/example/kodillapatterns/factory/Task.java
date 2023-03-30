package com.example.kodillapatterns.factory;

public interface Task {
    void executeTask();
    String getTaskName();
    boolean isTaskExecuted();
}