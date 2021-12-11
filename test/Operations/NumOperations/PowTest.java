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

public class PowTest {
    
    public PowTest() {
    }

    /**
     * Test of execute method, of class Pow.
     */
    @Test
    public void testExecute() {
        // Feedback
        System.out.println("Testing: Pow.execute");
        // Var initialization
        Pow instance;
        StackNumber stackNumber;
        StackOperator stackOperator;
        
        // Case: Stack with 2 elements
        instance = new Pow();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(2, 3));
        stackOperator.execute(new Complex(9, 5));
        stackOperator.execute(instance);
        assertEquals(1, stackNumber.size());
        assertEquals(new Complex(-3.582986, 22.874532).toString(), stackNumber.peekFirst().toString());
    }
    
}
