package Operations.StackOperations;

import Complex.Complex;
import Stack.StackNumber;
import Stack.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class SwapTest {
    /**
     * Test of execute method, of class Swap.
     * 
     * This test uses both a StackNumber and a StackOperator since its actions
     * are strictly related to them.
     * In case of an error, please make sure that StackOperator and StackNumber
     * pass their tests before testing this class.
     */
    @Test
    public void testExecute() {
        // Feedback
        System.out.println("Testing: Swap.execute");
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
