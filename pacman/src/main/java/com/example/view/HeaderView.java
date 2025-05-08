package com.example.view;

import com.example.model.Game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HeaderView extends AbstractView{

    private Text scoreText;
    private Game game;
    private GraphicsContext gc;
    
    public HeaderView(int width, int height, Game game) {
        super(width, height, 1);
        this.game = game;


        Canvas canvas = new Canvas(this.getWidth(), this.getHeight());
        this.gc = canvas.getGraphicsContext2D();
        this.gc.setStroke(Color.WHITE);
        this.gc.setLineWidth(2);
        this.gc.strokeRect(0, 0, this.getWidth(), this.getHeight());
        this.getSurface().getChildren().add(canvas);


        this.scoreText = new Text();
        this.scoreText.setFill(Color.WHITE);
        this.scoreText.setFont(Font.font("Comic Sans", 30));
        this.addTextToSurface(scoreText, 20, this.getHeight()/2, 0);
    }

    @Override
    public void render(double nanoTime) {
        this.scoreText.setText("Score: "+this.game.getScore());
    }
}
