package Parser;

import Operations.Clear;
import complexcalculator.StackOperator;

public class ParserStackOperation implements ParserInterface{
    private final StackOperator stackOperator;
    private final ParserInterface nextParser;

    public ParserStackOperation(StackOperator stackOperator, ParserInterface nextParser) {
        this.stackOperator = stackOperator;
        this.nextParser = nextParser;
    }

    @Override
    public void parse(String s) {
        s = s.trim().toLowerCase();
        
        switch(s) {
            case "clear":
            this.stackOperator.execute(new Clear());
            return;
        }
        
        nextParser.parse(s);
    }
}
