package com.example.view;


import java.util.ArrayList;

import com.example.model.Ghost;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.util.Pair;

public class GhostView extends AbstractView {
    
    private ArrayList<Ghost> ghosts;
    private Image ghostAfraidImage;
    private ArrayList<Pair<Ghost,AnimatedImage>> ghostAnimations;

    public GhostView(int width, int height, double positionScaler, ArrayList<Ghost> ghosts) {
        super(width, height, positionScaler);
        this.ghosts = ghosts;

        for (Ghost ghost : this.ghosts) {
            AnimatedImage newGhostAnimation = new AnimatedImage(300000000, (int) this.getPositionScaler());
            newGhostAnimation.loadFramesFromDirectory("ghostFrames", "frame", 9);
            newGhostAnimation.replaceColorsInFrames(Color.color(192/255, 192/255, 192/255), ghost.getColor());
            this.ghostAnimations.add(new Pair<>(ghost, newGhostAnimation));
        }
    }

    @Override
    public void render(double nanoTime) {
        this.clear();

        for (Pair<Ghost, AnimatedImage> pair : this.ghostAnimations) {
            Ghost ghost = pair.getKey();
            AnimatedImage animatedImage = pair.getValue();
            if (pair.getKey().getIsAfraid()) {
                this.addImageToSurface(ghostAfraidImage, ghost.getX(), ghost.getY(), 0, ghost.getRotation()==0);
            }
            else {
                this.addImageToSurface(animatedImage.getFrame(nanoTime), ghost.getX(), ghost.getY(), 0, ghost.getRotation()==0);
            }
        }
    }
}
