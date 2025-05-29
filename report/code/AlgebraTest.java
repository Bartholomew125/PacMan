package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.controller.Algebra;
import com.example.model.PacMan;
import com.example.model.Pos2D;
import com.example.model.Wall;
import com.example.model.Ghost;

public class AlgebraTest {
    
    /*Test distance between two Moveables.*/ 
    @Test
    void testDistanceBetweenMoveable() {

        // Construct two new moveables.
        PacMan pacman = new PacMan(2, 2);
        Ghost ghost = new Ghost(1, 1, null, null);
        

        // Use distanceBetween on the two moveables.
        // expectedDistance := sqrt((2-1)**2 + (2-1)**2) = 1.4142135623730951
        double expectedDinstance = 1.4142135623730951;
        assertEquals(expectedDinstance, Algebra.distanceBetween(pacman, ghost));
    }

    /*Test distance between two Pos2D.*/
    @Test
    void testDistanceBetweenPos2D(){
        // Create objects with positions.
        Wall wall = new Wall(32, 55);
        Ghost ghost = new Ghost(2, 43, null, null);
        Pos2D ghostPos = new Pos2D((int) ghost.getX(), (int) ghost.getY());

        // Use distanceBetween on two Pos2D.
        // expectedDistance := sqrt((32-2)**2 + (55-43)**2) = 32.3109888428070
        double expectedDistance = 32.31098884280702;
        assertEquals(expectedDistance, Algebra.distanceBetween(wall, ghostPos));
    }

    /*Test distance between a pos */
    @Test
    void testDistanceBetwenPos2DAndMoveable(){
       Wall wall = new Wall(43, 11);
       PacMan pacman = new PacMan(421, 43);

       // Use distanceBetween on two Pos2D.
       // expectedDistance := sqrt((421-43)**2 + (43-11)**2) = 379.35207920874774
       double expectedDinstance = 379.3620532987029;
       assertEquals(expectedDinstance, Algebra.distanceBetween(wall, pacman));
    }

}