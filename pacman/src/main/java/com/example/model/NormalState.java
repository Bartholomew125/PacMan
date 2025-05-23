package com.example.model;

/**
 * NormalState
 */
public class NormalState extends State {
    
    /**
     * Creates a Normalstate ensuring ghosts can't be eaten whilst PacMan can. 
     * */
    public NormalState() {
        super(false, 0.06, false, true, 0.06);
    }
}
