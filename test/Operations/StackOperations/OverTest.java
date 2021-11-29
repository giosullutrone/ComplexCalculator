package Operations.StackOperations;

import Operations.StackOperations.Over;
import Complex.Complex;
import complexcalculator.StackNumber;
import complexcalculator.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class OverTest {
    /**
     * Test of execute method, of class Over.
     */
    @Test
    public void testExecute() {
        // Feedback
        System.out.println("Testing: Over.execute");
        // Var initialization
        Over instance;
        StackNumber stackNumber;
        StackOperator stackOperator;
        
        // Case: Stack with 2 elements -> 3 element
        instance = new Over();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(10, 10));
        stackOperator.execute(new Complex(10, -10));
        stackOperator.execute(instance);
        assertEquals(3, stackNumber.size());
        assertEquals(stackNumber.peekFirst(), new Complex(10, 10));

        // Case: Stack with 1 elements -> 1 element
        instance = new Over();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(10, 10));
        stackOperator.execute(instance);
        assertEquals(1, stackNumber.size());
        
        // Case: Stack with 0 elements -> 0 element
        instance = new Over();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(instance);
        assertEquals(0, stackNumber.size());
    }    
}
