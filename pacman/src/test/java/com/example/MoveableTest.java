package com.example;
import org.junit.jupiter.api.Test;

import com.example.model.Moveable;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

// Concrete subclass for testing purposes
class TestMoveable extends Moveable {
    public TestMoveable(float x, float y, float dx, float dy, float movementMultiplier){
        super(x, y, dx, dy, movementMultiplier);
    }
}
public class MoveableTest {
    
    /**
     * Test that calling right() sets the movement in the positive x-direction.
     */
    @Test
    @DisplayName("Test that 'right()' sets dx=1 and dy=0")
    void testRight(){
        TestMoveable moveable = new TestMoveable(0, 0, 0, 0, 1);
        moveable.right();
        assertEquals(1, moveable.getDX(), "dx should be equal to 1 after calling 'right()'.");
        assertEquals(0, moveable.getDY(), "dy should be equal to 0 after calling 'right()'.");
    }

    /**
     * Test that calling left() sets the movement in the negative x-direction.
     */
    @Test
    @DisplayName("Test that 'left()' sets dx=-1 and dy=0")
    void testLeft(){
        TestMoveable moveable = new TestMoveable(0, 0, 0, 0, 1);
        moveable.left();
        assertEquals(-1, moveable.getDX(), "dx should be equal to -1 after calling 'left()'.");
        assertEquals(0, moveable.getDY(), "dy should be equal to 0 after calling 'left()'.");
    }
    /**
     * Test that calling down() sets the movement in the positive y-direction.
     */
    @Test
    @DisplayName("Test that 'down()' sets dx=0 and dy=1")
    void testDown(){
        TestMoveable moveable = new TestMoveable(0, 0, 0, 0, 1);
        moveable.down();
        assertEquals(0, moveable.getDX(), "dx should be eqaul to 0 after calling 'down()'.");
        assertEquals(1, moveable.getDY(), "dy should be eqaul to 1 after calling 'down()'.");
    }

    /**
     * Test that calling up() set the movement in the negative y-direction.
     */
    @Test
    @DisplayName("Test that 'up()' sets dx=0 and dy=-1")
    void testUp(){
        TestMoveable moveable = new TestMoveable(0, 0, 0, 0, 1);
        moveable.up();
        assertEquals(0, moveable.getDX(), "dx should be equal to 0 after callling 'up()'.");
        assertEquals(-1, moveable.getDY(), "dy should be equal to -1 after callling 'up()'.");

    }

    /**
     * Test that calling getX results in getting the corresponding x-value of the object.
     */
    @Test
    @DisplayName("Test that 'getX() returns 42")
    void testGetX(){
        TestMoveable moveable = new TestMoveable(42, 0, 0, 0, 1);
        assertEquals(42, moveable.getX(), "returned value of 'getX()' should be equal to 42.");
    }

    /**
     * Test that calling getY results in getting the corresponding y-value of the object.
     */    
    @Test
    @DisplayName("Test that 'getY()' returns 123")
    void testGetY(){
        TestMoveable moveable = new TestMoveable(42, 123, 0, 0, 1);
        assertEquals(123, moveable.getY(), "returned value of 'getY()' should be equal to 123.");
    }

    /**
     * Test that setMovementMultiplier sets the objects field to expected value.
     */
    @Test
    @DisplayName("Test that 'setMovementMultiplier()' sets the moveable.movementMultiplier to 23")
    void testSetMovementMultiplier(){
        TestMoveable moveable = new TestMoveable(42, 123, 0, 0, 0);
        moveable.setMovementMultiplier(23);
        assertEquals(23, moveable.getMovementMultiplier(), "movementMultiplier should be equal to 23 after calling 'setMovenmentmultiplier(23)'.");
    }
}
