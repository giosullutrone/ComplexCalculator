package Parser;

import Complex.Complex;
import complexcalculator.StackNumber;
import complexcalculator.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParserVarTest {
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
        stackNumber = new StackNumber();
        dictVar = new DictVar();
        instance = new ParserVar(stackNumber, dictVar, null);
        stackOperator = new StackOperator(stackNumber);
        num = new Complex(10, 10);
        stackOperator.execute(num);
        instance.parse(">a");
        assertEquals(dictVar.get("a"), num);
        
        // Case: >[A-Z]
        stackNumber = new StackNumber();
        dictVar = new DictVar();
        instance = new ParserVar(stackNumber, dictVar, null);
        stackOperator = new StackOperator(stackNumber);
        num = new Complex(10, 10);
        stackOperator.execute(num);
        instance.parse(">A");
        assertEquals(dictVar.get("a"), num);
        
        // Case: >[^a-z]
        stackNumber = new StackNumber();
        dictVar = new DictVar();
        instance = new ParserVar(stackNumber, dictVar, null);
        stackOperator = new StackOperator(stackNumber);
        num = new Complex(10, 10);
        stackOperator.execute(num);
        try {
            instance.parse(">1");
            assertEquals(dictVar.get("1"), num);
            assertTrue(false);
        } catch (NullPointerException e) {}
 
        // Case: >[aa-zz]
        stackNumber = new StackNumber();
        dictVar = new DictVar();
        instance = new ParserVar(stackNumber, dictVar, null);
        stackOperator = new StackOperator(stackNumber);
        num = new Complex(10, 10);
        stackOperator.execute(num);
        try {
            instance.parse(">aa");
            assertEquals(dictVar.get("aa"), null);
            assertTrue(false);
        } catch (ExceptionInInitializerError e) {}
        
        // Case: >>[a-z]
        stackNumber = new StackNumber();
        dictVar = new DictVar();
        instance = new ParserVar(stackNumber, dictVar, null);
        stackOperator = new StackOperator(stackNumber);
        num = new Complex(10, 10);
        stackOperator.execute(num);
        try {
            instance.parse(">>a");
            assertTrue(false);
        } catch (NoClassDefFoundError e) {}
        
        // Case: <[a-z]
        stackNumber = new StackNumber();
        dictVar = new DictVar();
        stackOperator = new StackOperator(stackNumber);
        instance = new ParserVar(stackNumber, dictVar, new ParserComplex(stackOperator));
        num = new Complex(10, 10);
        stackOperator.execute(num);
        instance.parse(">a");
        instance.parse("<a");
        assertEquals(stackNumber.peekFirst(), num);
        
        // Case: <[A-Z]
        stackNumber = new StackNumber();
        dictVar = new DictVar();
        stackOperator = new StackOperator(stackNumber);
        instance = new ParserVar(stackNumber, dictVar, new ParserComplex(stackOperator));
        num = new Complex(10, 10);
        stackOperator.execute(num);
        instance.parse(">A");
        instance.parse("<A");
        assertEquals(stackNumber.peekFirst(), num);
        
        // Case: <[aa-zz]
        stackNumber = new StackNumber();
        dictVar = new DictVar();
        stackOperator = new StackOperator(stackNumber);
        instance = new ParserVar(stackNumber, dictVar, null);
        num = new Complex(10, 10);
        stackOperator.execute(num);
        try {
            instance.parse(">aa");
            instance.parse("<aa");
            assertTrue(false);
        } catch (NoClassDefFoundError e) {}
        
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
    }
}
