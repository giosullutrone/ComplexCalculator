package Parser;

import Dict.DictVar;
import AlertMessage.OperationException;
import AlertMessage.SyntaxException;
import Complex.Complex;
import Stack.StackNumber;
import Stack.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParserVarTest {
    private void assertWithoutException(String toParse, String toGet) {
        // Var initialization
        ParserVar instance;
        DictVar dictVar;
        StackNumber stackNumber;
        StackOperator stackOperator;
        Complex num;
        
        // Execution
        stackNumber = new StackNumber();
        dictVar = new DictVar();
        instance = new ParserVar(stackNumber, dictVar, null);
        stackOperator = new StackOperator(stackNumber);
        num = new Complex(10, 10);
        stackOperator.execute(num);
        instance.parse(toParse);
        assertEquals(dictVar.get(toGet), num);
    }
    
    private void assertWithException(String toParse, String toGet) {
        // Var initialization
        ParserVar instance;
        DictVar dictVar;
        StackNumber stackNumber;
        StackOperator stackOperator;
        Complex num;
        
        // Execution
        stackNumber = new StackNumber();
        dictVar = new DictVar();
        instance = new ParserVar(stackNumber, dictVar, null);
        stackOperator = new StackOperator(stackNumber);
        num = new Complex(10, 10);
        stackOperator.execute(num);
        try {
            instance.parse(toParse);
            assertEquals(dictVar.get(toGet), num);
            assertTrue(false);
        } catch (RuntimeException e) {}
    }
    
    private void assertPeek(String toParseFirst, String toParseSecond) {
        // Var initialization
        ParserVar instance;
        DictVar dictVar;
        StackNumber stackNumber;
        StackOperator stackOperator;
        Complex num;
        
        // Execution
        stackNumber = new StackNumber();
        dictVar = new DictVar();
        stackOperator = new StackOperator(stackNumber);
        instance = new ParserVar(stackNumber, dictVar, new ParserComplex(stackOperator));
        num = new Complex(10, 10);
        stackOperator.execute(num);
        instance.parse(toParseFirst);
        instance.parse(toParseSecond);
        assertEquals(stackNumber.peekFirst(), num);
    }

    /**
     * Test of parse method, of class ParserVar.
     * 
     * This test uses a StackNumber and StackOperator since its actions are 
     * strictly related to it.
     * In case of an error, please make sure that StackNumber passes its tests 
     * before testing this class.
     */
    @Test
    public void testParse() {
        // Feedback
        System.out.println("Testing: ParserVar.parse");
        // Var initialization
        ParserVar instance;
        DictVar dictVar;
        StackNumber stackNumber;
        StackOperator stackOperator;
        Complex num;
        
        // Case: >[a-z]
        assertWithoutException(">a", "a");        
        // Case: >[A-Z]
        assertWithoutException(">A", "a");        
        // Case: >[^a-z]
        assertWithException(">1", "1"); 
        // Case: >[aa-zz]
        assertWithException(">aa", "aa");        
        // Case: >>[a-z]
        assertWithException(">>a", "a");        
        // Case: <[a-z]
        assertPeek(">a", "<a");        
        // Case: <[A-Z]
        assertPeek(">A", "<A");

        // Case: !a
        stackNumber = new StackNumber();
        dictVar = new DictVar();
        instance = new ParserVar(stackNumber, dictVar, null);
        stackOperator = new StackOperator(stackNumber);
        num = new Complex(10, 10);
        stackOperator.execute(num);
        instance.parse(">a");
        stackOperator.execute(num);
        instance.parse("!a");
        try {
            dictVar.get("a");
            assertTrue(false);
        } catch (OperationException e) {}
        try {
            instance.parse("!aa");
            instance.parse("a!");
            assertTrue(false);
        } catch (SyntaxException e) {}
        
        // Case: Save - Restore
        stackNumber = new StackNumber();
        dictVar = new DictVar();
        instance = new ParserVar(stackNumber, dictVar, null);
        stackOperator = new StackOperator(stackNumber);
        num = new Complex(10, 10);
        Complex numOverwrite = new Complex(10, -10);
        stackOperator.execute(num);
        instance.parse(">a");
        instance.parse("save");
        stackOperator.execute(numOverwrite);
        instance.parse(">a");
        assertEquals(dictVar.get("a"), numOverwrite);
        instance.parse("restore");
        assertEquals(dictVar.get("a"), num);

        // Case: clc
        stackNumber = new StackNumber();
        dictVar = new DictVar();
        instance = new ParserVar(stackNumber, dictVar, null);
        stackOperator = new StackOperator(stackNumber);
        num = new Complex(10, 10);
        stackOperator.execute(num);
        instance.parse(">a");
        stackOperator.execute(num);
        instance.parse(">b");
        instance.parse("clc");
        try {
            dictVar.get("a");
            dictVar.get("b");
            assertTrue(false);
        } catch (OperationException e) {}
    }
}
