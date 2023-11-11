package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests7 {
    @org.junit.jupiter.api.Test
    @DisplayName("test7_1_1")
    void test7_1_1() {
        assertTrue(Tasks.Task7_1("100" ));
    }
    @org.junit.jupiter.api.Test
    @DisplayName("test7_1_2")
    void test7_1_2() {
        assertFalse(Tasks.Task7_1("101" ));
    }
    @org.junit.jupiter.api.Test
    @DisplayName("test7_1_3")
    void test7_1_3() {
        assertTrue(Tasks.Task7_1("1001" ));
    }
    @org.junit.jupiter.api.Test
    @DisplayName("test7_1_4")
    void test7_1_4() {
        assertFalse(Tasks.Task7_1("121" ));
    }


    @org.junit.jupiter.api.Test
    @DisplayName("test7_2_1")
    void test7_2_1() {
        assertTrue(Tasks.Task7_2("101" ));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test7_2_2")
    void test7_2_2() {
        assertTrue(Tasks.Task7_2("1" ));
    }
    @org.junit.jupiter.api.Test
    @DisplayName("test7_2_3")
    void test7_2_3() {
        assertTrue(Tasks.Task7_2("00000" ));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test7_2_4")
    void test7_2_4() {
        assertFalse(Tasks.Task7_2("100" ));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test7_3_1")
    void test7_3_1() {
        assertTrue(Tasks.Task7_3("100" ));
    }
    @org.junit.jupiter.api.Test
    @DisplayName("test7_3_2")
    void test7_3_2() {
        assertTrue(Tasks.Task7_3("11" ));
    }
    @org.junit.jupiter.api.Test
    @DisplayName("test7_3_3")
    void test7_3_3() {
        assertTrue(Tasks.Task7_3("0" ));
    }
    @org.junit.jupiter.api.Test
    @DisplayName("test7_3_4")
    void test7_3_4() {
        assertFalse(Tasks.Task7_3("" ));
    }
    @org.junit.jupiter.api.Test
    @DisplayName("test7_3_5")
    void test7_3_5() {
        assertFalse(Tasks.Task7_3("1111" ));
    }
    @org.junit.jupiter.api.Test
    @DisplayName("test7_3_6")
    void test7_3_6() {
        assertFalse(Tasks.Task7_3("121" ));
    }
}
