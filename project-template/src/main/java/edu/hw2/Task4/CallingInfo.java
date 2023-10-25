package edu.hw2.Task4;

public record CallingInfo(String className, String methodName) {
    public String callingInfo() {
        return methodName;
    }
}
