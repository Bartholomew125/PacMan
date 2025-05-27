package com.example.view;

import com.example.model.Game;

/**
 * The view class in the MVC model. It is responsible for taking the maze
 * model, and converting everything in it to a format that can be displayed in
 * the javafx scene from the main class.
 */
public class GameView extends AbstractView {

    private MazeView mazeView;
    private PillView pillView;
    private PacManView pacManView;
    private GhostView ghostView;

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
        this.ghostView = new GhostView(width, height, positionScaler, game.getGhosts());
        this.pacManView = new PacManView(width, height, positionScaler, game.getPacMan());

        this.addView(this.mazeView);
        this.addView(this.pillView);
        this.addView(this.pacManView);
        this.addView(this.ghostView);
    }

    @Override
    public void render(double nanoTime) {
        this.mazeView.render(nanoTime);
        this.pillView.render(nanoTime);
        this.pacManView.render(nanoTime);
        this.ghostView.render(nanoTime);
    }
    
    public AnimatedImage getPacManAnimation() {
        return this.pacManView.getAnimation();
    }
}
