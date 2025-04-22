package com;

public class PacManGame {

    public static void main(String[] args) {

        PacMan pacman = new PacMan();
        Maze maze = new Maze(500, 1000, pacman);
        Controller controller = new Controller(pacman);
        View view = new View(maze);

        while (true) {

            pacman.move();
        }
    }

}