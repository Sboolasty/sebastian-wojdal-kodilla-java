package com.kodilla.testing;
import java.util.*;
import java.lang.*;
import java.io.*;
import com.kodilla.testing.calculator.*;

public class TestingMain {
    public static void main(String[] args) {
    Calculator calculator = new Calculator();
    int addResult = calculator.addAToB(180, 19);
    int subResult = calculator.subtractAFromB(150, 250);
      if (addResult == 199) {
        System.out.println("Calculator add function test OK");
    } else {
        System.out.println("Calculator add function has error!");
    }
        if (subResult == 100) {
            System.out.println("Calculator substract function test OK");
        } else {
            System.out.println("Calculator substract function has error!");
        }
}
}
