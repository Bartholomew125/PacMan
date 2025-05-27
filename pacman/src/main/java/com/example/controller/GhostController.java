package com.example.controller;

import java.util.ArrayList;

import com.example.controller.searching.BredthFirstSearch;
import com.example.model.Game;
import com.example.model.Ghost;

/**
 * GhostController class for controlling the ghosts ai
 */
public class GhostController{
    private ArrayList<Ghost> ghosts;  
    private Game game;

    public GhostController(ArrayList<Ghost> ghosts, Game game){ 
        this.ghosts = ghosts;
        this.game = game;
    } 

    public void update(long nanoTime){ 
        for (Ghost ghost : this.ghosts) {
            if (ghost.getMoveStack().isEmpty()){ 
                ghost.setMoveStack(new BredthFirstSearch(game, ghost).getMoveStack()); 
                if (!ghost.getMoveStack().isEmpty()) {
                    ghost.setDX(ghost.getMoveStack().peek().getX()-ghost.getX());
                    ghost.setDY(ghost.getMoveStack().peek().getY()-ghost.getY());
                }
            } 
            ghost.move();
        }
    } 

}
