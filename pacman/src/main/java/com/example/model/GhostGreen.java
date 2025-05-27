package com.example.model;

import javafx.scene.paint.Color;

/**
 * Green ghost which extends Ghost.
 */
public class GhostGreen extends Ghost {

    /**
     * Creates an instance of a Green Ghost.
     * 
     * @param x
     * @param y
     */
    public GhostGreen(float x, float y) {
        super(x, y, 0, 0, 0.06, Color.GREEN);
    }
}
