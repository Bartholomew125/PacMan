package com.example.controller;

import java.util.List;
import java.util.Stack;

import com.example.controller.searching.FleeAlgorithm;
import com.example.controller.searching.SearchAlgorithm;
import com.example.model.Ghost;
import com.example.model.Maze;
import com.example.model.PacMan;
import com.example.model.Pos2D;

/**
 * GhostController class for controlling the ghosts ai
 */
public class GhostController implements Controller {
    private List<Ghost> ghosts;
    private PacMan pacMan;
    private Maze maze;

    /**
     * Creates a GhostController.
     * 
     * @param ghosts
     * @param game
     */
    public GhostController(List<Ghost> ghosts, PacMan pacMan, Maze maze) {
        this.ghosts = ghosts;
        this.pacMan = pacMan;
        this.maze = maze;

    }

    @Override
    public void update(long nanoTime) {
        for (Ghost ghost : this.ghosts) {
            if (ghost.getMoveStack().isEmpty()) {

                SearchAlgorithm sa;
                if (ghost.getIsAfraid()) {
                    sa = new FleeAlgorithm();
                }
                else {
                    sa = ghost.getSearchAlgorithm();
                }
                sa.setMaze(this.maze);
                sa.setStart(new Pos2D((int) ghost.getX(), (int) ghost.getY()));
                sa.setGoal(new Pos2D((int) this.pacMan.getX(), (int) this.pacMan.getY()));
                ghost.setMoveStack(sa.getMoveStack());

                if (!ghost.getMoveStack().isEmpty()) {
                    ghost.setDX(ghost.getMoveStack().peek().getX() - ghost.getX());
                    ghost.setDY(ghost.getMoveStack().peek().getY() - ghost.getY());
                }
            }
            ghost.move();
        }
    }

    public void clearMoveStacks() {
        for (Ghost ghost : this.ghosts) {
            ghost.setMoveStack(new Stack<>());
        }
    }

}
