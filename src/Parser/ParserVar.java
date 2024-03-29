package Parser;

import Dict.DictVar;
import AlertMessage.OperationException;
import AlertMessage.SyntaxException;
import Stack.StackNumber;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that converts user's input into methods used to execute specific operations 
 * on a provided variable and to save and restore a set of variables.
 */
public class ParserVar implements Parser{
    private final StackNumber stackNumber;
    private final Parser nextParser;
    private final DictVar varDict;

    /**
     * Constructor of ParserVar class
     * @param stackNumber StackNumber object to do its operations on.
     * @param varDict DictVar object to do its operations on.
     * @param nextParser next Parser of the chain
     */
    public ParserVar(StackNumber stackNumber, DictVar varDict, Parser nextParser) {
        this.stackNumber = stackNumber;
        this.varDict = varDict;
        this.nextParser = nextParser;
    }
    
    
    /**
     * Method used to parse a string into a complex or into an operation for the
     * DictVar
     * @param s string to parse
     * @throw SyntaxException if the parser string matches a dict operation but it contains more than two chars.
     * @throw OperationException if when passing ">+-" operations the stack is empty.
     */
    @Override
    public void parse(String s) {
        s = s.trim().toLowerCase();
        
        // If it finds a digit, pass it to the next parser.
        // Pattern: a digit
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            nextParser.parse(s);
            return;
        }
        
        // pattern: both one of [<>+-] and a letter from a to z [a-z]
        String p = "([!<>+-][a-z])";
        
        pattern = Pattern.compile(p);
        matcher = pattern.matcher(s);

        if (matcher.find()) {
            String match = matcher.group();
            
            if (s.length() > 2) {
                throw new SyntaxException("Variable not in the accepted range");
            }

            String operation = match.substring(0, 1);
            String letter = match.substring(1, match.length());
            
            switch(operation) {
                case "<":
                    this.nextParser.parse(this.varDict.get(letter).toString());
                    return;
                case ">":
                    if (this.stackNumber.isEmpty()) throw new OperationException("Could not save the variable, stack is empty.");
                    this.varDict.put(letter, this.stackNumber.pop());
                    return;
                case "+":
                    if (this.stackNumber.isEmpty()) throw new OperationException("Could not update the variable, stack is empty.");
                    this.varDict.add(letter, this.stackNumber.pop());
                    return;
                case "-":
                    if (this.stackNumber.isEmpty()) throw new OperationException("Could not update the variable, stack is empty.");
                    this.varDict.sub(letter, this.stackNumber.pop());
                    return;
                case "!":
                    this.varDict.delete(letter);
                    return;
                
            }
        }
        
        switch(s) {
            case "clc":
                this.varDict.deleteAll();
                return;
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
