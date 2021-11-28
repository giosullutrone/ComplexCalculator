package Parser;


import complexcalculator.StackNumber;
import complexcalculator.StackOperator;

public class ParserFactory {
    
    
    private final StackOperator stackOperator;
    private final StackNumber stackNumber;
    private final DictVar dict;
            
    public ParserFactory(StackNumber s) {
        this.dict = new DictVar();
        this.stackNumber = s;
        this.stackOperator = new StackOperator(s);
    }
    
    public Parser Chain(){
        ParserComplex complex = new ParserComplex(stackOperator);
        ParserNumOperation numOperation = new ParserNumOperation(stackOperator, complex);
        ParserStackOperation stackOperation = new ParserStackOperation(stackOperator, numOperation);
        ParserVar var = new ParserVar(stackNumber, dict, stackOperation);
        return var;
    }
}