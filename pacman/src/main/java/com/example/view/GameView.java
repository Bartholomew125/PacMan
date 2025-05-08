package com.example.view;

import com.example.model.Game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * The view class in the MVC model. It is responsible for taking the maze
 * model, and converting everything in it to a format that can be displayed in
 * the javafx scene from the main class.
 */
public class GameView extends AbstractView{

    private MazeView mazeView;
    private PillView pillView;
    private PacmanView pacmanView;
    //private HeaderView headerView;

    GraphicsContext gc;

    /**
     * Create a new view of a maze, and a square size
     * 
     * @param maze
     * @param squareSize
     */
    public GameView(int width, int height, double positionScaler, Game game) {
        super(width, height, positionScaler);

        this.mazeView = new MazeView(width, height, positionScaler, game.getMaze());
        this.pillView = new PillView(width, height, positionScaler, game.getSmallPills(), game.getLargePills());
        this.pacmanView = new PacmanView(width, height, positionScaler, game.getPacMan());

        Canvas canvas = new Canvas(this.width, this.height);
        this.gc = canvas.getGraphicsContext2D();
        this.gc.setFill(Color.BLACK);
        this.surface.getChildren().add(canvas);
        this.addView(this.mazeView);
        this.addView(this.pillView);
        this.addView(this.pacmanView);
        //this.addView(this.headerView);

    }

    /**
     * Render everything to the surface
     */
    public void render(double time) {

        // Set background to black
        this.gc.fillRect(0, 0, this.width, this.height);

        // Render other views
        this.mazeView.render(time);
        this.pillView.render(time);
        this.pacmanView.render(time);
        //this.headerView.render(time);
    }



    public AnimatedImage getPacmanAnimation() {
        return this.pacmanView.getAnimation();
    }
}
