package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {

    @Test
    @DisplayName("Ф")
    void minutesToSeconds() {
        String in = "01:00";
        int out = 60;
        int actualResult = Task1.minutesToSeconds(in);
        // then
        assertThat(actualResult).isEqualTo(out);
    }
}
