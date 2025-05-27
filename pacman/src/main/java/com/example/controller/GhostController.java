package com.example.controller;

import com.example.model.Ghost;

/**
 * GhostController class for controlling the ghosts ai
 */
public class GhostController{
    private Ghost ghost;  
    private SearchAlgorithm searchAlgorithm;

    public GhostController(Ghost ghost, SearchAlgorithm searchAlgorithm){ 
        this.ghost = ghost;
        this.searchAlgorithm = searchAlgorithm;
    } 

    public void update(long nanoTime){ 
        if (ghost.getMoveStack().isEmpty()){ 
            ghost.setMoveStack(this.searchAlgorithm.getMoveStack()); 
            if (!ghost.getMoveStack().isEmpty()) {
                ghost.setDX(ghost.getMoveStack().peek().getX()-ghost.getX());
                ghost.setDY(ghost.getMoveStack().peek().getY()-ghost.getY());
            }
        } 
        ghost.move();
    } 

}
