package com.example.controller;

import java.util.ArrayList;

import com.example.model.Ghost;

public class GhostController implements Controller{
    
    private ArrayList<Ghost> ghosts;

    public GhostController(ArrayList<Ghost> ghosts) {
        this.ghosts = ghosts;
    }

    @Override
    public void update(long nanoTime) {
        
        for (Ghost g : this.ghosts) {
            g.move();
        }
    }
}
