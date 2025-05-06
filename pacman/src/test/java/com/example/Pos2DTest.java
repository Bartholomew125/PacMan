package com.example;

import org.junit.jupiter.api.Test;

import com.example.model.Pos2D;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Testing operations of the Pos2D class")
public class Pos2DTest {
    
    /**
     * Test the Pos2D constructor.
     * 
     * This test verifies that when a Pos2D object is created with specific x and y values, 
     * those values are correctly stored in the object's field. 
     */
    @Test
    @DisplayName("Test whether the constructor of the Pos2D class sets expected values.")
    void testPos2DConstructor(){
        // Arrange: create a new position with known x and y.
        Pos2D position = new Pos2D(1, 2);
        
        // Assert: check that x and y are set correctly.
        assertEquals(1, position.getX());
        assertEquals(2, position.getY());
    }

    /**
     * Test the getX-method.
     * 
     * This test verifies that when a given Pos2D object is defined, and one calls the getX-method on this object,
     * one can expect the corresponding x-value.
     */
    @Test
    @DisplayName("Test whether the getX method of the Pos2D class returns expected x-value of the given Pos2D object.")
    void testGetX(){
        // Arrange: create new position with known x and y.
        Pos2D position = new Pos2D(1, 4);
        
        // Assert: check whether method returns known x-value.
        assertEquals(1, position.getX());
    }

    /**
     * Test the setX-method.
     * 
     * This test verifies that the setX-method sets a given Pos2D object's x-field with expected value.
     */
    @Test
    @DisplayName("Test whether the setX-method of the Pos2D class sets expected value of object's x-field.")
    void testSetX(){
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
     * This test verifies that when a given Pos2D object is defined, and one calls the getX-method on this object,
     * one can expect the corresponding x-value.
     */
    @Test
    @DisplayName("Test whether the getY method of the Pos2D class returns expected y-value of the given Pos2D object.")
    void testGetY(){
        // Arrange: create new position with known x and y.
        Pos2D position = new Pos2D(1, 4);
        
        // Assert: check wether method returns known x-value.
        assertEquals(4, position.getY());
    }

    /**
     * Test the setY-method.
     * 
     * This test verifies that the setY-method sets a given Pos2D object's Y-field with expected value.
     */
    @Test
    @DisplayName("Test whether the setX-method of the Pos2D class sets expected value of object's y-field.")
    void testSetY(){
        // Arrange: create new position with known x and y.
        Pos2D position = new Pos2D(0, 0);
        
        // Call method: set field to known Y.
        position.setY(14);
        
        // Assert: check whether field contains expected value.
        assertEquals(14, position.getY());
    }

    /**
     * Test of the distanceTo-method.
     * 
     * This test verifies that the distanceTo-method returns expected value of the distance betweeen 
     * a given Pos2D object and some know x and y-coordinates.
     */
    @Test
    @DisplayName("Test whether the distanceTo-method of the Pos2D class returns expected value.")
    void testDistanceTo(){
        // Arrange: create new position with known x and y.
        Pos2D position = new Pos2D(2, 2);
        
        // Assert: check whether the distanace between the given object and its own coordinates is 0.
        assertEquals(0, position.distanceTo(position));
    }

    /**
     * Test of the toString-method.
     * 
     * This test verifies that the method toString returns the expected output in expected format.
     */
    @Test
    @DisplayName("Test whether the toString-method of the Pos2D class returns expected ouput in the correct format.")
    void testToString(){
        // Arrange: create new position with know x and y.
        Pos2D position = new Pos2D(0, 0);
        
        // Assert: check whether method returns expected output in correct format.
        assertEquals(position.toString(), "(0,0)");
    }
    
}
