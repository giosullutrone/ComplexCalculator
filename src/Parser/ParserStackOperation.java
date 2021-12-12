package Parser;

import Operations.StackOperations.*;
import Stack.StackOperator;

/**
 * Class that converts user's input into methods used to execute specific operations 
 * on the stack.
 */
public class ParserStackOperation implements Parser{
    private final StackOperator stackOperator;
    private final Parser nextParser;

    /**
     * Constructor of ParserComplex class
     * @param stackOperator StackOperator object to do its operations on
     * @param nextParser next Parser of the chain
     */
    public ParserStackOperation(StackOperator stackOperator, Parser nextParser) {
        this.stackOperator = stackOperator;
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
                this.stackOperator.execute(new Clear());
                return;
            case "drop":
                stackOperator.execute(new Drop());
                return;
            case "dup":
                stackOperator.execute(new Dup());
                return;
            case "over":
                stackOperator.execute(new Over());
                return;
            case "swap":
                stackOperator.execute(new Swap());
                return;
            }
        nextParser.parse(s);
    }
}
