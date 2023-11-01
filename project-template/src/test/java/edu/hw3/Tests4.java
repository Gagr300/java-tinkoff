package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests4 {
    private static Stream<Arguments> provideArgs() {
        return Stream.of(
            Arguments.of(2, "II"),
            Arguments.of(12, "XII"),
            Arguments.of(16, "XVI")
        );
    }

    @ParameterizedTest
    @DisplayName("T-0")
    @MethodSource("provideArgs")
    public <T> void test0(Integer input, String expected) {
        assertEquals(expected, Task4.convertToRoman(input));
    }

}
