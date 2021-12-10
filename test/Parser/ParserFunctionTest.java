package Parser;

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
        DictFunction dictFunction;
        ParserFunction instance;
        
        ParserSplitterInterface dummyParser = new ParserSplitterInterface() {
            private String captured = "";
            
            @Override
            public void parse(String operations) {
                this.captured = operations;
            }

            @Override
            public boolean equals(Object o) {
                return this.captured.equals(o);
            }
        };
        
        // Case: dictFunction = {"custom1": "10+10j"}
        //                  s = "custom1" -> "10+10j"
        dictFunction = new DictFunction();
        instance = new ParserFunction(dummyParser, dictFunction);
        dictFunction.put("custom1", "10+10j");
        instance.parse("custom1");
        assertTrue(dummyParser.equals("10+10j"));
        
        // Case: dictFunction = {"custom1": "10+10j"}
        //                  s = "custom" -> "custom"
        dictFunction = new DictFunction();
        instance = new ParserFunction(dummyParser, dictFunction);
        dictFunction.put("custom1", "10+10j");
        instance.parse("custom");
        assertTrue(dummyParser.equals("custom"));
        
        // Case: dictFunction = {"custom": "10+10j"}
        //                  s = "custom1" -> "custom1"
        dictFunction = new DictFunction();
        instance = new ParserFunction(dummyParser, dictFunction);
        dictFunction.put("custom", "10+10j");
        instance.parse("custom1");
        assertTrue(dummyParser.equals("custom1"));
        
        // Case: dictFunction = {"custom1": "custom2", "custom2": "10-10j"}
        //                  s = "custom1" -> "10-10j"
        dictFunction = new DictFunction();
        instance = new ParserFunction(dummyParser, dictFunction);
        dictFunction.put("custom2", "10-10j");
        dictFunction.put("custom1", "custom2");
        instance.parse("custom1");
        assertTrue(dummyParser.equals("10-10j"));
        
        // Case: dictFunction = {}
        //                  s = "custom1" -> "custom1"
        dictFunction = new DictFunction();
        instance = new ParserFunction(dummyParser, dictFunction);
        instance.parse("custom1");
        assertTrue(dummyParser.equals("custom1"));
    }
}