package com.example.model;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class BGhost extends Ghost {

    public BGhost(float x, float y){ 
        super(x,y,0,0,1,Color.GREEN);
    } 

    //Creating the green ghost 
    BGhost greenGhost = new BGhost(this.x, this.y);

    // Timer for making random movements
    Timeline timeline = new Timeline(new KeyFrame(Duration.INDEFINITE, ae -> moveRandomly()));





    public void moveRandomly(){ 
        greenGhost.left();
    }


    
}
