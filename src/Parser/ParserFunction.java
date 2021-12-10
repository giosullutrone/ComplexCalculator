
package Parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that converts user's input into methods used to execute user defined operations
 */
public class ParserFunction implements Parser {
    ParserSplitterInterface nextParser;
    DictFunction dictFunction;

    /**
     * Constructor of the ParserFunction class
     * @param nextParser next Parser of the chain
     * @param dictFunction user defined operation dictionary
     */
    public ParserFunction(ParserSplitterInterface nextParser, DictFunction dictFunction) {
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
        
        boolean replaced;
        do {
            // Set replaced to false so that if no match are found the loop will stop
            replaced = false;
            // For every key in the dict (or in other words for each function's name)
            for (String key : this.dictFunction.keySet()) {
                // The pattern to replace must be exact word (substring not accepted)
                String p = "\\b" + key + "\\b";

                Pattern pattern = Pattern.compile(p);
                Matcher matcher = pattern.matcher(s);

                // If the exact word has been found, do another loop after this one
                // in case the function is used inside another function
                if (matcher.find()) replaced = true;

                // Replace all exact occurences of a function with its corresponding
                // set of operations.
                // Ex. dict = {"test": "dup +"}
                //     "test tested" -> "dup + tested"
                s = matcher.replaceAll(this.dictFunction.get(key));
            }
        } while (replaced);
        
        // Once all functions have been replaced, pass the string to an object 
        // that implements ParserSplitterInterface
        nextParser.parse(s);
    }
}
