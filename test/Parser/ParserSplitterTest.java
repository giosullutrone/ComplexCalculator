package Parser;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParserSplitterTest {
    /**
     * Test of parse method, of class ParserSplitter.
     */
    @Test
    public void testParse() {
        // Feedback
        System.out.println("Testing: ParserSplitter.parse");
        // Var initialization
        ParserSplitter instance;
        
        Parser dummyParser = new Parser() {
            private List<String> captured = new LinkedList<String>();
            
            @Override
            public void parse(String operations) {
                this.captured.add(operations);
            }

            @Override
            public boolean equals(Object o) {
                boolean result = this.captured.equals(o);
                this.captured.clear();
                return result;
            }
        };
        
        // Case: s = "+" -> {"+"}
        instance = new ParserSplitter(dummyParser);
        instance.parse("+");
        assertTrue(dummyParser.equals(Arrays.asList("+")));
        
        // Case: s = "  +    " -> {"+"}
        instance = new ParserSplitter(dummyParser);
        instance.parse("  +    ");
        assertTrue(dummyParser.equals(Arrays.asList("+")));
        
        // Case: s = "  +  -  " -> {"+", "-"}
        instance = new ParserSplitter(dummyParser);
        instance.parse("  +  -  ");
        assertTrue(dummyParser.equals(Arrays.asList("+", "-")));
        
        // Case: s = " " -> {}
        instance = new ParserSplitter(dummyParser);
        instance.parse(" ");
        assertTrue(dummyParser.equals(Arrays.asList()));
        
        // Case: s = "10+10j" -> {"10+10j"}
        instance = new ParserSplitter(dummyParser);
        instance.parse("10+10j");
        assertTrue(dummyParser.equals(Arrays.asList("10+10j")));
    }
}
