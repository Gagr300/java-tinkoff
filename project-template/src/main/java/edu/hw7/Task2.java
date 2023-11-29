package edu.hw7;

import java.util.stream.IntStream;

public class Task2 {

    public static int task2(int x) {
        if (x < 0) {
            return -1;
        }
        return IntStream
            .rangeClosed(1, x)
            .parallel()
            .reduce((a, b) -> a * b)
            .orElse(1);
    }
}
