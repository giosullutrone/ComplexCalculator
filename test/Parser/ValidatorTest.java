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
            new TestNode(false, "?"), new TestNode(false, "test +-"), new TestNode(true, "Test Test Test"),
            new TestNode(true, "10+10j"), new TestNode(true, "+10+10j"), new TestNode(true, "-10+10j"),
            new TestNode(true, "-10-10j"), new TestNode(false, "10+10+10j"), new TestNode(false, "10+10j+10"),
            new TestNode(true, "10.1+10j"),new TestNode(true, "10+10.1j"),new TestNode(true, "10.+10j"),
            new TestNode(true, "-j10"),new TestNode(true, "10j+10"), new TestNode(true, "-j10+10"),
            new TestNode(true, "10+10j -j10+10"), new TestNode(true, "10 -j10+10")
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
