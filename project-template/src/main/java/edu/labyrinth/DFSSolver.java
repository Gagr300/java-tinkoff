package edu.labyrinth;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class DFSSolver implements Solver {
    int height;
    int width;
    Cell[][] grid;
    boolean[][] visited;
    Stack<Coordinate> way;
    Coordinate end;

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        if (!maze.check()) {
            return null;
        }
        grid = maze.grid();
        height = maze.height();
        width = maze.width();
        visited = new boolean[height][width];
        way = new Stack<>();
        this.end = end;
        if (dfs(grid[start.row()][start.col()])) {
            return way;
        } else {
            return null;
            //throw new RuntimeException("There is no way from start cell to end cell!");
        }
    }

    List<Coordinate> inds = List.of(
        new Coordinate(-1, 0), new Coordinate(0, 1),
        new Coordinate(0, -1), new Coordinate(1, 0)
    );

    boolean dfs(Cell cell) {
        visited[cell.row()][cell.col()] = true;
        way.push(new Coordinate(cell.row(), cell.col()));
        if (cell.row() == end.row() && cell.col() == end.col()) {
            return true;
        }
        boolean flag = false;
        for (var ind : inds) {
            int x = cell.row() + ind.row();
            int y = cell.col() + ind.col();
            if (x >= 0 && x < height && y >= 0 && y < width) {
                if (x > cell.row() && cell.isSouth() ||
                    x < cell.row() && cell.isNorth() ||
                    y > cell.col() && cell.isEast() ||
                    y < cell.col() && cell.isWest()) {
                    if (!visited[x][y]) {
                        if (!dfs(grid[x][y])) {
                            while (!Objects.equals(way.peek(), new Coordinate(cell.row(), cell.col()))) {
                                way.pop();
                            }
                        } else {
                            return true;
                        }
                    }
                }
            }
        }
        return flag;
    }

}
