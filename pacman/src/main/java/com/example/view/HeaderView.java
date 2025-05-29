package com.example.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import com.example.model.Game;

/**
 * HeaderView which extends AbstractView.
 */
public class HeaderView extends AbstractView {

    private Text scoreText;
    private Text livesText;
    private Game game;
    private GraphicsContext gc;

    /**
     * Creates an instance of HeaderView.
     * 
     * @param width
     * @param height
     * @param game
     */
    public HeaderView(int width, int height, Game game) {
        super(width, height, 1);
        this.game = game;
        
        // Draw a rectangle to the header
        Canvas canvas = new Canvas(this.getWidth(), this.getHeight());
        this.gc = canvas.getGraphicsContext2D();
        this.gc.setStroke(Color.WHITE);
        this.gc.setLineWidth(2);
        this.gc.strokeRect(0, 0, this.getWidth(), this.getHeight());
        this.getSurface().getChildren().add(canvas);

        // Create score text
        this.scoreText = new Text();
        this.addTextToSurface(this.scoreText, 30, this.getHeight() / 2, 20);

        // Create lives text
        this.livesText = new Text();
        this.addTextToSurface(this.livesText, this.getWidth() - 200, this.getHeight() / 2, 20);
    }

    @Override
    public void render(double nanoTime) {
        this.scoreText.setText("Score: " + this.game.getScore());
        this.livesText.setText("Lives: " + this.game.getLives());
    }
}
