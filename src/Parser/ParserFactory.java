package Parser;


import complexcalculator.StackNumber;
import complexcalculator.StackOperator;

/**
 * Class that create a Chain of Parser
 */
public class ParserFactory {
    
    private final StackOperator stackOperator;
    private final StackNumber stackNumber;
    private final DictFunction dictFunction;
    private final DictVar dictVar;
            
    /**
     * Constructor of ParserFactory class
     * @param s StackNumber of elements inserted by the user
     */
    public ParserFactory(StackNumber s, DictFunction dict) {
        this.dictVar = new DictVar();
        this.dictFunction = dict;
        this.stackNumber = s;
        this.stackOperator = new StackOperator(s);
    }
    
    /**
     * Method used to generate a parser chain
     * @return first chain's parser
     */
    public ParserFunction chain(){
        ParserComplex complex = new ParserComplex(stackOperator);
        ParserNumOperation numOperation = new ParserNumOperation(stackOperator, complex);
        ParserStackOperation stackOperation = new ParserStackOperation(stackOperator, numOperation);
        ParserVar var = new ParserVar(stackNumber, dictVar, stackOperation);
        return new ParserFunction(var, dictFunction);
    }
}