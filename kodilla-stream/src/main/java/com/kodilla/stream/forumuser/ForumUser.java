package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private int ID;
    private String name;
    private char sex;
    private LocalDate birthDate;
    private int posts;

    public ForumUser(int ID, String name, char sex, LocalDate birthDate, int posts) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.posts = posts;
    }

    public int countAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", posts=" + posts +
                '}';
    }
}