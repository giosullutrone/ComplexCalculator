package Parser;

import Operations.StackOperations.Clear;
import Operations.StackOperations.Drop;
import Operations.StackOperations.Dup;
import Operations.StackOperations.Over;
import Operations.StackOperations.Swap;
import complexcalculator.StackOperator;

public class ParserStackOperation implements Parser{
    private final StackOperator stackOperator;
    private final Parser nextParser;

    /**
     * Constructor of ParserComplex class
     * @param stackOperator StackOperator on the calculator's stack
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
