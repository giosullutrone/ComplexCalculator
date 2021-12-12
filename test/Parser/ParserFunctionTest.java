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
        
        // Case: dictFunction = {"customOne": "10+10j"}
        //                  s = "customOne" -> "10+10j"
        dictFunction = new DictFunction();
        instance = new ParserFunction(dummyParser, dictFunction);
        dictFunction.put("customOne", "10+10j");
        instance.parse("customOne");
        assertTrue(dummyParser.equals("10+10j"));
        
        // Case: dictFunction = {"customOne": "10+10j"}
        //                  s = "custom" -> "custom"
        dictFunction = new DictFunction();
        instance = new ParserFunction(dummyParser, dictFunction);
        dictFunction.put("customOne", "10+10j");
        instance.parse("custom");
        assertTrue(dummyParser.equals("custom"));
        
        // Case: dictFunction = {"custom": "10+10j"}
        //                  s = "customOne" -> "customOne"
        dictFunction = new DictFunction();
        instance = new ParserFunction(dummyParser, dictFunction);
        dictFunction.put("custom", "10+10j");
        instance.parse("customOne");
        assertTrue(dummyParser.equals("customOne"));
        
        // Case: dictFunction = {"customOne": "customTwo", "customTwo": "10-10j"}
        //                  s = "customOne" -> "10-10j"
        dictFunction = new DictFunction();
        instance = new ParserFunction(dummyParser, dictFunction);
        dictFunction.put("customTwo", "10-10j");
        dictFunction.put("customOne", "customTwo");
        instance.parse("customOne");
        assertTrue(dummyParser.equals("10-10j"));
        
        // Case: dictFunction = {}
        //                  s = "customOne" -> "customOne"
        dictFunction = new DictFunction();
        instance = new ParserFunction(dummyParser, dictFunction);
        instance.parse("customOne");
        assertTrue(dummyParser.equals("customOne"));
    }
}