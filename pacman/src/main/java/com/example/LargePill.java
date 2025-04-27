package com.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * The implementation of the Large Pill which makes pacman able to eat ghosts.
 */
public class LargePill extends Pill {

    public LargePill(float x, float y) {
        this.size = 20;
        this.value = 50;
        this.x = x;
        this.y = y;
    } 

    public LargePill newLargePill(){ 
        return new LargePill(x, y);
    } 

    public LargePill newPowerUp(){ 
        LargePill powerup = new LargePill(x,y); 
        powerup.getPowerUp(); 
        return powerup;

    } 

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
