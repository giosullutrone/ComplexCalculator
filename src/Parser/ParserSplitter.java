package Parser;

/**
 * Class that lets you parse a sequence of operations (written in a single string)
 */
public class ParserSplitter implements ParserSplitterInterface{
    Parser nextParser;

    /**
     * Constructor of the ParserSplitter class
     * @param nextParser next Parser of the chain
     */
    public ParserSplitter(Parser nextParser) {
        this.nextParser = nextParser;
    }
    
    /**
     * Method used to parse a sequence of operations (written in a single line) into
     * multiple operations, splitting and parsing them in the provided order
     * @param s String to parse. 
     * Ex. s="10+10j dup +" will result in three calls => "10+10j", "dup" and "+"
     */
    @Override
    public void parse(String s) {
        Splitter.split(s).forEach(operation -> {
            this.nextParser.parse(operation);
        });
    }
}