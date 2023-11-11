package edu.labyrinth;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import static edu.labyrinth.Cell.Type.END;
import static edu.labyrinth.Cell.Type.START;
import static edu.labyrinth.Cell.Type.PASSAGE;
import static java.util.Collections.shuffle;

public class DFSWithWayGenerator implements Generator {
    private int height;
    private int width;
    private Cell[][] grid;
    private boolean[][] visited;
    private final Random rn = new Random();

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
        grid[0][0] = new Cell(0, 0, START, false, false, false, false);
        grid[height - 1][width - 1] = new Cell(height - 1, width - 1, END, false, false, false, false);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Cell(i, j, PASSAGE, false, false, false, false);
            }
        }
        visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!visited[i][j]) {
                    dfs(grid[i][j]);
                }
            }
        }
        DFSSolver dfsSolver = new DFSSolver();
        while (dfsSolver.solve(new Maze(height, width, grid),
            new Coordinate(0, 0), new Coordinate(height - 1, width - 1)
        ) == null) {
            deleteWallBetweenClusters();
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

    Set<Coordinate> clusterFromStart;

    private void deleteWallBetweenClusters() {
        visited = new boolean[height][width];
        clusterFromStart = new HashSet<>();
        getCluster(grid[0][0]);
        deleteWallWithNeighbor(clusterFromStart);
    }

    private final List<Coordinate> inds = List.of(
        new Coordinate(-1, 0), new Coordinate(0, 1),
        new Coordinate(0, -1), new Coordinate(1, 0)
    );

    private void getCluster(Cell cell) {
        visited[cell.row()][cell.col()] = true;
        clusterFromStart.add(new Coordinate(cell.row(), cell.col()));
        for (var ind : inds) {
            int x = cell.row() + ind.row();
            int y = cell.col() + ind.col();
            if (x >= 0 && x < height && y >= 0 && y < width) {
                if (x > cell.row() && cell.isSouth() ||
                    x < cell.row() && cell.isNorth() ||
                    y > cell.col() && cell.isEast() ||
                    y < cell.col() && cell.isWest()) {
                    if (!visited[x][y]) {
                        getCluster(grid[x][y]);
                    }
                }
            }
        }
    }

    private void deleteWallWithNeighbor(Set<Coordinate> coordinates) {
        List<Coordinate> listCoordinates = new ArrayList<>(coordinates.stream().toList());
        shuffle(listCoordinates);
        for (Coordinate coordinate : listCoordinates) {
            for (var ind : inds) {
                Cell cell = grid[coordinate.row()][coordinate.col()];
                int x = cell.row() + ind.row();
                int y = cell.col() + ind.col();
                if (x >= 0 && x < height && y >= 0 && y < width) {
                    if (!coordinates.contains(new Coordinate(x, y))) {
                        if (x > cell.row()) {
                            cell.setSouth(true);
                            grid[x][y].setNorth(true);
                        } else if (x < cell.row() && cell.isNorth()) {
                            cell.setNorth(true);
                            grid[x][y].setSouth(true);
                        } else if (y > cell.col() && cell.isEast()) {
                            cell.setEast(true);
                            grid[x][y].setWest(true);
                        } else if (y < cell.col() && cell.isWest()) {
                            cell.setWest(true);
                            grid[x][y].setEast(true);
                        }
                        return;
                    }

                }
            }
        }
    }
}
