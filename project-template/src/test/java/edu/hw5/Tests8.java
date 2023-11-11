package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests8 {
    @org.junit.jupiter.api.Test
    @DisplayName("test8_1")
    void test8_1t() {
        assertTrue(Tasks.Task8_1("101"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test8_1")
    void test8_1f() {
        assertFalse(Tasks.Task8_1("11"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test8_2")
    void test8_2t1() {
        assertTrue(Tasks.Task8_2("011"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test8_2")
    void test8_2t2() {
        assertTrue(Tasks.Task8_2("11"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test8_2")
    void test8_2f() {
        assertFalse(Tasks.Task8_2("101"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test8_3")
    void test8_3t() {
        assertTrue(Tasks.Task8_3("01100"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test8_3")
    void test8_3f() {
        assertFalse(Tasks.Task8_3("1010001111"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test8_4")
    void test8_4t() {
        assertTrue(Tasks.Task8_4("011"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test8_4")
    void test8_4f() {
        assertFalse(Tasks.Task8_4("11"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test8_5")
    void test8_5t1() {
        assertTrue(Tasks.Task8_5("1010"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test8_5")
    void test8_5t2() {
        assertTrue(Tasks.Task8_5("1"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test8_5")
    void test8_5f() {
        assertFalse(Tasks.Task8_5("00"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test8_6")
    void test8_6t() {
        assertTrue(Tasks.Task8_6("000100000000"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test8_6")
    void test8_6f() {
        assertFalse(Tasks.Task8_6("0011"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test8_7")
    void test8_7t() {
        assertTrue(Tasks.Task8_7("000100010000101"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test8_7")
    void test8_7f() {
        assertFalse(Tasks.Task8_7("01011010"));
    }
}
