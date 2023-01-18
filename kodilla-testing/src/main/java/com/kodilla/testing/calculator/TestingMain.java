package com.kodilla.testing.calculator;

    public class TestingMain {

        public static void main(String[] args) {

            Calculator calculator = new Calculator();

            int addResult = calculator.addAToB(180, 30);
            int subResult = calculator.subtractAFromB(150, 200);
            if (addResult == 210 && subResult == 50) {
                System.out.println("Calculator test OK");
            } else {
                System.out.println("Calculator has error!");
            }
        }
    }

