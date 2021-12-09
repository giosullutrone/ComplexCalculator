package Parser;

import Complex.Complex;
import complexcalculator.StackNumber;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParserFunctionTest {
    /**
     * Test of parse method, of class ParserFunction.
     */
    @Test
    public void testParse() {
        // Feedback
        System.out.println("Testing: ParserFunction.parse");
        // Var initialization
        StackNumber stackNumber, stackNumberParser;
        DictFunction dictFunction;
        DictVar dictVar;
        ParserFunction instance;
        Parser chain;
        String s;
        
        // Case: dictFunction = {"custom1": "10+10j"}
        //                  s = "custom1"
        stackNumber = new StackNumber();
        stackNumberParser = new StackNumber();
        dictFunction = new DictFunction();
        dictVar = new DictVar();
        chain = new ParserFactory(stackNumberParser, dictFunction, dictVar).chain();
        instance = new ParserFunction(chain, dictFunction);
        s = "custom1";
        dictFunction.put("custom1", "10+10j");
        
        stackNumber.add(new Complex(10, 10));
        instance.parse(s);
        assertEquals(stackNumber, stackNumberParser);
        // Case: dictFunction = {"custom1": "custom2", "custom2": "10+10j"}
        //                  s = "custom1"
        stackNumber = new StackNumber();
        stackNumberParser = new StackNumber();
        dictFunction = new DictFunction();
        chain = new ParserFactory(stackNumberParser, dictFunction, dictVar).chain();
        instance = new ParserFunction(chain, dictFunction);
        s = "custom1";
        dictFunction.put("custom2", "10+10j");
        dictFunction.put("custom1", "custom2");
        
        stackNumber.add(new Complex(10, 10));
        instance.parse(s);
        assertEquals(stackNumber, stackNumberParser);
        
        // Case: dictFunction = {}
        //                  s = "custom1"
        stackNumber = new StackNumber();
        dictFunction = new DictFunction();
        instance = new ParserFunction(null, dictFunction);
        s = "custom1";
        
        try {
            stackNumber.add(new Complex(10, 10));
            instance.parse(s);
            assertTrue(false);
        } catch (NullPointerException e) {}
    }
}
