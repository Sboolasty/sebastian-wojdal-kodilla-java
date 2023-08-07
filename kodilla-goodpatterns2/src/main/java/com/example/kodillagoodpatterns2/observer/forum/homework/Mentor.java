package com.example.kodillagoodpatterns2.observer.forum.homework;


public class Mentor implements HomeworkObserver {
    private final String mentorName;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(HomeworkQueue homeworkQueue) {
        System.out.println("Hey " + mentorName + "! New task in queue for student: " + homeworkQueue.getStudentName());
    }
}