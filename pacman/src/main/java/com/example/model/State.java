package com.example.model;

/**
 * State
 */
public abstract class State {
    protected boolean ghostIsAfraid;
    protected double ghostSpeed;
    protected boolean ghostIsEdible;
    protected boolean pacmanIsEdible;

    public State(boolean ghostIsAfraid, double ghostSpeed, boolean ghostIsEdible, boolean pacmanIsEdible) {
        this.ghostIsAfraid = ghostIsAfraid;
        this.ghostSpeed = ghostSpeed;
        this.ghostIsEdible = ghostIsEdible;
        this.pacmanIsEdible = pacmanIsEdible;
    }
}
