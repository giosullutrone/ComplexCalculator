package Parser;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidatorTest {
    class TestNode{
        boolean testReturn; String toValidate;
        public TestNode(boolean testReturn, String toValidate) {
            this.testReturn = testReturn;
            this.toValidate = toValidate;}}
    
    //List of cases initialization
    LinkedList<TestNode> testList= new LinkedList<>(Arrays.asList(
        new TestNode(true, "+ + +"), new TestNode(false, "not an operation"), new TestNode(true, "Test + + +"), 
            new TestNode(false, ""), new TestNode(false," "),new TestNode(true, "   +      +     +-   clear"), 
            new TestNode(false, "?"), new TestNode(false, "test +-"), new TestNode(true, "Test Test Test")
    ));

    @Test
    public void testIsValid() {
        // Feedback
        System.out.println("Testing: Validator.isValid");
        
        // Var initialization
        DictFunction dict = new DictFunction();
        dict.put("Test", "+ + +");
        //Testing cases
        testList.forEach(node -> {
            assertEquals(node.testReturn, Validator.isValid(node.toValidate, dict.keySet()));
        });
        //Feedback
        System.out.println("Test Ended");
        
    }
    
}
