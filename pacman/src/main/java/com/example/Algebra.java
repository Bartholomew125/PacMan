package com.example;

import com.example.model.Moveable;
import com.example.model.Pos2D;

public class Algebra {
    
    /**
     * Calculate the euclidian distance from a moveable m1 to a moveable m2
     * 
     * @param m1
     * @param m2
     * @return the distance
     */
    public static double distanceBetween(Moveable m1, Moveable m2) {
        float distanceX = m2.getX() - m1.getX();
        float distanceY = m2.getY() - m1.getY();
        return Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
    }

    /**
     * Calculate the euclidian distance from a position pos to a moveable m
     * 
     * @param pos
     * @param m
     * @return the distance
     */
    public static double distanceBetween(Pos2D pos, Moveable m) {
        // Takes into account the velocity of the moveable
        float distanceX = m.getX()+m.getDX()/100 - pos.getX();
        float distanceY = m.getY()+m.getDY()/100 - pos.getY();
        return Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
    }

    /**
     * Calculates the euclidian distance from a position p1 to a position p2
     * @param p1
     * @param p2
     * @return the distance
     */
    public static double distanceBetween(Pos2D p1, Pos2D p2) {
        int distanceX = p2.getX() - p1.getX();
        int distanceY = p2.getY() - p1.getY();
        return Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
    }
}
