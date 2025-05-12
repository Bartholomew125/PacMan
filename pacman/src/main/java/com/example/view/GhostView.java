package com.example.view;

import com.example.model.Ghost;

import javafx.scene.image.Image;

public class GhostView extends AbstractView {
    
    private Ghost ghost;
    private Image ghostImage;

    public GhostView(int width, int height, double positionScaler, Ghost ghost) {
        super(width, height, positionScaler);
        this.ghost = ghost;

        this.ghostImage = new Image("file:src/main/resources/com/example/GreenGhost.png", this.getPositionScaler(), this.getPositionScaler(), false, false);
    }

    @Override
    public void render(double nanoTime) {
        this.clear();

        this.addImageToSurface(this.ghostImage, this.ghost.getX(), this.ghost.getY(), 0);
    }
}
