package com.example.controller;

import java.util.Stack;

import com.example.model.Game;
import com.example.model.Ghost;
import com.example.model.Pos2D;




public class GhostController{
    private Ghost ghost;  
    private Stack<Pos2D> moveStack;
    private Game game;
    

    public GhostController(Ghost ghost, Game game){ 
        this.ghost = ghost;
        this.moveStack = new Stack<>(); 
        this.game = game;
    } 

    public void update(long nanoTime){ 
        if (this.moveStack.isEmpty()){ 
            this.moveStack = new SearchAlgorithm(this.game).DFS(this.ghost); 
            this.ghost.setDX(this.moveStack.peek().getX()-this.ghost.getX());
            this.ghost.setDY(this.moveStack.peek().getY()-this.ghost.getY());
        } 
        else if (this.moveStack.peek().distanceTo(this.ghost) <= 0.1) {
            this.moveStack.pop();
            this.ghost.setDX(this.moveStack.peek().getX()-this.ghost.getX());
            this.ghost.setDY(this.moveStack.peek().getY()-this.ghost.getY());
        }
        this.ghost.move();
    } 

}