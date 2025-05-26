package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.example.model.states.DeadState;

/**
 * DeadStateTest
 */
public class DeadStateTest {

    @Test
    void testDeadStateConstructor (){
        DeadState newDeadState = new DeadState();
        
        assertEquals(false, newDeadState.getGhostIsAfraid(), "Expected ghostIsAfraid to be false in DeadState.");
        assertEquals(0, newDeadState.getGhostMovementMultiplier(), "Expected ghostMovementMultiplier to be set to 0 in DeadState.");
        assertEquals(false, newDeadState.getGhostIsEdible(), "Expected ghost to not be edible in DeadState.");
        assertEquals(false, newDeadState.getPacManIsEdible(), "Expected PacMan to not be edible in DeadState.");
        assertEquals(0, newDeadState.getPacManMovementmultiplier(), "Expected PacMan to have pacManMovementmultiplier set to 0 in DeadState.");
    }
}

