package org.example.Task5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntSequenceTest {
    @Test
    void testSequence() {
        IntSequence sequence = IntSequence.constant(1);

        assertTrue(sequence.hasNext());
        assertEquals(1, sequence.next());

        assertTrue(sequence.hasNext());
        assertEquals(1, sequence.next());

        assertTrue(sequence.hasNext());
        assertEquals(1, sequence.next());

        assertTrue(sequence.hasNext());
        assertEquals(1, sequence.next());

        assertTrue(sequence.hasNext());
    }
}
