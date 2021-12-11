package Parser;

/**
 * The ParserSplitterInterface provides one method to parse a sequence of 
 * operations (written in a single string)
 */
public interface ParserSplitterInterface {
    /**
     * Method used to parse a string containing multiple operations into a set
     * of specific actions executed in the provided order.
     * @param operations String to parse.
     */
    public void parse(String operations);
}