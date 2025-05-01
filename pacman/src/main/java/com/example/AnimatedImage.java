package com.example;

import javafx.scene.image.Image;

public class AnimatedImage {
    
    private Image[] frames;
    private double duration;
    private int squareSize;
    private int rotation;


    public AnimatedImage(double nanoTimePerFrame, int squareSize) {
        this.duration = nanoTimePerFrame;
        this.squareSize = squareSize;
        this.rotation = 0;
    }

    /**
     * Sets the frames of the animated image given the filename prefix, the folder where the files exist, and the number of files to be loaded.
     * <p>
     * Example use: 
     * <pre> 
     * AnimTim.setFrames("pacmanImages", "pacman", "10"); 
     * </pre>
     * @param folder
     * @param fileName
     * @param files
     */
    public void loadFramesFromDirectory(String folder, String fileName, int files) {
        this.frames = new Image[files];
        for (int i = 0; i < files; i++) {
            this.frames[i] = new Image("file:src/main/resources/com/example/"+folder+"/"+fileName+i+".png", 
                squareSize, squareSize, false, false);
        }
    }

    /**
     * @param time
     * @return The frame for a given time
     */
    public Image getFrame(double time) {
        int index = (int) ((time % (this.frames.length * this.duration)) / this.duration);
        return this.frames[index];
    }

    /**
     * Set the rotation of the animation
     * @param rotation
     */
    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    /**
     * @return The rotation of the animation
     */
    public int getRotation() {
        return this.rotation;
    }
}
