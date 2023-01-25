package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int users;
    private int posts;
    private int comments;
    private double averagePostsUser;
    private double averageCommentsUser;
    private double averageCommentsPost;

    public int getUsers() {
        return users;
    }

    public int getPosts() {
        return posts;
    }

    public int getComments() {
        return comments;
    }

    public double getAveragePostsUser() {
        return averagePostsUser;
    }

    public double getAverageCommentsUser() {
        return averageCommentsUser;
    }

    public double getAverageCommentsPost() {
        return averageCommentsPost;
    }

    void calculateAdvStatistics(Statistics statistics) {
        users = statistics.usersNames().size();
        posts = statistics.postsCount();
        comments = statistics.commentsCount();
        if (users > 0){
            averagePostsUser = (double)posts/users;
            averageCommentsUser = (double)comments/users;
        }
        if (comments > 0) averageCommentsPost = (double) comments / posts;
    }

    void showStatistics() {
        System.out.println("Users: "+users);
        System.out.println("Posts: "+posts);
        System.out.println("Comments: "+comments);
        System.out.println("Average posts per user: "+averagePostsUser);
        System.out.println("Average comments per user: "+averageCommentsUser);
        System.out.println("Average comments per post: "+averageCommentsPost);
    }
}