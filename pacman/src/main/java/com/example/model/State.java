package com.example.model;

/**
 * State
 */
public abstract class State {
    protected boolean ghostIsAfraid;
    protected double ghostMovementMultiplier;
    protected boolean ghostIsEdible;
    protected boolean pacmanIsEdible;

    public State(boolean ghostIsAfraid, double ghostMovementMultiplier, boolean ghostIsEdible, boolean pacmanIsEdible) {
        this.ghostIsAfraid = ghostIsAfraid;
        this.ghostMovementMultiplier = ghostMovementMultiplier;
        this.ghostIsEdible = ghostIsEdible;
        this.pacmanIsEdible = pacmanIsEdible;
    }

    public boolean getGhostIsAfraid() {
        return this.ghostIsAfraid;
    }

    public double getGhostMovementMultiplier(){
        return this.ghostMovementMultiplier;
    }
    
    public boolean getGhostIsEdible(){
        return this.ghostIsEdible;
    }

    public boolean getPacmanIsEdible(){
        return this.pacmanIsEdible;
    }

}
