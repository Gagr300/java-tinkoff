package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {

    @org.junit.jupiter.api.Test
    @DisplayName("test1")
    void test1() {
        Duration exp = Duration.ofMinutes(3 * 60 + 40);
        assertEquals(
            exp,
            Tasks.task1(List.of(
                "2022-03-12, 20:20 - 2022-03-12, 23:50",
                "2022-04-01, 21:30 - 2022-04-02, 01:20"
            ))
        );
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test2_1")
    void test2_1() {
        assertEquals(
            List.of(
                LocalDate.of(1925, 2, 13),
                LocalDate.of(1925, 3, 13),
                LocalDate.of(1925, 11, 13)
            ),
            Tasks.task2(1925)
        );
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test2_2")
    void test2_2() {
        assertEquals(
            List.of(
                LocalDate.of(2024, 9, 13),
                LocalDate.of(2024, 12, 13)
            ),
            Tasks.task2(2024)
        );
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test3")
    void test3_1() {
        assertEquals(
            Optional.of(LocalDate.of(2020, 10, 10)),
            Tasks.task3("2020-10-10")
        );
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test3")
    void test3_2() {
        assertEquals(
            Optional.of(LocalDate.of(2020, 12, 2)),
            Tasks.task3("2020-12-2")
        );
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test3")
    void test3_3() {
        assertEquals(
            Optional.of(LocalDate.of(1976, 3, 1)),
            Tasks.task3("1/3/1976")
        );
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test3")
    void test3_4() {
        assertEquals(
            Optional.of(LocalDate.of(2020, 3, 1)),
            Tasks.task3("1/3/20")
        );
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test3")
    void test3_5() {
        assertEquals(
            Optional.of(LocalDate.of(2023, 11, 12)),
            Tasks.task3("tomorrow")
        );
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test3")
    void test3_6() {
        assertEquals(
            Optional.of(LocalDate.of(2023, 11, 1)),
            Tasks.task3("10 days ago")
        );
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test4_1")
    void test4_1() {
        assertTrue(Tasks.task4("dfkjidfhifd|iuh!7"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test4_2")
    void test4_2() {
        assertTrue(Tasks.task4("dfkjidfh~ifdiuh7"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test4_3")
    void test4_3() {
        assertFalse(Tasks.task4("dfkjidfhifdiuh"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test5_1")
    void test5_1() {
        assertTrue(Tasks.task5("А123ВЕ777"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test5_2")
    void test5_2() {
        assertTrue(Tasks.task5("О777ОО177"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test5_3")
    void test5_3() {
        assertFalse(Tasks.task5("123АВЕ777"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test5_4")
    void test5_4() {
        assertFalse(Tasks.task5("А123ВГ77"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test5_5")
    void test5_5() {
        assertFalse(Tasks.task5("А123ВЕ7777"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test6_1")
    void test6_1() {
        assertTrue(Tasks.task6("hdgcjhdsabchjkfd", "abc"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test6_2")
    void test6_2() {
        assertTrue(Tasks.task6("hdgcjhdsabchjabcabckfd", "abc"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("test6_3")
    void test6_3() {
        assertFalse(Tasks.task6("hdgcjhdkfd", "abc"));
    }

}
