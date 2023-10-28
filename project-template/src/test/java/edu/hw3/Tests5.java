package edu.hw3;

import edu.hw3.Task5.PhoneContact;
import edu.hw3.Task5.Task5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests5 {

    private static Stream<Arguments> provideArgs() {
        return Stream.of(
            Arguments.of(
                List.of("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"),
                "ASC", List.of(
                    new PhoneContact("Thomas", "Aquinas"),
                    new PhoneContact("Rene", "Descartes"),
                    new PhoneContact("David", "Hume"),
                    new PhoneContact("John", "Locke")
                )
            ),
            Arguments.of(
                List.of("Paul Erdos", "Leonhard Euler", "Carl Gauss"),
                "DESC",
                List.of(
                    new PhoneContact("Carl", "Gauss"),
                    new PhoneContact("Leonhard", "Euler"),
                    new PhoneContact("Paul", "Erdos")
                )
            )
        );
    }

    @ParameterizedTest
    @DisplayName("T-0")
    @MethodSource("provideArgs")
    public void test0(List<String> input, String srt, List<PhoneContact> expected) {
        assertEquals(expected, Task5.parseContacts(input, srt));
    }
}
