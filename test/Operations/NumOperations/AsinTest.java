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

public class AsinTest {
    
    public AsinTest() {
    }

    /**
     * Test of execute method, of class Asin.
     */
    @Test
    public void testExecute() {
        // Feedback
        System.out.println("Testing: Asin.execute");
        // Var initialization
        Asin instance;
        StackNumber stackNumber;
        StackOperator stackOperator;
        
        // Case: Stack with 1 elements
        instance = new Asin();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(9, 5));
        stackOperator.execute(instance);
        assertEquals(1, stackNumber.size());
        assertEquals(new Complex(1.061687, 3.023624).toString(), stackNumber.peekFirst().toString());
    }
    
}
