package com.example.controller;

import com.example.model.Direction;

import javafx.scene.input.KeyCode;
import javafx.util.Pair;

/**
 * The DirectionAdapter class is used to adapt between different representations
 * of directions.
 */
public class DirectionAdapter {

    /**
     * Adapts a arrow-key keycode to a direction.
     * 
     * @param key
     * @return
     */
    public static Direction adapt(KeyCode key) {
        if (key == KeyCode.LEFT) {
            return Direction.LEFT;
        } else if (key == KeyCode.RIGHT) {
            return Direction.RIGHT;
        } else if (key == KeyCode.DOWN) {
            return Direction.DOWN;
        } else if (key == KeyCode.UP) {
            return Direction.UP;
        } else {
            return null;
        }
    }

    /**
     * Adapts direction x and direction y to a direction.
     * 
     * @param x
     * @param y
     * @return
     */
    public static Direction adapt(float x, float y) {
        if (x == 0 && y == -1) {
            return Direction.UP;
        } else if (x == 0 && y == 1) {
            return Direction.DOWN;
        } else if (x == -1 && y == 0) {
            return Direction.LEFT;
        } else if (x == 1 && y == 0) {
            return Direction.RIGHT;
        } else {
            return null;
        }
    }

    /**
     * Adapts direction x and y to a direction.
     * 
     * @param dir
     * @return
     */
    public static Pair<Float, Float> adapt(Direction dir) {
        if (dir == Direction.LEFT) {
            return new Pair<>(-1f, 0f);
        } else if (dir == Direction.RIGHT) {
            return new Pair<>(1f, 0f);
        } else if (dir == Direction.DOWN) {
            return new Pair<>(0f, 1f);
        } else if (dir == Direction.UP) {
            return new Pair<>(0f, -1f);
        } else {
            return null;
        }
    }

    /**
     * Adapts a Direction to degrees.
     * 
     * @param dir
     * @return
     */
    public static int adaptDegrees(Direction dir) {
        if (dir == Direction.LEFT) {
            return 180;
        } else if (dir == Direction.RIGHT) {
            return 0;
        } else if (dir == Direction.DOWN) {
            return 90;
        } else if (dir == Direction.UP) {
            return -90;
        } else {
            return 0;
        }
    }

    /**
     * Returns the opposite of a Direction.
     *
     * @param dir
     * @return
     */
    public static Direction opposite(Direction dir) {
        if (dir == Direction.LEFT) {
            return Direction.RIGHT;
        } else if (dir == Direction.RIGHT) {
            return Direction.LEFT;
        } else if (dir == Direction.DOWN) {
            return Direction.UP;
        } else if (dir == Direction.UP) {
            return Direction.DOWN;
        } else {
            return null;
        }
    }
}
