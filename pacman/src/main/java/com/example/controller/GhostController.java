package com.example.controller;

import java.util.ArrayList;

import com.example.controller.searching.SearchAlgorithm;
import com.example.model.Ghost;
import com.example.model.PacMan;
import com.example.model.Pos2D;

/**
 * GhostController class for controlling the ghosts ai
 */
public class GhostController implements Controller {
    private ArrayList<Ghost> ghosts;
    private PacMan pacMan;

    /**
     * Creates a GhostController.
     * 
     * @param ghosts
     * @param game
     */
    public GhostController(ArrayList<Ghost> ghosts, PacMan pacMan) {
        this.ghosts = ghosts;
        this.pacMan = pacMan;

    }

    @Override
    public void update(long nanoTime) {
        for (Ghost ghost : this.ghosts) {
            if (ghost.getMoveStack().isEmpty()) {

                SearchAlgorithm sa = ghost.getSearchAlgorithm();
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

}
