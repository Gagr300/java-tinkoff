package edu.labyrinth;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Stack;
import static edu.labyrinth.Cell.Type.END;
import static edu.labyrinth.Cell.Type.PASSAGE;
import static edu.labyrinth.Cell.Type.START;

public class RecursiveBacktrackingGenerator implements Generator {
    int height;
    int width;
    int cntVisited;
    Cell[][] grid;
    boolean[][] visited;
    Random rn = new Random();
    Stack<Coordinate> way;

    @Override public Maze generate(int height, int width) {
        if (height < 2 || width < 2) {
            throw new InvalidParameterException("There should be at least two columns and rows in the labyrinth!");
        }
        this.height = height;
        this.width = width;
        return new Maze(height, width, createGrid(height, width));
    }

    private Cell[][] createGrid(int height, int width) {
        way = new Stack<>();
        grid = new Cell[height][width];
        visited = new boolean[height][width];
        grid[0][0] = new Cell(0, 0, START, false, false, false, false);
        grid[height - 1][width - 1] = new Cell(height - 1, width - 1, END, false, false, false, false);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Cell(i, j, PASSAGE, false, false, false, false);
            }
        }
        cntVisited = 0;
        int x = rn.nextInt(height);
        int y = rn.nextInt(width);
        RecursiveBacktracking(grid[x][y]);
        DFSSolver dfsSolver = new DFSSolver();

        return grid;
    }

    List<Coordinate> inds = List.of(
        new Coordinate(-1, 0), new Coordinate(0, 1),
        new Coordinate(0, -1), new Coordinate(1, 0)
    );

    private void RecursiveBacktracking(Cell cell) {
        if (cell == null || cntVisited == height * width) {
            return;
        }
        way.push(new Coordinate(cell.row(), cell.col()));
        visited[cell.row()][cell.col()] = true;
        cntVisited++;
        deleteWall(cell);
        for (var ind : inds) {
            int x = cell.row() + ind.row();
            int y = cell.col() + ind.col();
            if (x >= 0 && x < height && y >= 0 && y < width) {
                if (!visited[x][y]) {
                    RecursiveBacktracking(grid[x][y]);
                }
            }
        }
        while (!way.isEmpty() && allVisited(way.peek())) {
            way.pop();
        }
        if (way.isEmpty()) {
            return;
        } else {
            Coordinate next = way.pop();
            RecursiveBacktracking(grid[next.row()][next.col()]);
        }

    }

    private boolean allVisited(Coordinate cell) {
        boolean ans = true;
        for (var ind : inds) {
            int x = cell.row() + ind.row();
            int y = cell.col() + ind.col();
            if (x >= 0 && x < height && y >= 0 && y < width) {
                if (!visited[x][y]) {
                    ans = false;
                }
            }
        }
        return ans;
    }

    private void deleteWall(Cell cell) {
        List<Integer> directions = new ArrayList<>();
        if (!cell.isEast() && cell.col() < width - 1 && !visited[cell.row()][cell.col() + 1]) {
            directions.add(0); // east
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
                    RecursiveBacktracking(grid[cell.row()][cell.col() + 1]);
                } else if (directions.get(i) == 1) {
                    grid[cell.row()][cell.col()].setWest(true);
                    grid[cell.row()][cell.col() - 1].setEast(true);
                    RecursiveBacktracking(grid[cell.row()][cell.col() - 1]);
                } else if (directions.get(i) == 2) {
                    grid[cell.row()][cell.col()].setNorth(true);
                    grid[cell.row() - 1][cell.col()].setSouth(true);
                    RecursiveBacktracking(grid[cell.row() - 1][cell.col()]);
                } else {
                    grid[cell.row()][cell.col()].setSouth(true);
                    grid[cell.row() + 1][cell.col()].setNorth(true);
                    RecursiveBacktracking(grid[cell.row() + 1][cell.col()]);
                }
                break;
            }
        }
    }

}


