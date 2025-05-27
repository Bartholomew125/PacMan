package com.example.view;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import java.util.ArrayList;

import com.example.model.Ghost;

/**
 * GhostView which extends AbstractView.
 */
public class GhostView extends AbstractView {

    private ArrayList<Ghost> ghosts;
    private Image ghostAfraidImage;
    private ArrayList<AnimatedImage> ghostAnimations;

    /**
     * Creates an instance of GhostView.
     * 
     * @param width
     * @param height
     * @param positionScaler
     * @param ghosts
     */
    public GhostView(int width, int height, double positionScaler, ArrayList<Ghost> ghosts) {
        super(width, height, positionScaler);
        this.ghosts = ghosts;

        this.ghostAnimations = new ArrayList<>();

        this.ghostAfraidImage = new Image("file:src/main/resources/com/example/ghostAfraid.png", this.getPositionScaler(),
                this.getPositionScaler(), false, false);

        for (Ghost ghost : this.ghosts) {
            AnimatedImage newGhostAnimation = new AnimatedImage(300000000, (int) this.getPositionScaler());
            newGhostAnimation.loadFramesFromDirectory("ghostFrames", "frame", 3);
            newGhostAnimation.replaceColorsInFrames(Color.color(0, 0, 1.0/255.0), ghost.getColor());
            this.ghostAnimations.add(newGhostAnimation);
        }
    }

    @Override
    public void render(double nanoTime) {
        this.clear();

        for (int i = 0; i < this.ghosts.size(); i++) {
            Ghost ghost = this.ghosts.get(i);
            AnimatedImage ghostAnimation = this.ghostAnimations.get(i);

            if (ghost.getIsAfraid()) {
                this.addImageToSurface(ghostAfraidImage, ghost.getX(), ghost.getY(), 0, ghost.getRotation()==0);
            }
            else {
                this.addImageToSurface(ghostAnimation.getFrame(nanoTime), ghost.getX(), ghost.getY(), 0, ghost.getRotation()==0);
            }
        }

    }
}
