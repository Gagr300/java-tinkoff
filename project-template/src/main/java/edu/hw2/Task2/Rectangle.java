package edu.hw2.Task2;

public sealed class Rectangle permits Square {
    private int width;
    private int height;

    void setWidth(int width) {
        this.width = width;
    }

    void setHeight(int height) {
        this.height = height;
    }

    double area() {
        return width * height;
    }
}
