package edu.labyrinth;

import java.util.ArrayList;
import java.util.List;

public class ShortestWaySolver implements Solver {
    int[][] weight;
    int height;
    int width;
    Cell[][] grid;

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        maze.check();
        weight = new int[maze.height()][maze.width()];
        weight[start.row()][start.col()] = 1;
        height = maze.height();
        width = maze.width();
        grid = maze.grid();
        while (weight[end.row()][end.col()] == 0) {
            makeStep();
        }
        return recostructWay(start, end);
    }

    private List<Coordinate> inds = List.of(
        new Coordinate(-1, 0), new Coordinate(0, 1),
        new Coordinate(0, -1), new Coordinate(1, 0)
    );

    private List<Coordinate> recostructWay(Coordinate start, Coordinate end) {
        List<Coordinate> way = new ArrayList<>(List.of(end));
        Coordinate cur = new Coordinate(end.row(), end.col());
        while (cur.row() != start.row() && cur.col() != start.col()) {
            for (Coordinate ind : inds) {
                int x = cur.row() + ind.row();
                int y = cur.col() + ind.col();
                if (x >= 0 && x < height && y >= 0 && y < width
                    && weight[x][y] == weight[cur.row()][cur.col()] - 1) {
                    cur = new Coordinate(x, y);
                    way.add(cur);
                }
            }
        }
        List<Coordinate> ans = new ArrayList<>();
        for (int i = way.size() - 1; i >= 0; i--) {
            ans.add(way.get(i));
        }
        return ans;
    }

    private void makeStep() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (weight[i][j] > 0) {
                    if (grid[i][j].isWest() && j > 0 && weight[i][j - 1] == 0) {
                        weight[i][j - 1] = weight[i][j] + 1;
                    }
                    if (grid[i][j].isEast() && j < width - 1 && weight[i][j + 1] == 0) {
                        weight[i][j + 1] = weight[i][j] + 1;
                    }
                    if (grid[i][j].isNorth() && i > 0 && weight[i - 1][j] == 0) {
                        weight[i - 1][j] = weight[i][j] + 1;
                    }
                    if (grid[i][j].isSouth() && i < height - 1 && weight[i + 1][j] == 0) {
                        weight[i + 1][j] = weight[i][j] + 1;
                    }
                }
            }
        }
    }
}
