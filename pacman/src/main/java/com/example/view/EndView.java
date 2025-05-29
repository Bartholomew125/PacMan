package com.example.view;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

import com.example.controller.MainController;
import com.example.model.Game;

/**
 * The implementation of games endview which extends AbstractView.
 */
public class EndView extends AbstractView {

    private Game game;
    private Text scoreText;
    private Button restartButton;

    /**
     * Creates new insance of EndView.
     * 
     * @param width
     * @param height
     * @param positionScaler
     * @param game
     */
    public EndView(int width, int height, double positionScaler, Game game, MainController mainController) {
        super(width, height, positionScaler);

        this.game = game;

        // Create score text
        this.scoreText = new Text();
        this.scoreText.setText("Game Over\nScore " + this.game.getScore());
        int placeTextX = (int) ((this.width - this.scoreText.getLayoutBounds().getWidth()) / 2);
        int placeTextY = (int) ((this.height - this.scoreText.getLayoutBounds().getHeight()) / 2);
        this.addTextToSurface(this.scoreText, placeTextX, placeTextY, 20);
        this.restartButton = addButtonToSuface("Restart", 15, 200, 50, this.getWidth()/ 2 - 200 / 2, this.getHeight() / 1.5); 
        this.restartButton.setOnAction(e -> mainController.restart());
    }

    @Override
    public void render(double nanoTime) {

        // Calculate where to place "game-over" text.
        this.scoreText.setText("Game Over\nScore " + this.game.getScore());
        int placeTextX = (int) ((this.getWidth() - this.scoreText.getLayoutBounds().getWidth()) / 2);
        int placeTextY = (int) ((this.getHeight() - this.scoreText.getLayoutBounds().getHeight()) / 2);
        this.addTextToSurface(this.scoreText, placeTextX, placeTextY, 20);
        this.getSurface().getChildren().add(this.restartButton);
    }
}