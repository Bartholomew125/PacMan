package com.example.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * The implementation of the Large Pill which makes pacman able to eat ghosts.
 */
public class LargePill extends Pill {

    /**
     * Create a new large pill at the given x and y positions.
     * @param x
     * @param y
     */
    public LargePill(int x, int y) {
        super(x, y, 50, 20);
    } 


    //generating af largepill with a powerup

    public LargePill newLargePill(){ 
        LargePill largePill = new LargePill(x,y);  
        largePill.getSize();
        largePill.getValue();
        largePill.getPowerUp(); 
        return largePill;

    } 

    //timer for powerup

    public void getPowerUp(){ 
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(15000), ae -> IsActive())); 
        timeline.setCycleCount(1); 
        timeline.play(); 
        if (IsActive()==false){ 
            timeline.stop();
        } else { PowerMode();

        }


    } 

    public boolean IsActive(){ 
        return false;
    } 

    public void PowerMode(){ 
        //Confused on which class controls Pacman Powerups

    }
}
