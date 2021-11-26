package Parser;

import Operations.Clear;
import Operations.Drop;
import Operations.Dup;
import Operations.Over;
import Operations.Swap;
import complexcalculator.StackOperator;

public class ParserStackOperation implements Parser{
    private final StackOperator stackOperator;
    private final Parser nextParser;

    public ParserStackOperation(StackOperator stackOperator, Parser nextParser) {
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
