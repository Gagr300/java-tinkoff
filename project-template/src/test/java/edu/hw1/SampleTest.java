package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTest {

    //Task1

    @Test
    @DisplayName("true minutesToSeconds 0")
    void minutesToSecondsT0() {
        String in = "01:00";
        int expectedResult = 60;
        int actualResult = Task1.minutesToSeconds(in);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("true minutesToSeconds 1")
    void minutesToSecondsT1() {
        String in = "13:56";
        int expectedResult = 836;
        int actualResult = Task1.minutesToSeconds(in);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("true minutesToSeconds 2")
    void minutesToSecondsT2() {
        String in = "100:00";
        int expectedResult = 6000;
        int actualResult = Task1.minutesToSeconds(in);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("false minutesToSeconds 0")
    void minutesToSecondsT3() {
        String in = "01:00:00";
        int expectedResult = -1;
        int actualResult = Task1.minutesToSeconds(in);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("false minutesToSeconds 1")
    void minutesToSecondsT4() {
        String in = "10:60";
        int expectedResult = -1;
        int actualResult = Task1.minutesToSeconds(in);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("false minutesToSeconds 2")
    void minutesToSecondsT5() {
        String in = "-10:20";
        int expectedResult = -1;
        int actualResult = Task1.minutesToSeconds(in);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("false minutesToSeconds 3")
    void minutesToSecondsT6() {
        String in = "10:-06";
        int expectedResult = -1;
        int actualResult = Task1.minutesToSeconds(in);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("false minutesToSeconds 4")
    void minutesToSecondsT7() {
        String in = "100:1";
        int expectedResult = -1;
        int actualResult = Task1.minutesToSeconds(in);
        assertEquals(expectedResult, actualResult);
    }

    //Task2
    @Test
    @DisplayName("countDigits")
    void countDigitsT0() {
        int in = 4666;
        int expectedResult = 4;
        int actualResult = Task1.countDigits(in);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("countDigits")
    void countDigitsT1() {
        int in = 544;
        int expectedResult = 3;
        int actualResult = Task1.countDigits(in);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("countDigits")
    void countDigitsT2() {
        int in = 0;
        int expectedResult = 1;
        int actualResult = Task1.countDigits(in);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("countDigits")
    void countDigitsT3() {
        int in = -100;
        int expectedResult = 3;
        int actualResult = Task1.countDigits(in);
        assertEquals(expectedResult, actualResult);
    }

    //Task3

    @Test
    @DisplayName("true isNestable 0")
    void isNestableT0() {
        int[] in0 = new int[] {1, 2, 3, 4};
        int[] in1 = new int[] {0, 6};
        boolean expectedResult = true;
        boolean actualResult = Task1.isNestable(in0, in1);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("true isNestable 1")
    void isNestableT1() {
        int[] in0 = new int[] {3, 1};
        int[] in1 = new int[] {4, 0};
        boolean expectedResult = true;
        boolean actualResult = Task1.isNestable(in0, in1);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("false isNestable 0")
    void isNestableT2() {
        int[] in0 = new int[] {9, 9, 8};
        int[] in1 = new int[] {8, 9};
        boolean expectedResult = false;
        boolean actualResult = Task1.isNestable(in0, in1);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("false isNestable 1")
    void isNestableT3() {
        int[] in0 = new int[] {1, 2, 3, 4};
        int[] in1 = new int[] {2, 3};
        boolean expectedResult = false;
        boolean actualResult = Task1.isNestable(in0, in1);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("false isNestable 2")
    void isNestableT4() {
        int[] in0 = new int[] {1, 2, 3, 4};
        int[] in1 = new int[] {};
        boolean expectedResult = false;
        boolean actualResult = Task1.isNestable(in0, in1);
        assertEquals(expectedResult, actualResult);
    }

    //Task4
    @Test
    @DisplayName("even fixString")
    void fixStringT0() {
        String in = "123456";
        String expectedResult = "214365";
        String actualResult = String.valueOf(Task1.fixString(in));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("even fixString")
    void fixStringT1() {
        String in = "hTsii  s aimex dpus rtni.g";
        String expectedResult = "This is a mixed up string.";
        String actualResult = String.valueOf(Task1.fixString(in));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("odd fixString")
    void fixStringT2() {
        String in = "badce";
        String expectedResult = "abcde";
        String actualResult = String.valueOf(Task1.fixString(in));
        assertEquals(expectedResult, actualResult);
    }

    //Task5
    @Test
    @DisplayName("isPalindromeDescendantT0")
    void isPalindromeDescendantT0() {
        int in = 11211230;
        boolean expectedResult = true;
        boolean actualResult = Task1.isPalindromeDescendant(in);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("isPalindromeDescendantT1")
    void isPalindromeDescendantT1() {
        int in = 13001120;
        boolean expectedResult = true;
        boolean actualResult = Task1.isPalindromeDescendant(in);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("isPalindromeDescendantT2")
    void isPalindromeDescendantT2() {
        int in = 23336014;
        boolean expectedResult = true;
        boolean actualResult = Task1.isPalindromeDescendant(in);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("isPalindromeDescendantT3")
    void isPalindromeDescendantT3() {
        int in = 11;
        boolean expectedResult = true;
        boolean actualResult = Task1.isPalindromeDescendant(in);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("false isPalindromeDescendantF0")
    void isPalindromeDescendanF0() {
        int in = 12;
        boolean expectedResult = false;
        boolean actualResult = Task1.isPalindromeDescendant(in);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("false isPalindromeDescendantF0")
    void isPalindromeDescendanF1() {
        int in = -11;
        boolean expectedResult = false;
        boolean actualResult = Task1.isPalindromeDescendant(in);
        assertEquals(expectedResult, actualResult);
    }
    //Task6
    @Test
    @DisplayName("countKT0")
    void countKT0() {
        int in = 6621;
        int expectedResult = 5;
        int actualResult = Task1.countK(in);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("countKT1")
    void countKT1() {
        int in = 6554;
        int expectedResult = 4;
        int actualResult = Task1.countK(in);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("countKT2")
    void countKT2() {
        int in = 1234;
        int expectedResult = 3;
        int actualResult = Task1.countK(in);
        assertEquals(expectedResult, actualResult);
    }


    //Task7
    @Test
    @DisplayName("rotateRightT0")
    void rotateRightT0() {
        int in0 = 8;
        int in1 = 1;
        int expectedResult = 4;
        int actualResult = Task1.rotateRight(in0, in1);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("rotateLeftT0")
    void rotateLeftT0() {
        int in0 = 16;
        int in1 = 1;
        int expectedResult = 1;
        int actualResult = Task1.rotateLeft(in0, in1);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("rotateLeftT1")
    void rotateLeftT1() {
        int in0 = 17;
        int in1 = 2;
        int expectedResult = 6;
        int actualResult = Task1.rotateLeft(in0, in1);
        assertEquals(expectedResult, actualResult);
    }


    //Task8

    @Test
    @DisplayName("Right knightBoardCapture")
    void knightBoardCaptureT() {
        int[][] in = new int[][] {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };
        boolean expectedResult = true;
        boolean actualResult = Task1.knightBoardCapture(in);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    @DisplayName("Wrong knightBoardCapture 0")
    void knightBoardCaptureF0() {
        int[][] in = new int[][] {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };
        boolean expectedResult = false;
        boolean actualResult = Task1.knightBoardCapture(in);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Wrong knightBoardCapture 1")
    void knightBoardCaptureF1() {
        int[][] in = new int[][] {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        };
        boolean expectedResult = false;
        boolean actualResult = Task1.knightBoardCapture(in);
        assertEquals(expectedResult, actualResult);
    }
}
