package com.example.model;

/**
 * State
 */
public abstract class State {
    private boolean ghostIsAfraid;
    private double ghostMovementMultiplier;
    private boolean ghostIsEdible;
    private boolean pacManIsEdible;
    private double pacManMovementmultiplier;

    public State(boolean ghostIsAfraid, double ghostMovementMultiplier, boolean ghostIsEdible, boolean pacManIsEdible, double pacManMovementmultiplier) {
        this.ghostIsAfraid = ghostIsAfraid;
        this.ghostMovementMultiplier = ghostMovementMultiplier;
        this.ghostIsEdible = ghostIsEdible;
        this.pacManIsEdible = pacManIsEdible;
        this.pacManMovementmultiplier = pacManMovementmultiplier;
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

    public boolean getPacManIsEdible(){
        return this.pacManIsEdible;
    }

    public double getPacManMovementmultiplier(){
        return this.pacManMovementmultiplier;
    }

}
