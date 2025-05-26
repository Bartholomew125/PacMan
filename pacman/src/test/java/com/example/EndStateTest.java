package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.example.model.states.EndState;

public class EndStateTest {

    /*
     * Test whether the constructor of EndState sets expected values of superclass.
     */
    @Test
    void testEndStateConstructor() {
        EndState newEndState = new EndState();

        assertEquals(false, newEndState.getGhostIsAfraid(), "Expected ghostIsAfraid to be false in EndState.");

        assertEquals(0, newEndState.getGhostMovementMultiplier(),
                "Expected ghostMovementMultiplier to be 0 in EndState.");
        assertEquals(false, newEndState.getGhostIsEdible(), "Expected ghostIsEdible to false in EndState.");
        assertEquals(false, newEndState.getPacManIsEdible(), "Expected pacManIsEdible to be false in EndState.");
        assertEquals(0, newEndState.getPacManMovementmultiplier(),
                "Expected pacManMovementmultiplier to be 0 in EndState.");
    }
}
