package Operations.StackOperations;

import Complex.Complex;
import Stack.StackNumber;
import Stack.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class DupTest {
    /**
     * Test of execute method, of class Dup.
     * 
     * This test uses both a StackNumber and a StackOperator since its actions
     * are strictly related to them.
     * In case of an error, please make sure that StackOperator and StackNumber
     * pass their tests before testing this class.
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
