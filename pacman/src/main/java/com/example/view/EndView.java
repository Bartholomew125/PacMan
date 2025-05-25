package com.example.view;

import com.example.model.Game;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EndView extends AbstractView{

    private Game game;
    private Text scoreText;
    private Button restartButton;
    private boolean restartButtonPressed;

    public EndView (int width, int height, double positionScaler, Game game) {
        super(width, height, positionScaler);
        
        this.game = game;
        this.restartButtonPressed = false;
        
        // Create score text
        this.scoreText = new Text();
        this.scoreText.setFill(Color.WHITE);
        this.scoreText.setFont(Font.font("Comic Sans", 100));
        this.scoreText.setText("Game Over\n  Score: "+this.game.getScore());

        this.restartButton = new Button("Restart");
        this.restartButton.setPrefWidth(100);
        this.restartButton.setPrefHeight(50);
        this.restartButton.setLayoutX(width/2 - this.restartButton.getPrefWidth()/2);
        this.restartButton.setLayoutY(height/1.5);
        
        
        this.restartButton.pressedProperty().addListener((observeable, wasPressed, pressed) -> {this.restartButtonPressed = true;});
    }
    
    @Override
    public void render(double nanoTime) {
        this.clear();
        this.addTextToSurface(this.scoreText, width/5, height/2, 0);
        this.getSurface().getChildren().add(this.restartButton);
    }

    public boolean restartButtonClicked() {
        boolean state = this.restartButtonPressed;
        this.restartButtonPressed = false;
        return state;
    }
}
