package com.example.view;

import javafx.scene.Group;

/**
 * Interface for View.
 */
public interface View {
    /**
     * Clears View.
     */
    public void clear();

    /**
     * Adds view to surface.
     * 
     * @param view
     */
    public void addView(View view);

    /**
     * Renders View.
     * 
     * @param nanoTime
     */
    public void render(double nanoTime);

    /**
     * Gets surface of specific Group.
     * 
     * @return a Group which represents a surface.
     */
    public Group getSurface();
}
