/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations.NumOperations;

import Complex.Complex;
import Stack.StackNumber;
import Stack.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class SinTest {
    
    public SinTest() {
    }

    /**
     * Test of execute method, of class Sin.
     */
    @Test
    public void testExecute() {
        // Feedback
        System.out.println("Testing: Sin.execute");
        // Var initialization
        Sin instance;
        StackNumber stackNumber;
        StackOperator stackOperator;
        
        // Case: Stack with 1 elements
        instance = new Sin();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(9, 5));
        stackOperator.execute(instance);
        assertEquals(1, stackNumber.size());
        assertEquals(new Complex(30.583291, -67.608790).toString(), stackNumber.peekFirst().toString());
    }
    
}
