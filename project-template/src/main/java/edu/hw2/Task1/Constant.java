package edu.hw2.Task1;

public record Constant(double constant) implements Expr {
    @Override
    public double evaluate() {
        return constant;
    }

    @Override
    public String toString() {
        return String.valueOf(constant);
    }
}
