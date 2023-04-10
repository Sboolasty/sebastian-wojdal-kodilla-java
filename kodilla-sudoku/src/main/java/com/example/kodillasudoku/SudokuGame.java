package com.example.kodillasudoku;


import java.util.Arrays;

import static com.example.kodillasudoku.SudokuRunner.BOARD_SIZE;
import static com.example.kodillasudoku.SudokuRunner.EMPTY;

public class SudokuGame {

    SudokuBoard sudokuBoard;

    public SudokuGame() {
        this.sudokuBoard = new SudokuBoard();
    }

    boolean resolveSudoku(){
        System.out.println(sudokuBoard);
        System.out.println("Input 3 numbers (x,y,value) to input into table; Q/Quit/E/Exit for exit; S/Solve/Sudoku to solve");
        TerminalInput terminalInput = new TerminalInput();
        String scannedLine = terminalInput.scanInput().toLowerCase();
        if (scannedLine.contains("q") || scannedLine.contains("e")) return true;
        if (scannedLine.contains("s")) {
            boolean solvable = solveBoard(sudokuBoard);
            if (!solvable) {
                System.out.println("Cannot solve this board configuration");
            }
            else {
                System.out.println("Solved board:");
                System.out.println(sudokuBoard);
                System.out.println("New input board:");
                sudokuBoard = new SudokuBoard();
            }
            return false;
        }
        String[] scannedNumbers = scannedLine.split(",");

        if (Arrays.stream(scannedNumbers).count() == 3){
            int column = EMPTY;
            int row = EMPTY;
            int number = EMPTY;
            try {
                column = Integer.parseInt(scannedNumbers[0]);
                row = Integer.parseInt(scannedNumbers[1]);
                number = Integer.parseInt(scannedNumbers[2]);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input");
            }

            if (number<(BOARD_SIZE+1) && number > 0
                    && row<(BOARD_SIZE+1) && row > 0
                    && column<(BOARD_SIZE+1) && column > 0)
            {
                if (isValid(sudokuBoard,number,row,column)) {
                    sudokuBoard.getSudokuBoard().get(column - 1).getSudokuRow().get(row - 1).setValue(number);
                }
                else {
                    System.out.println("This number cannot be placed there");
                }
            }
            else {
                System.out.println("Invalid number/coordinates");
            }
        }
        else {
            System.out.println("Invalid input");
        }
        return false;
    }

    private boolean checkRow(SudokuBoard board, int numberToCheck, int rowToCheck) {
        for (int column = 0; column < BOARD_SIZE; column++) {
            if (board.getSudokuBoard().get(column).getSudokuRow().get(rowToCheck).getValue() == numberToCheck) {
                return true;
            }
        }
        return false;
    }
    private boolean checkColumn(SudokuBoard board, int numberToCheck, int columnToCheck) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (board.getSudokuBoard().get(columnToCheck).getSudokuRow().get(row).getValue() == numberToCheck) {
                return true;
            }
        }
        return false;
    }
    private boolean checkBox(SudokuBoard board, int number, int rowToCheck, int columnToCheck) {
        int boxRow = rowToCheck - rowToCheck % 3;
        int boxColumn = columnToCheck - columnToCheck % 3;

        for (int row = boxRow; row < boxRow + 3; row++) {
            for (int column = boxColumn; column < boxColumn + 3; column++) {
                if (board.getSudokuBoard().get(column).getSudokuRow().get(row).getValue() == number) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isValid(SudokuBoard board, int number, int row, int column) {
        return !checkRow(board, number, row) &&
                !checkColumn(board, number, column) &&
                !checkBox(board, number, row, column);
    }
    public boolean solveBoard(SudokuBoard board) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (board.getSudokuBoard().get(column).getSudokuRow().get(row).getValue() == EMPTY) {
                    for (int numberToTry = 1; numberToTry <= BOARD_SIZE; numberToTry++) {
                        if (isValid(board, numberToTry, row, column)) {
                            board.getSudokuBoard().get(column).getSudokuRow().get(row).setValue(numberToTry);
                            if (solveBoard(board)) {
                                return true;
                            }
                            else {
                                board.getSudokuBoard().get(column).getSudokuRow().get(row).setValue(EMPTY);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}