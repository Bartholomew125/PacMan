package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.model.Pos2D;

public class Pos2DTest {

    /**
     * Test the Pos2D constructor.
     * 
     * This test verifies that when a Pos2D object is created with specific x and y
     * values,
     * those values are correctly stored in the object's field.
     */
    @Test
    void testPos2DConstructor() {
        // Arrange: create a new position with known x and y.
        Pos2D position = new Pos2D(1, 2);

        // Assert: check that x and y are set correctly.
        assertEquals(1, position.getX());
        assertEquals(2, position.getY());
    }

    /**
     * Test the getX-method.
     * 
     * This test verifies that when a given Pos2D object is defined, and one calls
     * the getX-method on this object,
     * one can expect the corresponding x-value.
     */
    @Test
    void testGetX() {
        // Arrange: create new position with known x and y.
        Pos2D position = new Pos2D(1, 4);

        // Assert: check whether method returns known x-value.
        assertEquals(1, position.getX());
    }

    /**
     * Test the setX-method.
     * 
     * This test verifies that the setX-method sets a given Pos2D object's x-field
     * with expected value.
     */
    @Test
    void testSetX() {
        // Arrange: create new position with known x and y.
        Pos2D position = new Pos2D(0, 0);

        // Call method: set field to known x.
        position.setX(12);

        // Assert: check whether field contains expected value.
        assertEquals(12, position.getX());
    }

    /**
     * Test the getX-method.
     * 
     * This test verifies that when a given Pos2D object is defined, and one calls
     * the getX-method on this object,
     * one can expect the corresponding x-value.
     */
    @Test
    void testGetY() {
        // Arrange: create new position with known x and y.
        Pos2D position = new Pos2D(1, 4);

        // Assert: check wether method returns known x-value.
        assertEquals(4, position.getY());
    }

    /**
     * Test the setY-method.
     * 
     * This test verifies that the setY-method sets a given Pos2D object's Y-field
     * with expected value.
     */
    @Test
    void testSetY() {
        // Arrange: create new position with known x and y.
        Pos2D position = new Pos2D(0, 0);

        // Call method: set field to known Y.
        position.setY(14);

        // Assert: check whether field contains expected value.
        assertEquals(14, position.getY());
    }

    /**
     * Test of the toString-method.
     * 
     * This test verifies that the method toString returns the expected output in
     * expected format.
     */
    @Test
    void testToString() {
        // Arrange: create new position with know x and y.
        Pos2D position = new Pos2D(0, 0);

        // Assert: check whether method returns expected output in correct format.
        assertEquals(position.toString(), "(0,0)");
    }

}
