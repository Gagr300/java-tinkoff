package edu.hw7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static edu.hw7.Task4.calculateMonteCarloPi;
import static edu.hw7.Task4.calculateMonteCarloPiMulti;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests4 {

    @Test
    public void test1() {
        int iterNum = 10000000;
        double actual = calculateMonteCarloPi(iterNum);
        assertTrue(actual >= 3 && actual <= 4);
        double appr = calculateMonteCarloPi(iterNum);
        double error = Math.abs(appr - Math.PI);
        double tolerance = 0.01;
        System.out.println("iter: " + iterNum + "\tactual: " + actual + "\t error: " + error);
        assertTrue(error <= tolerance);
    }

    @Test
    public void test2() {
        int iterNum = 1000000000;
        double actual = calculateMonteCarloPi(iterNum);
        assertTrue(actual >= 3 && actual <= 4);
        double appr = calculateMonteCarloPi(iterNum);
        double error = Math.abs(appr - Math.PI);
        double tolerance = 0.0001;
        System.out.println("iter: " + iterNum + "\tactual: " + actual + "\t error: " + error);
        assertTrue(error <= tolerance);
    }

    @ParameterizedTest
    @CsvSource({"1,100000", "2,100000", "3,100000", "4,100000", "5,100000000", "6,100000000"})
    public void test2(int threadNum, int iterNum) throws Exception {
        long startTime = System.nanoTime();
        double actual = calculateMonteCarloPiMulti(iterNum, threadNum);
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        System.out.println("iter: " + iterNum + "\tthreads: " + threadNum + "\tactual: " + actual + "\ttime: " + time);
        assertTrue(actual >= 3 && actual <= 3.5);
    }
}
