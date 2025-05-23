package com.example.view;


import java.util.ArrayList;

import com.example.model.Ghost;

import javafx.scene.image.Image;

public class GhostView extends AbstractView {
    
    private ArrayList<Ghost> ghosts;
    private Image ghostImage;

    public GhostView(int width, int height, double positionScaler, ArrayList<Ghost> ghosts) {
        super(width, height, positionScaler);
        this.ghosts = ghosts;

        this.ghostImage = new Image("file:src/main/resources/com/example/GreenGhost.png", this.getPositionScaler(), this.getPositionScaler(), false, false);
    }

    @Override
    public void render(double nanoTime) {
        this.clear();

        for (Ghost g : this.ghosts) {
            this.addImageToSurface(this.ghostImage, g.getX(), g.getY(), 0);
        }
    }
}
