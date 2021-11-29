package Parser;

import Operations.StackOperations.*;
import complexcalculator.StackOperator;

/**
 * Class that converts user's input into methods used to execute specific operations 
 * on the stack.
 */
public class ParserFunction implements Parser{
    private final DictFunction dictFunction;
    private final Parser nextParser;

    /**
     * Constructor of ParserComplex class
     * @param stackOperator StackOperator object to do its operations on
     * @param nextParser next Parser of the chain
     */
    public ParserFunction(DictFunction dictFunction, Parser nextParser) {
        this.dictFunction = dictFunction;
        this.nextParser = nextParser;
    }

    /**
     * Method used to parse a string to a StackOperation 
     * @param s String to parse
     */
    @Override
    public void parse(String s) {
        s = s.trim().toLowerCase();
        
        switch(s) {
            case "clear":
                return;
            }
        nextParser.parse(s);
    }
}
