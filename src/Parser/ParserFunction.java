package Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that converts user's input into methods used to execute specific operations 
 * on the stack.
 */
public class ParserFunction implements Parser{
    private final DictFunction dictFunction;
    private final ParserList nextParser;

    /**
     * Constructor of ParserComplex class
     * @param dictFunction DictFuntion object to do its operations on.
     * @param nextParser next Parser of the chain
     */
    public ParserFunction(DictFunction dictFunction, ParserList nextParser) {
        this.dictFunction = dictFunction;
        this.nextParser = nextParser;
    }

    /**
     * Method used to parse a string to a single string of multiple StackOperations
     * Ex. possible output = "dup over 10+10j"
     * @param s String to parse
     */
    @Override
    public void parse(String s) {
        s = s.trim().toLowerCase();
        
        boolean replaced = true;
        
        while (replaced) {
            replaced = false;
            
            for (String key : this.dictFunction.keySet()) {
                String p = "\\b" + key + "\\b";

                Pattern pattern = Pattern.compile(p);
                Matcher matcher = pattern.matcher(s);

                if (matcher.find()) replaced = true;

                s = matcher.replaceAll(this.dictFunction.get(key));
            }
        }
        
        nextParser.parse(Splitter.split(s));
    }
}
