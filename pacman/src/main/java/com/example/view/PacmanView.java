package com.example.view;

import com.example.model.PacMan;

public class PacmanView extends AbstractView{
    
    private PacMan pacman;
    private AnimatedImage pacmanAnimationImage;

    public PacmanView(int width, int height, double positionScaler, PacMan pacman) {
        super(width, height, positionScaler);

        this.pacman = pacman;
        // Load animated images
        this.pacmanAnimationImage = new AnimatedImage(300000000, (int) this.getPositionScaler());
        this.pacmanAnimationImage.loadFramesFromDirectory("pacmanFrames", "frame", 2);
    }

    @Override
    public void render(double nanoTime) {
        this.clear();
        // Add pacman to the surface
        this.addImageToSurface(pacmanAnimationImage.getFrame(nanoTime), this.pacman.getX(), this.pacman.getY(), this.pacmanAnimationImage.getRotation()); 
    }

    public AnimatedImage getAnimation() {
        return this.pacmanAnimationImage;
    }
}
