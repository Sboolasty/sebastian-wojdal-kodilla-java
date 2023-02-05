package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge challenge = new SecondChallenge();
        double x = 5;
        double y = 1;

        try {
            System.out.println(challenge.probablyIWillThrowException(x,y));
        }
        catch (Exception e) {
            System.out.println("Łapie wyjątek " + e);
        }
        finally {
            System.out.println("Działa jak natura chciała...");
        }
    }
}