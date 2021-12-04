package Parser;


import complexcalculator.StackNumber;
import complexcalculator.StackOperator;

/**
 * Class that create a Chain of Parser
 */
public class ParserFactory {
    
    private final StackOperator stackOperator;
    private final StackNumber stackNumber;
    private final DictVar dict;
            
    /**
     * Constructor of ParserFactory class
     * @param s StackNumber of elements inserted by the user
     */
    public ParserFactory(StackNumber s) {
        this.dict = new DictVar();
        this.stackNumber = s;
        this.stackOperator = new StackOperator(s);
    }
    
    /**
     * Method used to generate a parser chain
     * @return first chain's parser
     */
    public ParserVar chain(){
        ParserComplex complex = new ParserComplex(stackOperator);
        ParserNumOperation numOperation = new ParserNumOperation(stackOperator, complex);
        ParserStackOperation stackOperation = new ParserStackOperation(stackOperator, numOperation);
        return new ParserVar(stackNumber, dict, stackOperation);
    }
}