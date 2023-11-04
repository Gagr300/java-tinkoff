package edu.labyrinth;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class labyrinthTests {

    @Test
    @DisplayName("testRenderDFS")
    void testRenderDFS() {
        DFSGenerator dfsGenerator = new DFSGenerator();
        Maze maze = dfsGenerator.generate(3, 3);
        Renderer2DLabyrinth renderer2DLabyrinth = new Renderer2DLabyrinth();
        System.out.println(renderer2DLabyrinth.render(maze));
    }

    @Test
    @DisplayName("testRenderDFSSolve")
    void testRenderDFSSolve() {
        DFSGenerator dfsGenerator = new DFSGenerator();
        Maze maze = dfsGenerator.generate(3, 3);
        Renderer2DLabyrinth renderer2DLabyrinth = new Renderer2DLabyrinth();
        System.out.println(renderer2DLabyrinth.render(maze));
        DFSSolver dfsSolver = new DFSSolver();
        System.out.println(renderer2DLabyrinth.render(
            maze,
            dfsSolver.solve(maze, new Coordinate(0, 0), new Coordinate(2, 2))
        ));
    }

    @Test
    @DisplayName("testRenderDFSWithWaySolve")
    void testRenderDFSWithWaySolve() {
        DFSWithWayGenerator dfsGenerator = new DFSWithWayGenerator();
        Maze maze = dfsGenerator.generate(5, 5);
        Renderer2DLabyrinth renderer2DLabyrinth = new Renderer2DLabyrinth();
        System.out.println(renderer2DLabyrinth.render(maze));
        ShortestWaySolver dfsSolver = new ShortestWaySolver();
        System.out.println(renderer2DLabyrinth.render(
            maze,
            dfsSolver.solve(maze, new Coordinate(0, 0), new Coordinate(4, 4))
        ));
    }

    @Test
    @DisplayName("testRenderRecursiveBacktrackingSolve")
    void testRenderRecursiveBacktrackingSolve() {
        RecursiveBacktrackingGenerator recursiveBacktrackingGenerator = new RecursiveBacktrackingGenerator();
        Maze maze = recursiveBacktrackingGenerator.generate(5, 5);
        Renderer2DLabyrinth renderer2DLabyrinth = new Renderer2DLabyrinth();
        System.out.println(renderer2DLabyrinth.render(maze));
        DFSSolver dfsSolver = new DFSSolver();
        System.out.println(renderer2DLabyrinth.render(
            maze,
            dfsSolver.solve(maze, new Coordinate(0, 0), new Coordinate(4, 4))
        ));
    }

}
