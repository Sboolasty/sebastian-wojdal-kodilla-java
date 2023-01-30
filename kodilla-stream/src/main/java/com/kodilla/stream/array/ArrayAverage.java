package com.kodilla.stream.array;

import java.util.stream.IntStream;

public class ArrayAverage implements ArrayOperations {

    public double getAverage(int[] numbers) {
        IntStream.of(numbers).forEach(System.out::println);

        double average = IntStream.range(0, numbers.length)
                .mapToDouble(k -> numbers[k])
                .average()
                .getAsDouble();

        return average;
    }
}