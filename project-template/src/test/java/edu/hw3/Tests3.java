package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests3 {
    private static Stream<Arguments> provideArgs() {
        return Stream.of(
            Arguments.of(
                List.of("a", "bb", "a", "bb"),
                Map.of("bb", 2, "a", 2)
            ),
            Arguments.of(
                List.of("this", "and", "that", "and"),
                Map.of("this", 1, "that", 1, "and", 2)
            ),
            Arguments.of(
                List.of("код", "код", "код", "bug"),
                Map.of("код", 3, "bug", 1)
            ),
            Arguments.of(
                List.of(1, 1, 2, 2),
                Map.of(1, 2, 2, 2)
            )
        );
    }

    @ParameterizedTest
    @DisplayName("T-0")
    @MethodSource("provideArgs")
    public <T> void test0(List<T> input, Map<T, Integer> expected) {
        assertEquals(expected, Task3.freqDict(input));
    }

}
