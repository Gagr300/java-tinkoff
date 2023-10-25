package edu.hw2.Task2;

public final class Square extends Rectangle {
    public Square() {
        super(0, 0);
    }

    public Square(int length) {
        super(length, length);
    }

    @Override
    public Rectangle setWidth(int width) {
        return new Square(width);
    }

    @Override
    public Rectangle setHeight(int height) {
        return new Square(height);
    }
}
