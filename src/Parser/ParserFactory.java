package Parser;


import Dict.DictFunction;
import Dict.DictVar;
import Stack.StackNumber;
import Stack.StackOperator;

/**
 * Class that creates a Chain of Parsers
 */
public class ParserFactory {    
    /**
     * Method used to generate a parser chain
     * @param stackNumber
     * @param dictFunction
     * @param dictVar
     * @return first chain's parser
     */
    public static ParserFunction chain(StackNumber stackNumber, DictFunction dictFunction, DictVar dictVar){
        StackOperator stackOperator = new StackOperator(stackNumber);
        ParserComplex complex = new ParserComplex(stackOperator);
        ParserNumOperation numOperation = new ParserNumOperation(stackOperator, complex);
        ParserStackOperation stackOperation = new ParserStackOperation(stackOperator, numOperation);
        ParserVar var = new ParserVar(stackNumber, dictVar, stackOperation);
        ParserSplitter parserSplitter = new ParserSplitter(var);
        return new ParserFunction(parserSplitter, dictFunction);
    }
}