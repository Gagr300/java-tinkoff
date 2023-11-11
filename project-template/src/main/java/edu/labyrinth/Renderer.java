package edu.labyrinth;

import java.util.List;

public interface Renderer {
    public String render(Maze maze);

    public String render(Maze maze, List<Coordinate> path);
}
