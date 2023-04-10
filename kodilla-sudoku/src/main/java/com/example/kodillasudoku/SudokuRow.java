package com.example.kodillasudoku;


import java.util.ArrayList;
import java.util.List;

import static com.example.kodillasudoku.SudokuRunner.BOARD_SIZE;

public class SudokuRow {
    List<SudokuElement> sudokuRow = new ArrayList<>(BOARD_SIZE);

    public SudokuRow() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            sudokuRow.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getSudokuRow() {
        return sudokuRow;
    }
}
