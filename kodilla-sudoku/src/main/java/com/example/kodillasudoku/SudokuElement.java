package com.example.kodillasudoku;


import static com.example.kodillasudoku.SudokuRunner.EMPTY;


public class SudokuElement {
    private int value = EMPTY;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}