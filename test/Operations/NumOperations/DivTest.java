/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations.NumOperations;

import Operations.NumOperations.Div;
import Complex.Complex;
import complexcalculator.StackNumber;
import complexcalculator.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class DivTest {

    /**
     * Test of execute method, of class Div.
     */
    @Test
    public void testExecute() {
        // Feedback
        System.out.println("Testing: Div.execute");
        // Var initialization
        Div instance;
        StackNumber stackNumber;
        StackOperator stackOperator;
        
        // Case: Stack with 2 elements
        instance = new Div();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(10, 10));
        stackOperator.execute(new Complex(10, -5));
        stackOperator.execute(instance);
        assertEquals(1, stackNumber.size());
        assertEquals(new Complex(0.25, -0.75).toString(), stackNumber.peekFirst().toString());
    }
    
}
