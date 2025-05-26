package com.example.controller;

import java.util.ArrayList;
import java.util.Stack;

import com.example.model.Game;
import com.example.model.Ghost;
import com.example.model.Pos2D;

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
                ghost.setMoveStack(new SearchAlgorithm(this.game).DFS(ghost)); 
                ghost.setDX(ghost.getMoveStack().peek().getX()-ghost.getX());
                ghost.setDY(ghost.getMoveStack().peek().getY()-ghost.getY());
            } 
            else if (ghost.getMoveStack().peek().distanceTo(ghost) <= 0.1) {
                ghost.getMoveStack().pop();
                ghost.setDX(ghost.getMoveStack().peek().getX()-ghost.getX());
                ghost.setDY(ghost.getMoveStack().peek().getY()-ghost.getY());
            }
            ghost.move();
        } 
    }


}
