package Parser;

import AlertMessage.OperationException;
import AlertMessage.SyntaxException;
import java.io.File;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class DictFunctionTest {

    /**
     * Test of put method, of class DictFunction.
     */
    @Test
    public void testPut() {
        // Feedback
        System.out.println("Testing: DictFunction.put");
        // Var initialization
        DictFunction instance;
        
        // Case: key not in dict, value valid
        instance = new DictFunction();
        instance.put("test", "10+10j 10 +");
        
        // Case: key in dict, value valid -> Exception
        instance = new DictFunction();
        instance.put("test", "10+10j 10 +");
        try {
            instance.put("test", "10+10j 10 +");
            assertTrue(false);
        } catch(SyntaxException e) {}
        
        // Case: key not in dict, value not valid (Invalid op) -> Exception
        instance = new DictFunction();
        try {
            instance.put("test", "10+10j 10+");
            assertTrue(false);
        } catch(SyntaxException e) {}
        
        // Case: key not in dict, value not valid (Recursive op) -> Exception
        instance = new DictFunction();
        try {
            instance.put("test", "test");
            assertTrue(false);
        } catch(SyntaxException e) {}
        
        // Case: key not valid (Space), value valid -> Exception
        instance = new DictFunction();
        try {
            instance.put("test test", "10+10j 10 clear");
            assertTrue(false);
        } catch(SyntaxException e) {}
        
        // Case: key not valid (Not letters), value valid -> Exception
        instance = new DictFunction();
        try {
            instance.put("test12!", "10+10j 10 clear");
            assertTrue(false);
        } catch(SyntaxException e) {}
        
        // Case: key not valid (token), value valid -> Exception
        instance = new DictFunction();
        try {
            instance.put("clear", "10+10j 10 clear");
            assertTrue(false);
        } catch(SyntaxException e) {}
    }

    /**
     * Test of replace method, of class DictFunction.
     */
    @Test
    public void testReplace() {
        // Feedback
        System.out.println("Testing: DictFunction.replace");
        // Var initialization
        DictFunction instance;
        
        // Case: key in dict, value valid
        instance = new DictFunction();
        instance.put("test", "10+10j 10 +");
        instance.replace("test", "10+10j");
        assertEquals(instance.get("test"), "10+10j");
        
        // Case: key in dict, value not valid -> Exception
        instance = new DictFunction();
        try {
            instance.put("test", "10+10j 10+");
            assertTrue(false);
        } catch(SyntaxException e) {}
    }

    /**
     * Test of get method, of class DictFunction.
     */
    @Test
    public void testGet() {
        // Feedback
        System.out.println("Testing: DictFunction.get");
        // Var initialization
        DictFunction instance;
        
        // Case: key in dict, value valid
        instance = new DictFunction();
        instance.put("test", "10+10j 10 +");
        assertEquals(instance.get("test"), "10+10j 10 +");
        
        // Case: key not in dict, value valid -> Exception
        instance = new DictFunction();
        try {
            instance.get("test");
            assertTrue(false);
        } catch(OperationException e) {}
    }
    
    /**
     * Test of renameCascade method, of class DictFunction.
     */
    @Test
    public void testRenameCascade() {
        // Feedback
        System.out.println("Testing: DictFunction.renameCascade");
        // Var initialization
        DictFunction instance;
        
        // Case: Rename customTwo
        //       dictFunction = {"customOne": "customTwo", "customTwo": "10+10j"}
        instance = new DictFunction();
        instance.put("customTwo", "10+10j");
        instance.put("customOne", "customTwo");
        String oldValue = instance.get("customTwo");
        instance.renameCascade("customTwo", "customTwoNew");
        
        assertEquals(instance.get("customTwoNew"), oldValue);
        try {
            assertEquals(instance.get("customTwo"), null);
            assertTrue(false);
        }catch (OperationException e) {}

        // Case: Remove custom3
        //       dictFunction = {"customOne": "customTwo", "customTwo": "10+10j"}
        instance = new DictFunction();
        instance.put("customTwo", "10+10j");
        instance.put("customOne", "customTwo");
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
        
        // Case: Remove customTwo
        //       dictFunction = {"customOne": "customTwo", "customTwo": "10+10j"}
        instance = new DictFunction();
        instance.put("customTwo", "10+10j");
        instance.put("customOne", "customTwo");
        instance.removeCascade("customTwo");
        
        try {
            assertEquals(instance.get("customOne"), null);
            assertTrue(false);
        }catch (OperationException e) {}
        try {
            assertEquals(instance.get("customTwo"), null);
            assertTrue(false);
        }catch (OperationException e) {}

        // Case: Remove custom3
        //       dictFunction = {"customOne": "customTwo", "customTwo": "10+10j"}
        instance = new DictFunction();
        instance.put("customTwo", "10+10j");
        instance.put("customOne", "customTwo");
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
        
        // Case: isCalled customTwo -> true
        //       dictFunction = {"customOne": "customTwo", "customTwo": "10+10j"}
        instance = new DictFunction();
        instance.put("customTwo", "10+10j");
        instance.put("customOne", "customTwo");
        instance.isCalled("customTwo");        
        assertTrue(instance.isCalled("customTwo"));

        // Case: isCalled customOne -> false
        //       dictFunction = {"customOne": "customTwo", "customTwo": "10+10j"}
        instance = new DictFunction();
        instance.put("customTwo", "10+10j");
        instance.put("customOne", "customTwo");
        assertTrue(!instance.isCalled("customOne"));
    }    
    
    /**
     * Test of toFile and fromFile methods, of class DictFunction.
     */
    @Test
    public void testToFileFromFile() {
        // Feedback
        System.out.println("Testing: DictFunction.toFileFromFile");
        // Var initialization
        DictFunction instance, instanceFromFile;
        
        instance = new DictFunction();
        instanceFromFile = new DictFunction();
        instance.put("customOne", "10+10j");
        
        try {
            instance.toFile("test.txt");
            instanceFromFile.fromFile("test.txt");
            assertEquals(instance.keySet(), instanceFromFile.keySet());
        } catch(IOException | ClassNotFoundException e) {
            assertTrue(false);
        } finally {
            new File("test.txt").delete(); 
        }
    }

    /**
     * Test of clear method, of class DictFunction.
     */
    @Test
    public void testClear() {
    }
    
    /**
     * Test of toFile method, of class DictFunction.
     */
    @Test
    public void testToFile() throws Exception {
    }

    /**
     * Test of fromFile method, of class DictFunction.
     */
    @Test
    public void testFromFile() throws Exception {
    }
}
