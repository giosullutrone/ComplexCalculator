package Operations.StackOperations;

import Complex.Complex;
import Stack.StackNumber;
import Stack.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClearTest {
    /**
     * Test of execute method, of class Clear.
     * 
     * This test uses both a StackNumber and a StackOperator since its actions
     * are strictly related to them.
     * In case of an error, please make sure that StackOperator and StackNumber
     * pass their tests before testing this class.
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
