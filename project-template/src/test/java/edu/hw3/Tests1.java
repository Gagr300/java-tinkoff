package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests1 {
    Task1 task1 = new Task1();

    @Test
    @DisplayName("T-0")
    void test0() {
        String input = "hh";
        String output = task1.atbash(input);
        assertEquals("ss", output);
    }

    @Test
    @DisplayName("T-1")
    void test1() {
        String input = "AbC";
        String output = task1.atbash(input);
        assertEquals("ZyX", output);
    }

    @Test
    @DisplayName("T-2")
    void test2() {
        String input = "Hello world!";
        String output = task1.atbash(input);
        assertEquals("Svool dliow!", output);
    }

    @Test
    @DisplayName("T-3")
    void test3() {
        String input =
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        String output = task1.atbash(input);
        assertEquals(
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi",
            output
        );
    }
}
