package com.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * The implementation of the Large Pill which makes pacman able to eat ghosts.
 */
public class LargePills extends Pill {

    public LargePills(float x, float y) {
        this.size = 20;
        this.value = 50;
        this.x = x;
        this.y = y;
    } 


    //generating af largepill with a powerup

    public LargePills newLargePill(){ 
        LargePills largePill = new LargePills(x,y);  
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
