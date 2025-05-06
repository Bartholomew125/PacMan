package com.example;

/**
 * PowerState
 */
public class PowerState implements State {

    public void setGhostPath(AGhost ghost) {
    };

    public void setGhostSprite(AGhost ghost) {
    };

    public void setGhostEtableState(AGhost ghost) {
        ghost.isEdible = true;
    };

    public void setPacmanEtableState(PacMan pacman) {
        pacman.isEdible = false;
    };
    
    public void setStateDuration(){
        // Must be 20-30 sec.
    };

}
