/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations.NumOperations;

import Complex.Complex;
import complexcalculator.StackNumber;
import complexcalculator.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class TanTest {
    
    public TanTest() {
    }

    /**
     * Test of execute method, of class Tan.
     */
    @Test
    public void testExecute() {
        // Feedback
        System.out.println("Testing: Tan.execute");
        // Var initialization
        Tan instance;
        StackNumber stackNumber;
        StackOperator stackOperator;
        
        // Case: Stack with 1 elements
        instance = new Tan();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(9, 5));
        stackOperator.execute(instance);
        assertEquals(1, stackNumber.size());
        assertEquals(new Complex(-6.818544819942735E-5,0.9999400428082992), stackNumber.peekFirst());
    }
    
}
