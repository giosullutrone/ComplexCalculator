package Operations;

import Operations.StackOperations.Dup;
import Complex.Complex;
import complexcalculator.StackNumber;
import complexcalculator.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class DupTest {
    /**
     * Test of execute method, of class Dup.
     */
    @Test
    public void testExecute() {
        // Feedback
        System.out.println("Testing: Dup.execute");
        // Var initialization
        Dup instance;
        StackNumber stackNumber;
        StackOperator stackOperator;
        
        // Case: Stack with 2 elements -> 3 element
        instance = new Dup();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(10, 10));
        stackOperator.execute(new Complex(10, -10));
        stackOperator.execute(instance);
        assertEquals(3, stackNumber.size());
        assertEquals(stackNumber.peekFirst(), new Complex(10, -10));

        // Case: Stack with 0 elements -> 0 element
        instance = new Dup();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(instance);
        assertEquals(0, stackNumber.size());
    }
    
}
