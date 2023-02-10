package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {

        boolean end = false;
        GameLogic gameLogic = new GameLogic();
        System.out.println("Welcome to RPS!");
        gameLogic.NewGame();

        while (!end) {
            gameLogic.NextMove();
            gameLogic.checkFinalWin();
            end = gameLogic.isEnd();
        }
    }
}