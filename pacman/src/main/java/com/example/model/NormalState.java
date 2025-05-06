package com.example.model;

/**
 * NormalState
 */
public class NormalState extends State {
    
    /**
     * Creates a Normalstate ensuring ghosts can't be eaten whilst PacMan can. 
     * */
    public NormalState() {
        super(false, 2.0, false, true);
    }
}
