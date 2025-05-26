package com.example;

import org.junit.jupiter.api.Test;

import com.example.model.PacMan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;



public class PacManTest {

    /**
     * Test the PacMan constructor.
     * 
     * Test whether PacMan gets constructed with the movementmultiplier set to 1 (moving to the right),
     * whilst dx and dy are set to 0, unless specified otherwise.
     */
    @Test
    @DisplayName("Test whether the PacMan-constructor creates a new PacMan-object moving to the right.")
    void testPacManConstructor() {
        // Arrange: create a new PacMan with known x and y.
        PacMan pacManObject = new PacMan(1, 0);

        // Assert: check that x and y are set correctly.
        assertEquals(1, pacManObject.getX());
        assertEquals(0, pacManObject.getY());

        // Assert: check that dx and dy are set to 0 by default.
        assertEquals(1, pacManObject.getDX());
        assertEquals(0, pacManObject.getDY());

        // Assert: check that PacMan is moving to the right.
        assertEquals(0.06, pacManObject.getMovementMultiplier());
    }
}
