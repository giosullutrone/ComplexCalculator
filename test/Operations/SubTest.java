/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import Operations.NumOperations.Sub;
import Complex.Complex;
import complexcalculator.StackNumber;
import complexcalculator.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author francesca
 */
public class SubTest {
    

    /**
     * Test of execute method, of class Sub.
     */
    @Test
    public void testExecute() {
        // Feedback
        System.out.println("Testing: Sub.execute");
        // Var initialization
        Sub instance;
        StackNumber stackNumber;
        StackOperator stackOperator;
        
        // Case: Stack with 2 elements
        instance = new Sub();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(10, 10));
        stackOperator.execute(new Complex(10, -10));
        stackOperator.execute(instance);
        assertEquals(1, stackNumber.size());
        assertEquals(new Complex(0, -20), stackNumber.peekFirst());
    }
    
}
