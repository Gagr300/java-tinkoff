package edu.labyrinth;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import static edu.labyrinth.Cell.Type.END;
import static edu.labyrinth.Cell.Type.START;
import static edu.labyrinth.Cell.Type.PASSAGE;
import static java.time.zone.ZoneOffsetTransitionRule.TimeDefinition.WALL;

public class DFSGenerator implements Generator {
    int height;
    int width;
    Cell[][] grid;
    boolean[][] visited;
    Random rn = new Random();

    @Override public Maze generate(int height, int width) {
        if (height < 2 || width < 2) {
            throw new InvalidParameterException("There should be at least two columns and rows in the labyrinth!");
        }
        this.height = height;
        this.width = width;
        return new Maze(height, width, createGrid(height, width));
    }

    private Cell[][] createGrid(int height, int width) {
        grid = new Cell[height][width];
        visited = new boolean[height][width];
        grid[0][0] = new Cell(0, 0, START, false, false, false, false);
        grid[height - 1][width - 1] = new Cell(height - 1, width - 1, END, false, false, false, false);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Cell(i, j, PASSAGE, false, false, false, false);
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!visited[i][j]) {
                    dfs(grid[i][j]);
                }
            }
        }
        return grid;
    }

    private void dfs(Cell cell) {

        if (cell == null) {
            return;
        }

        visited[cell.row()][cell.col()] = true;

        deleteWall(cell);
        if (cell.row() < height - 1 && !visited[cell.row() + 1][cell.col()]) {
            dfs(grid[cell.row() + 1][cell.col()]);
        }
        if (cell.col() > 0 && !visited[cell.row()][cell.col() - 1]) {
            dfs(grid[cell.row()][cell.col() - 1]);
        }
        if (cell.row() > 0 && !visited[cell.row() - 1][cell.col()]) {
            dfs(grid[cell.row() - 1][cell.col()]);
        }
        if (cell.col() < width - 1 && !visited[cell.row()][cell.col() + 1]) {
            dfs(grid[cell.row()][cell.col() + 1]);
        }

    }

    void deleteWall(Cell cell) {
        List<Integer> directions = new ArrayList<>();
        if (!cell.isEast()) {
            if (cell.col() < width - 1) {
                if (!visited[cell.row()][cell.col() + 1]) {
                    directions.add(0); // east
                }
            }
        }
        if (!cell.isWest() && cell.col() > 0 && !visited[cell.row()][cell.col() - 1]) {
            directions.add(1); // west
        }
        if (!cell.isNorth() && cell.row() > 0 && !visited[cell.row() - 1][cell.col()]) {
            directions.add(2); // north
        }
        if (!cell.isSouth() && cell.row() < height - 1 && !visited[cell.row() + 1][cell.col()]) {
            directions.add(3); // south
        }
        if (directions.isEmpty()) {
            return;
        }

        int rnd = rn.nextInt(100);
        for (int i = 0; i < directions.size(); i++) {
            if (rnd <= (100 / directions.size() * (i + 1))) {
                if (directions.get(i) == 0) {
                    grid[cell.row()][cell.col()].setEast(true);
                    grid[cell.row()][cell.col() + 1].setWest(true);
                    dfs(grid[cell.row()][cell.col() + 1]);
                } else if (directions.get(i) == 1) {
                    grid[cell.row()][cell.col()].setWest(true);
                    grid[cell.row()][cell.col() - 1].setEast(true);
                    dfs(grid[cell.row()][cell.col() - 1]);
                } else if (directions.get(i) == 2) {
                    grid[cell.row()][cell.col()].setNorth(true);
                    grid[cell.row() - 1][cell.col()].setSouth(true);
                    dfs(grid[cell.row() - 1][cell.col()]);
                } else {
                    grid[cell.row()][cell.col()].setSouth(true);
                    grid[cell.row() + 1][cell.col()].setNorth(true);
                    dfs(grid[cell.row() + 1][cell.col()]);
                }
                break;
            }
        }
    }

}

