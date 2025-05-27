package com.example.controller;

import java.util.ArrayList;

import com.example.controller.searching.BreadthFirstSearch;
import com.example.model.Game;
import com.example.model.Ghost;

/**
 * GhostController class for controlling the ghosts ai
 */
public class GhostController implements Controller {
    private ArrayList<Ghost> ghosts;
    private Game game;

    /**
     * Creates a GhostController.
     * 
     * @param ghosts
     * @param game
     */
    public GhostController(ArrayList<Ghost> ghosts, Game game) {
        this.ghosts = ghosts;
        this.game = game;
    }

    @Override
    public void update(long nanoTime) {
        for (Ghost ghost : this.ghosts) {
            if (ghost.getMoveStack().isEmpty()) {
                ghost.setMoveStack(new BreadthFirstSearch(game, ghost).getMoveStack());
                if (!ghost.getMoveStack().isEmpty()) {
                    ghost.setDX(ghost.getMoveStack().peek().getX() - ghost.getX());
                    ghost.setDY(ghost.getMoveStack().peek().getY() - ghost.getY());
                }
            }
            ghost.move();
        }
    }

}
