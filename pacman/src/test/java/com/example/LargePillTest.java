package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.model.LargePill;

public class LargePillTest {

    /**
     * Test whether LargePill constructor sets expected values.
     */
    @Test
    void testLargePillConstructor() {
        LargePill LargePillObject = new LargePill(2, 1);

        assertEquals(2, LargePillObject.getX());
        assertEquals(1, LargePillObject.getY());

        assertEquals(50, LargePillObject.getValue());
        assertEquals(20, LargePillObject.getSize());
    }
}
