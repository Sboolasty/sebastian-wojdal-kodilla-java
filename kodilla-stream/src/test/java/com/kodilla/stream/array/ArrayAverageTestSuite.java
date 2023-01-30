package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayAverageTestSuite {

    @Test
    public void getAverageTest() {

        //given
        int[] testArray = new int[10];
        for (int i = 0; i < 10; i++) {
            testArray[i] = i * 5;
        }

        ArrayAverage arrayAverage = new ArrayAverage();

        //when
        double testAverage = arrayAverage.getAverage(testArray);

        //then
        Assert.assertEquals(22.5, testAverage, 0.001);
    }
}