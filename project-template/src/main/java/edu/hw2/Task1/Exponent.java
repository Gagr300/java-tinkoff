package edu.hw2.Task1;

import java.beans.Expression;

public record Exponent(Expr expr1, Expr expr2) implements Expr {
    public Exponent(Expr expr1, int x) {
        this(expr1, new Constant(x));
    }

    @Override
    public double evaluate() {
        return Math.pow(expr1.evaluate(), expr2.evaluate());
    }

    @Override
    public String toString() {
        return expr2.toString() + " ^ " + expr1.evaluate();
    }
}
