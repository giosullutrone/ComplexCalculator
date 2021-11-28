/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import Operations.NumOperations.Mod;
import Complex.Complex;
import complexcalculator.StackNumber;
import complexcalculator.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author francesca
 */
public class ModTest {
    

    /**
     * Test of execute method, of class Mod.
     */
    @Test
    public void testExecute() {
        // Feedback
        System.out.println("Testing: Mod.execute");
        // Var initialization
        Mod instance;
        StackNumber stackNumber;
        StackOperator stackOperator;
        
        // Case: Stack with 1 elements
        instance = new Mod();
        stackNumber = new StackNumber();
        stackOperator = new StackOperator(stackNumber);
        stackOperator.execute(new Complex(9, 5));
        stackOperator.execute(instance);
        assertEquals(1, stackNumber.size());
        assertEquals(new Complex(10.295630140987, 0), stackNumber.peekFirst());
    }
    
}
