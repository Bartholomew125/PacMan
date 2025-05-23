package com.example.view;


import java.util.ArrayList;

import com.example.model.Ghost;

import javafx.scene.image.Image;

public class GhostView extends AbstractView {
    
    private ArrayList<Ghost> ghosts;
    private Image ghostImage;
    private Image ghostAfraidImage;
    private AnimatedImage ghostAnimatedImage;

    public GhostView(int width, int height, double positionScaler, ArrayList<Ghost> ghosts) {
        super(width, height, positionScaler);
        this.ghosts = ghosts;

        // this.ghostImage = new Image("file:src/main/resources/com/example/GreenGhost.png", this.getPositionScaler(), this.getPositionScaler(), false, false);
        this.ghostAnimatedImage = new AnimatedImage(300000000, (int) this.getPositionScaler());
        this.ghostAnimatedImage.loadFramesFromDirectory("ghostFramesGreen", "ghost_", 2);

        this.ghostAfraidImage = new Image("file:src/main/resources/com/example/ghostAfraid.png", this.getPositionScaler(), this.getPositionScaler(), false, false);
    }

    @Override
    public void render(double nanoTime) {
        this.clear();

        for (Ghost g : this.ghosts) {
            if (g.getIsAfraid()) {
                this.addImageToSurface(ghostAfraidImage, g.getX(), g.getY(), 0);
            }
            else {
                this.addImageToSurface(this.ghostAnimatedImage.getFrame(nanoTime), g.getX(), g.getY(), 0);
            }
        }
    }
}
