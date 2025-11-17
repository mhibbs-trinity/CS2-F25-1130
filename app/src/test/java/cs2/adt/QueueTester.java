package cs2.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTester {
    private Queue<Integer> s;

    @BeforeEach
    public void init() {
        s = new LinkedQueue<>();
    }

    @Test
    public void testEnDequeue() {
        assertTrue(s.isEmpty());
        s.enqueue(1);
        s.enqueue(2);
        assertFalse(s.isEmpty());
        assertEquals(s.peek(), 1);
        assertEquals(s.dequeue(), 1);
        assertEquals(s.peek(), 2);
        assertEquals(s.dequeue(), 2);
        assertTrue(s.isEmpty());
    }

    @Test
    public void testLotsOf() {
        assertTrue(s.isEmpty());
        for(int i=0; i<100; i++) {
            s.enqueue(i);
        }
        for(int i=0; i<100; i++) {
            assertEquals(s.peek(), i);
            assertEquals(s.dequeue(), i);
        }
        assertTrue(s.isEmpty());
        for(int i=0; i<100; i++) {
            s.enqueue(i);
        }
        for(int i=0; i<50; i++) {
            assertEquals(s.peek(), i);
            assertEquals(s.dequeue(), i);
        }
        for(int i=0; i<100; i++) {
            s.enqueue(i);
        }
        for(int i=50; i<100; i++) {
            assertEquals(s.peek(), i);
            assertEquals(s.dequeue(), i);
        }

        for(int i=0; i<100; i++) {
            assertEquals(s.peek(), i);
            assertEquals(s.dequeue(), i);
        }
        assertTrue(s.isEmpty());
        //s.pop();
    }

    @Test
    public void testExceptions() {
        try {
            s.peek();
            //SHOULD NEVER GET HERE
            fail("EmptyStackException not thrown");
        } //TODO 
        catch(EmptyQueueException e) {
            //Do nothing
        } catch(Exception e) {
            fail("Wrong exceptionException thrown " + e.getMessage());
        }
    }
}
