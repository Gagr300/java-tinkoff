package edu.hw2.Task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Tests {
    @Test
    @DisplayName("callingInfo")
    void testCallingInfo() {
        CallingInfo callingInfo = new CallingInfo(new Throwable());
        System.out.println(callingInfo.methodName());
        assertThat(callingInfo.className()).isEqualTo("edu.hw2.Task4.Tests");
        assertThat(callingInfo.methodName()).isEqualTo("testCallingInfo");
    }
}
