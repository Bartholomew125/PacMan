package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


// Common assertions:
// - assertTrue(condition) - checks if condition is true
// - assertFalse(condition) - checks if condition is false
// - assertEquals(expected, actual) - checks if expected value equals actual value
// - assertNotEquals(expected, actual) - checks if expected value does not equal actual value
// - assertNull(object) - checks if object is null
// - assertNotNull(object) - checks if object is not null
// - assertThrows(exceptionClass, executable) - checks if executable throws the specified exception


// Concrete subclass for testing purposes
class TestMoveable extends Moveable {
    public TestMoveable(float x, float y, float dx, float dy, float movementMultiplier){
        super(x, y, dx, dy, movementMultiplier);
    }
}
public class MoveableTest {

    @Test
    void testRight(){
        TestMoveable moveable = new TestMoveable(0, 0, 0, 0, 1);
        moveable.right();
        assertEquals(1, moveable.dx, "dx should be equal to 1 after calling 'right()'.");
        assertEquals(0, moveable.dy, "dy should be equal to 0 after calling 'right()'.");
    }

    @Test
    void testLeft(){
        TestMoveable moveable = new TestMoveable(0, 0, 0, 0, 1);
        moveable.left();
        assertEquals(-1, moveable.dx, "dx should be equal to -1 after calling 'left()'.");
        assertEquals(0, moveable.dy, "dy should be equal to 0 after calling 'left()'.");
    }

    @Test 
    void testDown(){
        TestMoveable moveable = new TestMoveable(0, 0, 0, 0, 1);
        moveable.down();
        assertEquals(0, moveable.dx, "dx should be eqaul to 0 after calling 'down()'.");
        assertEquals(1, moveable.dy, "dy should be eqaul to 1 after calling 'down()'.");
    }

    @Test
    void testUp(){
        TestMoveable moveable = new TestMoveable(0, 0, 0, 0, 1);
        moveable.up();
        assertEquals(0, moveable.dx, "dx should be equal to 0 after callling 'up()'.");
        assertEquals(-1, moveable.dy, "dy should be equal to -1 after callling 'up()'.");

    }

    @Test 
    void testGetX(){
        TestMoveable moveable = new TestMoveable(42, 0, 0, 0, 1);
        assertEquals(42, moveable.getX(), "returned value of 'getX()' should be equal to 42.");
    }

    @Test
    void testGetY(){
        TestMoveable moveable = new TestMoveable(42, 123, 0, 0, 1);
        assertEquals(123, moveable.getY(), "returned value of 'getY()' should be equal to 123.");
    }

    @Test
    void testSetMovementMultiplier(){
        TestMoveable moveable = new TestMoveable(42, 123, 0, 0, 0);
        moveable.setMovementMultiplier(23);
        assertEquals(23, moveable.movementMultiplier, "movementMultiplier should be equal to 23 after calling 'setMovenmentmultiplier(23)'.");
    }
}
