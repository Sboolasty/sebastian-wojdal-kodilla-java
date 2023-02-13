package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {

        boolean end = false;
        GameLogic gameLogic = new GameLogic();
        System.out.println("Welcome to RPS!");
        gameLogic.newGame();

        while (!gameLogic.isGameOver()) {
            gameLogic.nextMove();
            gameLogic.checkFinalWin();
            end = gameLogic.isGameOver();
        }
    }
}