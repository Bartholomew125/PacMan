package com.example.view;

import com.example.model.Game;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EndView extends AbstractView{

    private Game game;
    private Text scoreText;

    public EndView (int width, int height, double positionScaler, Game game) {
        super(width, height, positionScaler);
        
        
        this.game = game;
        
        
        // Create score text
        this.scoreText = new Text();
        this.scoreText.setFill(Color.WHITE);
        this.scoreText.setFont(Font.font("Comic Sans", 100));
        this.addTextToSurface(this.scoreText, width/5, height/2, 0);
    }
    
    @Override
    public void render(double nanoTime) {
        this.scoreText.setText("Game Over\n  Score: "+this.game.getScore());
    }
}
