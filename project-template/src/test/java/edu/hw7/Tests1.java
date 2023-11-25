package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests1 {
    @Test
    @DisplayName("task1")
    void test3() throws InterruptedException {
        int x = 0;
        int threadCnt = 10;
        assertEquals(x + threadCnt, Task1.task1(x, threadCnt));
    }

    @Test
    @DisplayName("task1")
    void test1() throws InterruptedException {
        int x = 38;
        int threadCnt = 38;
        assertEquals(x + threadCnt, Task1.task1(x, threadCnt));
    }

    @Test
    @DisplayName("task1")
    void test2() throws InterruptedException {
        int x = -10;
        int threadCnt = 1;
        assertEquals(x + threadCnt, Task1.task1(x, threadCnt));
    }

}
