package com.example.controller;

import java.util.ArrayList;

import com.example.model.Game;
import com.example.model.Ghost;

public class GhostController{
    private ArrayList<Ghost> ghosts;  
    private Game game;
    

    public GhostController(ArrayList<Ghost> ghosts, Game game){ 
        this.ghosts = ghosts;
        this.game = game;
    } 

    public void update(long nanoTime){ 
        for (Ghost ghost : this.ghosts) {
            if (ghost.getMoveQueue().isEmpty()){ 
                ghost.setMoveQueue(new SearchAlgorithm(this.game).BFS(ghost)); 
                ghost.setDX(ghost.getMoveQueue().peek().getX()-ghost.getX());
                ghost.setDY(ghost.getMoveQueue().peek().getY()-ghost.getY());
            } 
            else if (ghost.getMoveQueue().peek().distanceTo(ghost) <= 0.1) {
                ghost.getMoveQueue().pop();
                ghost.setDX(ghost.getMoveQueue().peek().getX()-ghost.getX());
                ghost.setDY(ghost.getMoveQueue().peek().getY()-ghost.getY());
            }
            ghost.move();
        } 
    }


}
