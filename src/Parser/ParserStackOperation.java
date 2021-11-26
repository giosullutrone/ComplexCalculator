package Parser;

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
            case "save":
                return;
            case "restore":
                return;
        }
        
        nextParser.parse(s);
    }
}
