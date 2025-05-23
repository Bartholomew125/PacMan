package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.model.states.NormalState;

public class NormalStateTest {
    
    /**Test whether constraints for object NormalState is set with expected values. */
    @Test
    void testNormalStateConstructor(){
        NormalState normalState = new NormalState();
        
        assertEquals(false, normalState.getGhostIsAfraid());
        assertEquals(2.0, normalState.getGhostMovementMultiplier());
        assertEquals(false, normalState.getGhostIsEdible());
        assertEquals(true, normalState.getPacManIsEdible());
    }
}
