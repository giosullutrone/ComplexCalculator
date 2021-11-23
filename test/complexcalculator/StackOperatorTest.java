package complexcalculator;

import Complex.Complex;
import Operations.Clear;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackOperatorTest {

    /**
     * Test of execute method, of class StackOperator.
     */
    @Test
    public void testExecute_Complex() {
        // Feedback
        System.out.println("Testing: StackOperator.execute of Complex");
        // Var initialization
        StackNumber stackNumber;
        StackOperator instance;
        
        // Case: Stack with 0 elements -> 1 element
        stackNumber = new StackNumber();
        instance = new StackOperator(stackNumber);
        instance.execute(new Complex(10, 10));
        assertEquals(1, stackNumber.size());
        assertEquals(stackNumber.peekFirst(), new Complex(10, 10));
        
        // Case: Stack with 1 elements -> 2 element
        stackNumber = new StackNumber();
        instance = new StackOperator(stackNumber);
        instance.execute(new Complex(10, 10));
        instance.execute(new Complex(10, -10));
        assertEquals(2, stackNumber.size());
        assertEquals(stackNumber.get(0), new Complex(10, -10));
        assertEquals(stackNumber.get(1), new Complex(10, 10));
    }

    /**
     * Test of execute method, of class StackOperator.
     */
    @Test
    public void testExecute_Operation0() {
        // Feedback
        System.out.println("Testing: StackOperator.execute of Operation0");
        // Var initialization
        StackNumber stackNumber;
        StackOperator instance;
        
        // Case using Clear: Stack with 2 elements -> 0 element
        stackNumber = new StackNumber();
        instance = new StackOperator(stackNumber);
        instance.execute(new Complex(10, 10));
        instance.execute(new Complex(10, -10));
        instance.execute(new Clear());
        assertEquals(0, stackNumber.size());
    }

    /**
     * Test of execute method, of class StackOperator.
     */
    @Test
    public void testExecute_Operation1() {
        // To implement
        assertEquals(0, 1);
    }

    /**
     * Test of execute method, of class StackOperator.
     */
    @Test
    public void testExecute_Operation2() {
        // To implement
        assertEquals(0, 1);
    }
    
}
