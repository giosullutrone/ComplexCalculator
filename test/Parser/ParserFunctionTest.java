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
        ParserFunction instance;
        Parser chain;
        String s;
        
        // Case: dictFunction = {"custom1": "10+10j"}
        //                  s = "custom1"
        stackNumber = new StackNumber();
        stackNumberParser = new StackNumber();
        chain = new ParserFactory(stackNumberParser).Chain();
        dictFunction = new DictFunction();
        instance = new ParserFunction(dictFunction, chain);
        s = "custom1";
        dictFunction.put("custom1", "10+10j");
        
        stackNumber.add(new Complex(10, 10));
        instance.parse(s);
        assertEquals(stackNumber, stackNumberParser);
        
        // Case: dictFunction = {"custom1": "custom2", "custom2": "10+10j"}
        //                  s = "custom1"
        stackNumber = new StackNumber();
        stackNumberParser = new StackNumber();
        chain = new ParserFactory(stackNumberParser).Chain();
        dictFunction = new DictFunction();
        instance = new ParserFunction(dictFunction, chain);
        s = "custom1";
        dictFunction.put("custom1", "custom2");
        dictFunction.put("custom2", "10+10j");
        
        stackNumber.add(new Complex(10, 10));
        instance.parse(s);
        assertEquals(stackNumber, stackNumberParser);
        
        // Case: dictFunction = {}
        //                  s = "custom1"
        stackNumber = new StackNumber();
        stackNumberParser = new StackNumber();
        chain = new ParserFactory(stackNumberParser).Chain();
        dictFunction = new DictFunction();
        instance = new ParserFunction(dictFunction, chain);
        s = "custom1";
        
        try {
            stackNumber.add(new Complex(10, 10));
            instance.parse(s);
            assertTrue(false);
        } catch (ExceptionInInitializerError e) {}
    }    
}
