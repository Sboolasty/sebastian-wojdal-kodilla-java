package com.example.kodillaspring.calculator;

import com.example.calculator.Calculator;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculations() {
        // given
        double a = 4;
        double b = 2;

        // when
        double additionResult = calculator.add(a, b);
        double subtractionResult = calculator.sub(a, b);
        double multiplicationResult = calculator.mul(a, b);
        double divisionResult = calculator.div(a, b);

        // then
        assertEquals(6, additionResult, 0);
        assertEquals(2, subtractionResult, 0);
        assertEquals(8, multiplicationResult, 0);
        assertEquals(2, divisionResult, 0);
    }
}