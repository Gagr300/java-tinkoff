package edu.labyrinth;

public class Cell {
    private final int row;
    private final int col;
    private final Type type;
    private boolean north;
    private boolean east;
    private boolean south;
    private boolean west;

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }

    public Type type() {
        return type;
    }

    public boolean isEast() {
        return east;
    }

    public boolean isSouth() {
        return south;
    }

    public boolean isWest() {
        return west;
    }

    public boolean isNorth() {
        return north;
    }

    public enum Type {PASSAGE, START, END}

    public Cell(int row, int col, Type type, boolean north, boolean east, boolean south, boolean west) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    public void setNorth(boolean b) {
        north = b;
    }

    public void setEast(boolean b) {
        east = b;
    }

    public void setSouth(boolean b) {
        south = b;
    }

    public void setWest(boolean b) {
        west = b;
    }
}
