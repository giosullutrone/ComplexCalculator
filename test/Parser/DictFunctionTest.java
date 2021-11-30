/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Parser;

import AlertMessage.OperationException;
import complexcalculator.StackNumber;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gio
 */
public class DictFunctionTest {
    /**
     * Test of renameCascade method, of class DictFunction.
     */
    @Test
    public void testRenameCascade() {
        // Feedback
        System.out.println("Testing: DictFunction.renameCascade");
        // Var initialization
        DictFunction instance;
        
        // Case: Rename custom2
        //       dictFunction = {"custom1": "custom2", "custom2": "10+10j"}
        instance = new DictFunction();
        instance.put("custom1", "custom2");
        instance.put("custom2", "10+10j");
        String oldValue = instance.get("custom2");
        instance.renameCascade("custom2", "custom2New");
        
        assertEquals(instance.get("custom2New"), oldValue);
        try {
            assertEquals(instance.get("custom2"), null);
            assertTrue(false);
        }catch (OperationException e) {}

        // Case: Remove custom3
        //       dictFunction = {"custom1": "custom2", "custom2": "10+10j"}
        instance = new DictFunction();
        instance.put("custom1", "custom2");
        instance.put("custom2", "10+10j");
        try {
            instance.renameCascade("custom3", "custom3New");
            assertTrue(false);
        } catch (OperationException e) {}
    }

    /**
     * Test of removeCascade method, of class DictFunction.
     */
    @Test
    public void testRemoveCascade() {
        // Feedback
        System.out.println("Testing: DictFunction.removeCascade");
        // Var initialization
        DictFunction instance;
        
        // Case: Remove custom2
        //       dictFunction = {"custom1": "custom2", "custom2": "10+10j"}
        instance = new DictFunction();
        instance.put("custom1", "custom2");
        instance.put("custom2", "10+10j");
        instance.removeCascade("custom2");
        
        try {
            assertEquals(instance.get("custom1"), null);
            assertTrue(false);
        }catch (OperationException e) {}
        try {
            assertEquals(instance.get("custom2"), null);
            assertTrue(false);
        }catch (OperationException e) {}

        // Case: Remove custom3
        //       dictFunction = {"custom1": "custom2", "custom2": "10+10j"}
        instance = new DictFunction();
        instance.put("custom1", "custom2");
        instance.put("custom2", "10+10j");
        try {
            instance.removeCascade("custom3");
            assertTrue(false);
        } catch (OperationException e) {}
    }

    /**
     * Test of isUsed method, of class DictFunction.
     */
    @Test
    public void testIsCalled() {
        // Feedback
        System.out.println("Testing: DictFunction.isCalled");
        // Var initialization
        DictFunction instance;
        
        // Case: isCalled custom2 -> true
        //       dictFunction = {"custom1": "custom2", "custom2": "10+10j"}
        instance = new DictFunction();
        instance.put("custom1", "custom2");
        instance.put("custom2", "10+10j");
        instance.isCalled("custom2");        
        assertTrue(instance.isCalled("custom2"));

        // Case: isCalled custom1 -> false
        //       dictFunction = {"custom1": "custom2", "custom2": "10+10j"}
        instance = new DictFunction();
        instance.put("custom1", "custom2");
        instance.put("custom2", "10+10j");
        assertTrue(!instance.isCalled("custom1"));
    }    
}
