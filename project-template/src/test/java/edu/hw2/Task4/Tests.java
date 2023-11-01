package edu.hw2.Task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Tests {
    @Test
    @DisplayName("callingInfo")
    void testCallingInfo() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        CallingInfo callingInfo = new CallingInfo(className, methodName);
        assertThat(callingInfo.className()).isEqualTo("edu.hw2.Task4.Tests");
        assertThat(callingInfo.methodName()).isEqualTo("testCallingInfo");
        assertThat(callingInfo.callingInfo()).isEqualTo("testCallingInfo");
    }
}
