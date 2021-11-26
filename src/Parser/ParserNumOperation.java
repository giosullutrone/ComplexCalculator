package Parser;

import Operations.*;
import complexcalculator.StackOperator;

public class ParserNumOperation implements ParserInterface{
    private final StackOperator stackOperator;
    private final ParserInterface nextParser;

    public ParserNumOperation(StackOperator stackOperator, ParserInterface nextParser) {
        this.stackOperator = stackOperator;
        this.nextParser = nextParser;
    }

    @Override
    public void parse(String s) {
        s = s.trim().toLowerCase();
        
        switch (s){
            case "+":
                this.stackOperator.execute(new Add());
                return;
            case "-":
                this.stackOperator.execute(new Sub());
                return;
            case "*":
                this.stackOperator.execute(new Mul());
                return;
            case "/":
                this.stackOperator.execute(new Div());
                return;
        }
        
        nextParser.parse(s);
    }
}
