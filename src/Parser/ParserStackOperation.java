package Parser;

import Operations.Clear;
import Operations.Drop;
import Operations.Dup;
import Operations.Over;
import Operations.Swap;
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
            case "Clear":
                stackOperator.execute(new Clear());
                return;
            case "Drop":
                stackOperator.execute(new Drop());
                return;
            case "Dup":
                stackOperator.execute(new Dup());
                return;
            case "Over":
                stackOperator.execute(new Over());
                return;
            case "Swap":
                stackOperator.execute(new Swap());
                return;
        }
        
        nextParser.parse(s);
    }
}
