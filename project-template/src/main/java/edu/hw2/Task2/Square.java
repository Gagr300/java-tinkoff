package edu.hw2.Task2;

public final class Square extends Rectangle {
    @Override
    void setWidth(int width) {
        super.setHeight(width);
        super.setWidth(width);
    }

    @Override
    void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}
