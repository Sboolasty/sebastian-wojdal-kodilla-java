package com.example.kodillagoodpatterns2.observer.forum.homework;


import java.util.ArrayList;
import java.util.List;

public class HomeworkQueue {
    private final List<HomeworkObserver> observers;
    private final List<String> tasks;
    private final String studentName;

    public HomeworkQueue(String studentName) {
        this.observers = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.studentName = studentName;
    }

    public void addObserver(HomeworkObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(HomeworkObserver observer) {
        observers.remove(observer);
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }

    private void notifyObservers() {
        for (HomeworkObserver observer : observers) {
            observer.update(this);
        }
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getStudentName() {
        return studentName;
    }
}