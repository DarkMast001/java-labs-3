package org.example.Task4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntSequenceTest {
    @Test
    void testSequence() {
        IntSequence sequence = IntSequence.of(3, 1, 4, 1, 5, 9);

        assertTrue(sequence.hasNext());
        assertEquals(3, sequence.next());

        assertTrue(sequence.hasNext());
        assertEquals(1, sequence.next());

        assertTrue(sequence.hasNext());
        assertEquals(4, sequence.next());

        assertTrue(sequence.hasNext());
        assertEquals(1, sequence.next());

        assertTrue(sequence.hasNext());
        assertEquals(5, sequence.next());

        assertTrue(sequence.hasNext());
        assertEquals(9, sequence.next());

        assertFalse(sequence.hasNext());
    }

    @Test
    void testEmptySequence() {
        IntSequence sequence = IntSequence.of();

        assertFalse(sequence.hasNext());
    }

    @Test
    void testNextAfterEnd() {
        IntSequence sequence = IntSequence.of(42);

        assertTrue(sequence.hasNext());
        assertEquals(42, sequence.next());

        assertFalse(sequence.hasNext());

        assertThrows(IllegalStateException.class, sequence::next);
    }

}
