package edu.hw2.Task4;

public record CallingInfo(String className, String methodName) {
    public CallingInfo (Throwable throwable) {
        this(
            throwable.getStackTrace()[0].getClassName(),
            throwable.getStackTrace()[0].getMethodName()
        );
    }
}
