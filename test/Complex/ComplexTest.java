package Complex;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ComplexTest {
    /**
     * Test of toString method of class Complex.
     */
    @Test
    public void testToString() {
        // Feedback
        System.out.println("Testing: Complex.toString");
        // Var initialization
        Complex instance;
        String result, expResult;
        
        // Case: positive real, negative img
        instance = new Complex(10, -10);
        expResult = "10.0-10.0j";
        result = instance.toString();
        assertEquals(expResult, result);
        
        // Case: negative real, positive img
        instance = new Complex(-10, 10);
        expResult = "-10.0+10.0j";
        result = instance.toString();
        assertEquals(expResult, result);
        
        // Case: zero real, positive img
        instance = new Complex(0, 10);
        expResult = "0.0+10.0j";
        result = instance.toString();
        assertEquals(expResult, result);
        
        // Case: positive real, zero img
        instance = new Complex(10, 0);
        expResult = "10.0+0.0j";
        result = instance.toString();
        assertEquals(expResult, result);
    }
}