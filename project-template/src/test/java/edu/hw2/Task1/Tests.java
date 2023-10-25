package edu.hw2.Task1;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    //Task1

    @org.junit.jupiter.api.Test
    @DisplayName("func")
    void func() {

        var two = new Constant(2);
        assertEquals(two.evaluate(), 2);

        var four = new Constant(4);
        assertEquals(four.evaluate(), 4);

        var negOne = new Negate(new Constant(1));
        assertEquals(negOne.evaluate(), -1);

        var sumTwoFour = new Addition(two, four);
        assertEquals(sumTwoFour.evaluate(), 6);

        var mult = new Multiplication(sumTwoFour, negOne);
        assertEquals(mult.evaluate(), -6);

        var exp = new Exponent(mult, 2);
        assertEquals(exp.evaluate(), 36);

        var res = new Addition(exp, new Constant(1));
        assertEquals(res.evaluate(), 37);

        System.out.println(res + " = " + res.evaluate());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("func")
    void func2() {

        var two = new Constant(2);
        assertEquals(two.evaluate(), 2);

        var four = new Constant(4);
        assertEquals(four.evaluate(), 4);

        var negOne = new Negate(new Constant(1));
        assertEquals(negOne.evaluate(), -1);

        var sumTwoFour = new Addition(two, four);
        assertEquals(sumTwoFour.evaluate(), 6);

        var mult = new Multiplication(sumTwoFour, negOne);
        assertEquals(mult.evaluate(), -6);

        var exp = new Exponent(mult, new Constant(2));
        assertEquals(exp.evaluate(), 36);

        var res = new Addition(exp, new Constant(1));
        assertEquals(res.evaluate(), 37);

        System.out.println(res + " = " + res.evaluate());
    }
}
