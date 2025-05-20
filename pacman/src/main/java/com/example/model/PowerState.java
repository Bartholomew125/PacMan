package com.example.model;

/**
 * PowerState
 */
public class PowerState extends State {
    
    /**
     * Creates powerstate where Ghosts are edible and and afraid, whilst PacMan can't be eaten.
     * */
    public PowerState() {
        super(true, 1.0, true, false);
    }
}
