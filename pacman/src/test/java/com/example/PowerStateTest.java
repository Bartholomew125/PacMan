package com.example;
import org.junit.jupiter.api.Test;

import com.example.model.states.PowerState;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerStateTest {

    /**Test whether constraints for object PowerState is set with expected values. */
    @Test
    void testPowerStateConstructor() {
    PowerState powerState = new PowerState();
    
    assertEquals(true, powerState.getGhostIsAfraid());
    assertEquals(0.04, powerState.getGhostMovementMultiplier());
    assertEquals(true, powerState.getGhostIsEdible());
    assertEquals(false, powerState.getPacManIsEdible());
    }
}
