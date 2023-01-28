package com.kodilla.stream.forumuser;

import com.kodilla.stream.forumuser.*;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        Forum forum = new Forum();

        Map<Integer, ForumUser> resultUsers = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> forumUser.countAge() >= 20)
                .filter(forumUser -> forumUser.getPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getID, forumUser -> forumUser));

        resultUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

    }
}
