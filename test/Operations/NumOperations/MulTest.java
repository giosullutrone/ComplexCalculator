/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations.NumOperations;

import Operations.NumOperations.Mul;
import Complex.Complex;
import complexcalculator.StackNumber;
import complexcalculator.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class MulTest {
    
    /**
     * Test of execute method, of class Mul.
     */
    @Test
    public void testExecute() {
        // Feedback
        System.out.println("Testing: Mul.execute");
        // Var initialization
        Mul instance;
        StackNumber stackNumber;
        StackOperator stackOperator;
        
        // Case: Stack with 1 elements
        instance = new Mul();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(9, 5));
        stackOperator.execute(new Complex(10, -5));
        stackOperator.execute(instance);
        assertEquals(1, stackNumber.size());
        assertEquals(new Complex(115, 5).toString(), stackNumber.peekFirst().toString());
    }
    
}
