package com.example.kodillagoodpatterns2.observer.forum.homework;

import java.util.Observer;

public class HomeworkTestSuite {
    public static void main(String[] args) {
        HomeworkQueue johnsQueue = new HomeworkQueue("John");
        HomeworkQueue sarahsQueue = new HomeworkQueue("Sarah");

        Mentor mentor1 = new Mentor("Mentor1");
        Mentor mentor2 = new Mentor("Mentor2");

        johnsQueue.addObserver(mentor1);
        sarahsQueue.addObserver(mentor1);
        sarahsQueue.addObserver(mentor2);

        johnsQueue.addTask("Complete exercise 1");
        johnsQueue.addTask("Complete exercise 2");
        sarahsQueue.addTask("Complete exercise 3");

        System.out.println("John's tasks: " + johnsQueue.getTasks());
        System.out.println("Sarah's tasks: " + sarahsQueue.getTasks());
    }
}