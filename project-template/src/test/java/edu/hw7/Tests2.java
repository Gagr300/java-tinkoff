package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests2 {

    @Test
    @DisplayName("Task2")
    void test0() {
        int x = 0;
        int expected = 1;
        assertEquals(expected, Task2.task2(x));
    }

    @Test
    @DisplayName("Task2")
    void test1() {
        int x = 1;
        int expected = 1;
        assertEquals(expected, Task2.task2(x));
    }

    @Test
    @DisplayName("Task2")
    void test2() {
        int x = 5;
        int expected = 120;
        assertEquals(expected, Task2.task2(x));
    }

    @Test
    @DisplayName("Task2")
    void test3() {
        int x = -10;
        int expected = -1;
        assertEquals(expected, Task2.task2(x));
    }
}
