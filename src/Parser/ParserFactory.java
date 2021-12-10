package Parser;


import complexcalculator.StackNumber;
import complexcalculator.StackOperator;

/**
 * Class that creates a Chain of Parsers
 */
public class ParserFactory {
    
    private final StackOperator stackOperator;
    private final StackNumber stackNumber;
    private final DictFunction dictFunction;
    private final DictVar dictVar;

    /**
     * Constructor of ParserFactory class
     * @param s StackNumber of elements inserted by the user
     * @param dictFunction Dictionary of user defined operations
     * @param dictVar Dictionary of vars
     */
    public ParserFactory(StackNumber s, DictFunction dictFunction, DictVar dictVar) {
        this.dictVar = dictVar;
        this.dictFunction = dictFunction;
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