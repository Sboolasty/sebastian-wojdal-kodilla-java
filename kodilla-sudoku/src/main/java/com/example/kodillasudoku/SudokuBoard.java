package com.example.kodillasudoku;


import java.util.ArrayList;
import java.util.List;

import static com.example.kodillasudoku.SudokuRunner.BOARD_SIZE;
import static com.example.kodillasudoku.SudokuRunner.EMPTY;


public class SudokuBoard {
    List<SudokuRow> sudokuBoard = new ArrayList<>(BOARD_SIZE);

    public SudokuBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            sudokuBoard.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getSudokuBoard() {
        return sudokuBoard;
    }

    @Override
    public String toString() {
        final String BLANK_SPACE = " ";
        StringBuilder boardToDisplay = new StringBuilder();
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                for (int i = 0; i < BOARD_SIZE; i++) {
                    boardToDisplay.append("-");
                    if (i == BOARD_SIZE-1) boardToDisplay.append("\n");
                }
            }
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (column % 3 == 0 && column != 0) {
                    boardToDisplay.append("|");
                }
                if (sudokuBoard.get(column).getSudokuRow().get(row).getValue() == EMPTY)
                {
                    boardToDisplay.append(BLANK_SPACE);
                }
                else{
                    boardToDisplay.append(sudokuBoard.get(column).getSudokuRow().get(row).getValue());
                }
            }
            boardToDisplay.append("\n");
        }
        return boardToDisplay.toString();
    }
}