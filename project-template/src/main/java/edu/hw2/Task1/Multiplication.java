package edu.hw2.Task1;

public record Multiplication(Expr expr1, Expr expr2) implements Expr {

    @Override
    public double evaluate() {
        return expr1().evaluate() * expr2.evaluate();
    }

    @Override
    public String toString() {
        return "(" + expr1.toString() + " * " + expr2.toString() + ")";
    }
}
