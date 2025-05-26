package com.example.view;

import com.example.model.PacMan;

public class PacManView extends AbstractView{
    
    private PacMan pacMan;
    private AnimatedImage pacManAnimationImage;

    public PacManView(int width, int height, double positionScaler, PacMan pacMan) {
        super(width, height, positionScaler);

        this.pacMan = pacMan;
        // Load animated images
        this.pacManAnimationImage = new AnimatedImage(100000000, (int) this.getPositionScaler());
        this.pacManAnimationImage.loadFramesFromDirectory("pacManFrames", "frame", 4);
    }

    @Override
    public void render(double nanoTime) {
        this.clear();
        // Add pacMan to the surface
        this.addImageToSurface(pacManAnimationImage.getFrame(nanoTime), this.pacMan.getX(), this.pacMan.getY(), this.pacMan.getRotation(), false); 
    }

    public AnimatedImage getAnimation() {
        return this.pacManAnimationImage;
    }
}
