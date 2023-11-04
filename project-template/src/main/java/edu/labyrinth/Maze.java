package edu.labyrinth;

public final record Maze(int height, int width, Cell[][] grid) {

    public boolean check() {
        for (int i = 0; i < height - 1; i++) {
            for (int j = 0; j < width - 1; j++) {
                if (grid[i][j].isEast() != grid[i][j + 1].isWest() ||
                    grid[i][j].isSouth() != grid[i + 1][j].isNorth()) {
                    return false;
                }
            }
        }
        return true;
    }
}
