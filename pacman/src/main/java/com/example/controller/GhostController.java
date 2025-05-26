package com.example.controller;

import java.util.List;

import com.example.model.Ghost;

public class GhostController implements Controller{
    
    private List<Ghost> ghosts;

    public GhostController(List<Ghost> ghosts) {
        this.ghosts = ghosts;
    }

    @Override
    public void update(long nanoTime) {
        
        for (Ghost g : this.ghosts) {
            g.move();
        }
    }
}
