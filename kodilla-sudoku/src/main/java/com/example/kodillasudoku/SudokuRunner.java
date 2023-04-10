package com.example.kodillasudoku;

public class SudokuRunner {
    public final static int BOARD_SIZE = 9;
    public final static int EMPTY = -1;
    public static void main(String[] args) {
        System.out.println("Welcome to sudoku solver");
        boolean gameFinished = false;
        SudokuGame theGame = new SudokuGame();
        while (!gameFinished) {
            gameFinished = theGame.resolveSudoku();
        }
    }
}