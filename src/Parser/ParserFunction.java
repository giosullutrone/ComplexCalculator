
package Parser;

import AlertMessage.SyntaxException;
import java.util.LinkedList;

/**
 * Class that converts user's input into methods used to execute user defined operations
 */
public class ParserFunction implements Parser, ParserList{
    Parser nextParser;
    DictFunction dict;

    /**
     * Constructor of the ParserFunction class
     * @param nextParser next Parser of the chain
     * @param dict user defined operation dictionary
     */
    public ParserFunction(Parser nextParser, DictFunction dict) {
        this.dict = dict;
        this.nextParser = nextParser;
    }
    
    /**
     * Method used to parse a string into and operation, a complex number or
     * a user defined operation
     * @param s String to parse
     */
    @Override
    public void parse(String s) {
        s = s.trim();
        
        if(dict.keySet().contains(s))
            parse(Splitter.split(dict.get(s)));
        else if(s.contains(" ")){
            if(!Validator.isValid(s, dict.keySet())) throw new SyntaxException("Ueueeeeeee");
            parse(Splitter.split(s));}
        else
            nextParser.parse(s);
    }
    
    /**
     * Method used to parse a list of String into Strings and pass them to 
     * parse(String s) method.
     * @param operations list of String to parse in implemented operations
     */
    @Override
    public void parse(LinkedList<String> operations){
        operations.forEach(operation -> {
            parse(operation); 
        });
    }
}
