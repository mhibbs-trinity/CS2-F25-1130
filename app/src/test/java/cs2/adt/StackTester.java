package cs2.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTester {

    private ArrayStack<Integer> s;

    @BeforeEach
    public void init() {
        s = new ArrayStack<>();
    }

    @Test
    public void testPushPop() {
        assertTrue(s.isEmpty());
        s.push(1);
        s.push(2);
        assertFalse(s.isEmpty());
        assertEquals(s.peek(), 2);
        assertEquals(s.pop(), 2);
        assertEquals(s.peek(), 1);
        assertEquals(s.pop(), 1);
        assertTrue(s.isEmpty());
    }

    @Test
    public void testLotsOfPushPop() {
        assertTrue(s.isEmpty());
        for(int i=0; i<100; i++) {
            s.push(i);
        }
        for(int i=99; i>=0; i--) {
            assertEquals(s.peek(), i);
            assertEquals(s.pop(), i);
        }
        assertTrue(s.isEmpty());
        for(int i=0; i<100; i++) {
            s.push(i);
        }
        for(int i=99; i>=50; i--) {
            assertEquals(s.peek(), i);
            assertEquals(s.pop(), i);
        }
        for(int i=0; i<100; i++) {
            s.push(i);
        }
        for(int i=99; i>=0; i--) {
            assertEquals(s.peek(), i);
            assertEquals(s.pop(), i);
        }
        for(int i=49; i>=0; i--) {
            assertEquals(s.peek(), i);
            assertEquals(s.pop(), i);
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
        } catch(EmptyStackException e) {
            //Do nothing
        } catch(Exception e) {
            fail("Wrong exception thrown " + e.getMessage());
        }
    }
}
