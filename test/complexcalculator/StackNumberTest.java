package complexcalculator;

import Complex.Complex;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackNumberTest {
    /**
     * Test of getStack method without an integer provided, of class StackNumber.
     */
    @Test
    public void testGetStack() {
        // Feedback
        System.out.println("Testing: StackNumber.getStack");
        // Var initialization
        StackNumber instance;
        List<String> lString;
        
        // Case: Stack with 0 elements -> 0 elements shown
        instance = new StackNumber();
        assertEquals(0, instance.getStack().size());
        
        // Case: Stack with 2 elements -> 2 elements shown
        instance = new StackNumber();
        instance.addFirst(new Complex(10, 10));
        instance.addFirst(new Complex(10, -10));
        lString = instance.getStack();
        
        assertEquals(2, lString.size());        
        assertEquals(lString.get(0), new Complex(10, -10).toString());
        assertEquals(lString.get(1), new Complex(10, 10).toString());
        
        // Case: Stack with 20 elements -> top 20 element shown
        instance = new StackNumber();
        for (int i=0; i<20; i++) {
            instance.addFirst(new Complex(10, i));
        }        
        lString = instance.getStack();
        
        assertEquals(20, lString.size());
        assertEquals(lString.get(0), new Complex(10, 19).toString());
        assertEquals(lString.get(1), new Complex(10, 18).toString());
    }

    /**
     * Test of getStack method with an integer provided, of class StackNumber.
     */
    @Test
    public void testGetStack_int() {
        // Feedback
        System.out.println("Testing: StackNumber.getStack with int provided");
        // Var initialization
        StackNumber instance;
        List<String> lString;
        
        // Case: Stack with 0 elements -> 0 elements shown
        instance = new StackNumber();
        assertEquals(0, instance.getStack(12).size());
        
        // Case: Stack with 2 elements -> 2 elements shown
        instance = new StackNumber();
        instance.addFirst(new Complex(10, 10));
        instance.addFirst(new Complex(10, -10));
        lString = instance.getStack(12);
        
        assertEquals(2, lString.size());        
        assertEquals(lString.get(0), new Complex(10, -10).toString());
        assertEquals(lString.get(1), new Complex(10, 10).toString());
        
        // Case: Stack with 20 elements -> top 12 element shown
        instance = new StackNumber();
        for (int i=0; i<20; i++) {
            instance.addFirst(new Complex(10, i));
        }        
        lString = instance.getStack(12);
        
        assertEquals(12, lString.size());
        assertEquals(lString.get(0), new Complex(10, 19).toString());
        assertEquals(lString.get(1), new Complex(10, 18).toString());
    }
}
