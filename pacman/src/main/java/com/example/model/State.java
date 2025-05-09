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
}
