package Parser;

import complexcalculator.StackNumber;
import complexcalculator.StackOperator;
import java.util.List;

public class Parser {
    private class Splitter {}
    
    private final StackNumber stackNumber;
    private final StackOperator stackOperator;
    private final Splitter splitter;
    
    public Parser(StackNumber s) {
        this.stackNumber = s;
        this.stackOperator = new StackOperator(stackNumber);
        this.splitter = new Splitter();
    }
    
    public void parse(List<String> ss) {}
    
    public void parse(String s) {}
}