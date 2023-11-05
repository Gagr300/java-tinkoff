package edu.labyrinth;

import java.util.List;

public class Renderer2DLabyrinth implements Renderer {
    @Override
    public String render(Maze maze) {
        StringBuilder ans = new StringBuilder();
        for (var line : maze.grid()) {
            for (var cell : line) {
                if (!cell.isNorth()) {
                    ans.append("----");
                } else {
                    ans.append("    ");
                }
            }
            ans.append("\n");
            for (var cell : line) {
                if (!cell.isWest()) {
                    ans.append("|   ");
                } else {
                    ans.append("    ");
                }
                /*
                if (!cell.isEast()) {
                    ans.append("|");
                } else {
                    ans.append(" ");
                }
                */
            }
            ans.append("|\n");
            /*
            for (var cell : line) {
                if (!cell.isSouth()) {
                    ans.append("-----");
                } else {
                    ans.append("     ");
                }
            }
            ans.append("\n");
             */
        }
        for (Cell cell : maze.grid()[maze.height() - 1]) {
            if (!cell.isSouth()) {
                ans.append("----");
            } else {
                ans.append("    ");
            }
        }

        ans.append('\n');
        return ans.toString();
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        /*
        if (path == null || path.isEmpty()) {
            throw new RuntimeException("There is no way from start cell to end cell!");
        }

         */
        StringBuilder ans = new StringBuilder();
        for (var line : maze.grid()) {
            for (var cell : line) {
                if (!cell.isNorth()) {
                    ans.append("----");
                } else {
                    ans.append("    ");
                }
            }
            ans.append("\n");
            for (var cell : line) {
                if (!cell.isWest()) {
                    ans.append("| ");
                } else {
                    ans.append("  ");
                }
                if (path.contains(new Coordinate(cell.row(), cell.col()))) {
                    ans.append("+ ");
                } else {
                    ans.append("  ");
                }
                /*
                if (!cell.isEast()) {
                    ans.append("|");
                } else {
                    ans.append(" ");
                }
                */
            }
            ans.append("|\n");
            /*
            for (var cell : line) {
                if (!cell.isSouth()) {
                    ans.append("-----");
                } else {
                    ans.append("     ");
                }
            }
            ans.append("\n");
             */
        }
        for (Cell cell : maze.grid()[maze.height() - 1]) {
            if (!cell.isSouth()) {
                ans.append("----");
            } else {
                ans.append("    ");
            }
        }
        ans.append("\n\n");
        return ans.toString();
    }
}
