package com.example;
import com.example.model.SmallPill;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SmallPillTest {
    
    /**Test whether small pill i instanciated with value and size 10. */
    @Test
    void testPillConstructor() {
    SmallPill smallPillObject = new SmallPill(1, 2);
    
    assertEquals(10, smallPillObject.getValue());
    assertEquals(10, smallPillObject.getSize());
    
    }

    /**Test whether newSmallPill-method returns expected values. */
    @Test
    void testNewSmallPillMethod() {
        SmallPill smallPillObject = new SmallPill(1, 2);
        
        // Make sure that positon is initially 0.
        assertEquals(0, smallPillObject.newSmallPill().getX());
        assertEquals(0, smallPillObject.newSmallPill().getY());

        // Check whether constraint for value and size of smallPill holds for the newSmallPillMethod.
        assertEquals(10, smallPillObject.newSmallPill().getValue());
        assertEquals(10, smallPillObject.newSmallPill().getSize());
    }

    
}
