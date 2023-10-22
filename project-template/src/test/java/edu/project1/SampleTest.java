package edu.project1;

import edu.hw1.EvenArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {
    @Test
    @DisplayName("Фильтрация четных чисел")
    void filterEvenNumbers() {
        int[] numbers = new int[] {1, 2, 3, 4, 5};
        int[] evenNumbers = EvenArrayUtils.filter(numbers);
        assertThat(evenNumbers)
            .containsExactly(2, 4)
            .hasSize(2);
    }
}
