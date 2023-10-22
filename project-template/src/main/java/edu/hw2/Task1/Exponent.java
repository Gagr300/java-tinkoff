package edu.hw2.Task1;

public record Exponent(Expr expr, int x) implements Expr{
    @Override
    public double evaluate() {
        return Math.pow(expr.evaluate(), x);
    }

    @Override
    public String toString() {
        return expr.toString() + " ^ " + x;
    }
}
