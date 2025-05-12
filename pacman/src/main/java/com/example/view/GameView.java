package com.example.view;

import com.example.model.Game;

import javafx.scene.canvas.GraphicsContext;

/**
 * The view class in the MVC model. It is responsible for taking the maze
 * model, and converting everything in it to a format that can be displayed in
 * the javafx scene from the main class.
 */
public class GameView extends AbstractView{

    private MazeView mazeView;
    private PillView pillView;
    private PacmanView pacmanView;

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

        this.addView(this.mazeView);
        this.addView(this.pillView);
        this.addView(this.pacmanView);

    }

    /**
     * Render everything to the surface
     */
    public void render(double time) {

        // Render other views
        this.mazeView.render(time);
        this.pillView.render(time);
        this.pacmanView.render(time);
    }

    public AnimatedImage getPacmanAnimation() {
        return this.pacmanView.getAnimation();
    }
}
