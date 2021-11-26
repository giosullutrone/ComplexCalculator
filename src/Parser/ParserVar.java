package Parser;

import AlertMessage.AlertMessage;
import complexcalculator.StackNumber;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserVar implements ParserInterface {
    private final StackNumber stackNumber;
    private final ParserInterface nextParser;
    private final VarDict varDict;

    public ParserVar(StackNumber stackNumber, VarDict varDict, ParserInterface nextParser) {
        this.stackNumber = stackNumber;
        this.varDict = varDict;
        this.nextParser = nextParser;
    }

    @Override
    public void parse(String s) {
        s = s.trim().toLowerCase();
        
        // pattern: both one of [<>+-] and a letter from a to z [a-z]
        String p = "([<>+-][a-z])";
        
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()) {
            String match = matcher.group();

            String operation = match.substring(0, 1);
            String letter = match.substring(1, 2);
            
            switch(operation) {
                case "<":
                    this.nextParser.parse(this.varDict.get(letter).toString());
                    return;
                case ">":
                    if (this.stackNumber.isEmpty()) new AlertMessage("Could not add value to dict, stack is empty");
                    this.varDict.put(letter, this.stackNumber.pop());
                    return;
                case "+":
                    if (this.stackNumber.isEmpty()) new AlertMessage("Could not add value to dict, stack is empty");
                    this.varDict.add(letter, this.stackNumber.pop());
                    return;
                case "-":
                    if (this.stackNumber.isEmpty()) new AlertMessage("Could not add value to dict, stack is empty");
                    this.varDict.sub(letter, this.stackNumber.pop());
                    return;
            }
        }
        
        switch(s) {
            case "save":
                this.varDict.save();
                return;
            case "restore":
                this.varDict.restore();
                return;
        }
        
        nextParser.parse(s);
    }
}