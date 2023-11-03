package edu.hw4;

public record ValidationError(String message, ErrorType type) {

    enum ErrorType {
        NAME, TYPE, AGE, HEIGHT, WEIGHT
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ValidationError)) {
            return false;
        }
        return hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return type.toString() + ": " + message;
    }

}
