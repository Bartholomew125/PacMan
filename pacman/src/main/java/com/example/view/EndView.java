package com.example.view;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import com.example.model.Game;

/**
 * The implementation of games endview which extends AbstractView.
 */
public class EndView extends AbstractView {

    private Game game;
    private Text scoreText;
    private Button restartButton;
    private boolean restartButtonPressed;

    /**
     * Creates new insance of EndView.
     * 
     * @param width
     * @param height
     * @param positionScaler
     * @param game
     */
    public EndView(int width, int height, double positionScaler, Game game) {
        super(width, height, positionScaler);

        this.game = game;
        this.restartButtonPressed = false;

        // Create score text
        this.scoreText = new Text();
        this.scoreText.setFill(Color.WHITE);
        this.scoreText.setFont(Font.font("Emulogic", 50));
        this.scoreText.setText("Game Over\n  Score: " + this.game.getScore());

        this.restartButton = new Button("Restart");
        this.restartButton.setPrefWidth(150);
        this.restartButton.setPrefHeight(50);
        this.restartButton.setFont(Font.font("Emulogic"));
        this.restartButton.setLayoutX(width / 2 - this.restartButton.getPrefWidth() / 2);
        this.restartButton.setLayoutY(height / 1.5);

        this.restartButton.pressedProperty().addListener((observeable, wasPressed, pressed) -> {
            this.restartButtonPressed = true;
        });

    }

    @Override
    public void render(double nanoTime) {
        this.clear();

        // Calculate where to place "game-over" text.
        int placeTextX = (int) ((this.width - scoreText.getLayoutBounds().getWidth()) / 2);
        int placeTextY = (int) ((this.height - scoreText.getLayoutBounds().getHeight()) / 2);
        this.scoreText.setText("Game Over\n  Score: " + this.game.getScore());
        this.addTextToSurface(this.scoreText, placeTextX, placeTextY, 0);
        this.getSurface().getChildren().add(this.restartButton);
    }

    /**
     * Get button-state.
     * 
     * @return boolean that represents whether button is pressed or not.
     */
    public boolean restartButtonClicked() {
        boolean state = this.restartButtonPressed;
        this.restartButtonPressed = false;
        return state;
    }
}
