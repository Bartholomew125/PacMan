package com.example.view;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class AnimatedImage {
    
    private Image[] frames;
    private double duration;
    private int size;
    private int rotation;


    public AnimatedImage(double nanoTimePerFrame, int size) {
        this.duration = nanoTimePerFrame;
        this.size = size;
        this.rotation = 0;
    }

    /**
     * Sets the frames of the animated image given the filename prefix, the folder where the files exist, and the number of files to be loaded.
     * <p>
     * Example use: 
     * <pre> 
     * AnimTim.setFrames("pacManImages", "pacMan", "10"); 
     * </pre>
     * @param folder
     * @param fileName
     * @param files
     */
    public void loadFramesFromDirectory(String folder, String fileName, int files) {
        this.frames = new Image[files];
        for (int i = 0; i < files; i++) {
            this.frames[i] = new Image("file:src/main/resources/com/example/"+folder+"/"+fileName+i+".png", 
                size, size, false, false);
        }
    }

    public void replaceColorsInFrames(Color fromColor, Color toColor) {
        for (int i = 0; i < this.frames.length; i++) {
            Image frame = this.frames[i];
            PixelReader pxr = frame.getPixelReader();
            WritableImage newFrame = new WritableImage(pxr, (int)frame.getWidth(), (int)frame.getHeight());
            PixelWriter pxw = newFrame.getPixelWriter();
            for (int y = 0; y < frame.getHeight(); y++) {
                for (int x = 0; x < frame.getWidth(); x++) {
                    if (pxr.getColor(x, y).equals(fromColor)) {
                        pxw.setColor(x, y, toColor);
                    }
                }
            }
            this.frames[i] = newFrame;
        }
    }

    /**
     * @param time
     * @return The frame for a given time
     */
    public Image getFrame(double nanoTime) {
        int index = (int) ((nanoTime % (this.frames.length * this.duration)) / this.duration);
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
