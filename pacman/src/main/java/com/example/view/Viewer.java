package com.example.view;

import com.example.model.Game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class Viewer extends AbstractView{

    private GameView gameView;
    private HeaderView headerView; 
    private EndView endView;
    private GraphicsContext gc;
    private boolean end;
    
    public Viewer(int maxWidth, int maxHeight, Game game) {
        super(maxWidth,0,0);
        
        this.end = false;
        
        int headerHeight = 100;
        int squareSize = Math.min(maxWidth/game.getMaze().getWidth(), (maxHeight-headerHeight)/game.getMaze().getHeight());
        int width = game.getMaze().getWidth()*squareSize;
        int height = game.getMaze().getHeight()*squareSize;
        this.gameView = new GameView(width, height, squareSize, game);
        this.headerView = new HeaderView(width, headerHeight, game);
        this.endView = new EndView(width, maxHeight, squareSize, game);

        this.setWidth(width);
        this.setHeight(height+headerHeight);

        Canvas canvas = new Canvas(this.width, this.height);
        this.gc = canvas.getGraphicsContext2D();
        this.gc.setFill(Color.BLACK);
        this.surface.getChildren().add(canvas);

        BorderPane bp = new BorderPane();
        bp.setTop(headerView.getSurface());
        bp.setCenter(gameView.getSurface());
        this.getSurface().getChildren().add(bp);
        this.addView(endView);
    }

    @Override
    public void render(double nanoTime) {
        if (this.end) {
            this.endView.render(nanoTime);
        }
        else {
            this.endView.clear();
            // Set background to black
            this.gc.fillRect(0, 0, this.width, this.height);

            this.gameView.render(nanoTime);
            this.headerView.render(nanoTime);
        }
    }

    public AnimatedImage getPacManAnimation() {
        return this.gameView.getPacManAnimation();
    }

    public void setEnd(boolean isEnded) {
        this.end = isEnded;
    }

    public boolean restartButtonClicked() {
        return this.endView.restartButtonClicked();
    }
}
