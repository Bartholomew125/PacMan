package com.example.model;

import javafx.scene.paint.Color;

/**
 * Mint Ghost which extends Ghost.
 */
public class GhostMint extends Ghost {

    /**
     * Creates a new instance 
     * @param x
     * @param y
     */
    public GhostMint(float x, float y) {
        super(x, y, 0, -1, 0.06, Color.MINTCREAM);
    }

}
