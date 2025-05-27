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
    private AnimatedImage ghostGreenAnimatedImage;
    private AnimatedImage ghostMintAnimatedImage;
    private AnimatedImage ghostOrangeAnimatedImage;
    private AnimatedImage ghostPinkAnimatedImage;

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

        // Green Ghost
        this.ghostGreenAnimatedImage = new AnimatedImage(300000000, (int) this.getPositionScaler());
        this.ghostGreenAnimatedImage.loadFramesFromDirectory("ghostGreenFrames", "frame", 2);

        // Mint Ghost
        this.ghostMintAnimatedImage = new AnimatedImage(300000000, (int) this.getPositionScaler());
        this.ghostMintAnimatedImage.loadFramesFromDirectory("ghostMintFrames", "frame", 2);

        // Green Ghost
        this.ghostOrangeAnimatedImage = new AnimatedImage(300000000, (int) this.getPositionScaler());
        this.ghostOrangeAnimatedImage.loadFramesFromDirectory("ghostOrangeFrames", "frame", 2);

        // Green Ghost
        this.ghostPinkAnimatedImage = new AnimatedImage(300000000, (int) this.getPositionScaler());
        this.ghostPinkAnimatedImage.loadFramesFromDirectory("ghostPinkFrames", "frame", 2);

        this.ghostAfraidImage = new Image("file:src/main/resources/com/example/ghostAfraid.png",
                this.getPositionScaler(), this.getPositionScaler(), false, false);
    }

    @Override
    public void render(double nanoTime) {
        this.clear();

        for (Ghost g : this.ghosts) {
            if (g.getIsAfraid()) {
                this.addImageToSurface(ghostAfraidImage, g.getX(), g.getY(), 0, g.getRotation() == 0);
            } else {
                if (g.getColor() == Color.GREEN) {
                    this.addImageToSurface(this.ghostGreenAnimatedImage.getFrame(nanoTime), g.getX(), g.getY(), 0,
                            g.getRotation() == 0);
                } else if (g.getColor() == Color.MINTCREAM) {
                    this.addImageToSurface(this.ghostMintAnimatedImage.getFrame(nanoTime), g.getX(), g.getY(), 0,
                            g.getRotation() == 0);
                } else if (g.getColor() == Color.ORANGE) {
                    this.addImageToSurface(this.ghostOrangeAnimatedImage.getFrame(nanoTime), g.getX(), g.getY(), 0,
                            g.getRotation() == 0);
                } else {
                    this.addImageToSurface(this.ghostPinkAnimatedImage.getFrame(nanoTime), g.getX(), g.getY(), 0,
                            g.getRotation() == 0);
                }
            }
        }
    }
}
