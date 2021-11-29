package Operations.StackOperations;

import Operations.StackOperations.Clear;
import Complex.Complex;
import complexcalculator.StackNumber;
import complexcalculator.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClearTest {
    /**
     * Test of execute method, of class Clear.
     */
    @Test
    public void testExecute() {
        // Feedback
        System.out.println("Testing: Clear.execute");
        // Var initialization
        Clear instance;
        StackNumber stackNumber;
        StackOperator stackOperator;
        
        // Case: Stack with 2 elements
        instance = new Clear();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(10, 10));
        stackOperator.execute(new Complex(10, -10));
        stackOperator.execute(instance);
        assertEquals(0, stackNumber.size());
        
        // Case: Stack with 0 elements
        instance = new Clear();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(instance);
        assertEquals(0, stackNumber.size());
    }
}
