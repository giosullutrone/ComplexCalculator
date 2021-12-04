
package Parser;

import java.util.LinkedList;

public class ParserFunction implements Parser, ParserList{
    Parser nextParser;
    DictFunction dict;

    public ParserFunction(Parser nextParser, DictFunction dict) {
        this.dict = dict;
        this.nextParser = nextParser;
    }
    
    @Override
    public void parse(String s) {
        s = s.trim();
        if(dict.keySet().contains(s))
            parse(Splitter.split(dict.get(s)));
        else{
            nextParser.parse(s);
        }
    }
    
    /**
     * Method used to parse a list of String into Strings and pass them to 
     * parse(String s) method.
     * @param operations list of String to parse in implemented operations
     */
    public void parse(LinkedList<String> operations){
        operations.forEach(operation -> {
            parse(operation); 
        });
    }
}
