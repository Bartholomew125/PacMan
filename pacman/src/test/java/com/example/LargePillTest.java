package com.example;
import com.example.model.LargePill;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LargePillTest {

    @Test
    void testLargePillConstructor() {
        LargePill LargePillObject = new LargePill(2, 1);
        
        assertEquals(2, LargePillObject.getX());
        assertEquals(1, LargePillObject.getY());
        
        assertEquals(50, LargePillObject.getValue());
        assertEquals(20, LargePillObject.getSize());
    }
}