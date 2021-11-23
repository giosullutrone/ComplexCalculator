package Operations;

import Complex.Complex;
import complexcalculator.StackNumber;
import complexcalculator.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class SwapTest {
    /**
     * Test of execute method, of class Swap.
     */
    @Test
    public void testExecute() {
        // Feedback
        System.out.println("Testing: Over.execute");
        // Var initialization
        Swap instance;
        StackNumber stackNumber;
        StackOperator stackOperator;
        
        // Case: Stack with 2 elements -> 2 element
        instance = new Swap();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(10, 10));
        stackOperator.execute(new Complex(10, -10));
        stackOperator.execute(instance);
        assertEquals(2, stackNumber.size());
        assertEquals(stackNumber.get(0), new Complex(10, 10));
        assertEquals(stackNumber.get(1), new Complex(10, -10));

        // Case: Stack with 1 elements -> 1 element
        instance = new Swap();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(10, 10));
        stackOperator.execute(instance);
        assertEquals(1, stackNumber.size());
        assertEquals(stackNumber.get(0), new Complex(10, 10));
        
        // Case: Stack with 0 elements -> 0 element
        instance = new Swap();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(instance);
        assertEquals(0, stackNumber.size());
    }    
}
