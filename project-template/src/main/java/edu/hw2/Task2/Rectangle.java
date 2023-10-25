package edu.hw2.Task2;

public sealed class Rectangle permits Square {
    private final int width;
    private final int height;

    public Rectangle() {
        this.height = 0;
        this.width = 0;
    }

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public Rectangle setWidth(int width) {
        return new Rectangle(height, width);
    }

    public Rectangle setHeight(int height) {
        return new Rectangle(height, width);
    }

    double area() {
        return width * height;
    }
}
