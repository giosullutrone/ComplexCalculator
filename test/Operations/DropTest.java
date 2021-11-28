package Operations;

import Operations.StackOperations.Drop;
import Complex.Complex;
import complexcalculator.StackNumber;
import complexcalculator.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class DropTest {
    /**
     * Test of execute method, of class Clear.
     */
    @Test
    public void testExecute() {
        // Feedback
        System.out.println("Testing: Drop.execute");
        // Var initialization
        Drop instance;
        StackNumber stackNumber;
        StackOperator stackOperator;
        
        // Case: Stack with 2 elements -> 1 element
        instance = new Drop();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(10, 10));
        stackOperator.execute(new Complex(10, -10));
        stackOperator.execute(instance);
        assertEquals(1, stackNumber.size());
        assertEquals(stackNumber.peekFirst(), new Complex(10, 10));

        // Case: Stack with 0 elements -> 0 element
        instance = new Drop();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(instance);
        assertEquals(0, stackNumber.size());
    }
}
