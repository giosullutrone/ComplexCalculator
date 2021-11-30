/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations.NumOperations;

import Operations.NumOperations.Arg;
import Complex.Complex;
import complexcalculator.StackNumber;
import complexcalculator.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArgTest {
    /**
     * Test of execute method, of class Arg.
     */
    @Test
    public void testExecute() {
        // Feedback
        System.out.println("Testing: Arg.execute");
        // Var initialization
        Arg instance;
        StackNumber stackNumber;
        StackOperator stackOperator;
        
        // Case: Stack with 1 elements
        instance = new Arg();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(9, 5));
        stackOperator.execute(instance);
        assertEquals(1, stackNumber.size());
        assertEquals(new Complex(0.51, 0).toString(), stackNumber.peekFirst().toString());
    }
    
}
