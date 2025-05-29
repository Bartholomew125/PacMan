package com.example.view;

import com.example.model.PacMan;

/**
 * PacManView which extends AbstractView.
 */
public class PacManView extends AbstractView {

    private PacMan pacMan;
    private AnimatedImage pacManAnimationImage;

    /**
     * Creates a new PacManView.
     * 
     * @param width
     * @param height
     * @param positionScaler
     * @param pacMan
     */
    public PacManView(int width, int height, double positionScaler, PacMan pacMan) {
        super(width, height, positionScaler);

        this.pacMan = pacMan;
        this.pacManAnimationImage = new AnimatedImage(100000000, (int) this.getPositionScaler());
        this.pacManAnimationImage.loadFramesFromDirectory("pacManFrames", "frame", 4);
    }

    @Override
    public void render(double nanoTime) {
        this.clear();
        this.addImageToSurface(pacManAnimationImage.getFrame(nanoTime), this.pacMan.getX(), this.pacMan.getY(),
                this.pacMan.getRotation(), false);
    }
}
