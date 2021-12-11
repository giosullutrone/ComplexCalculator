package Parser;

/**
 * The Parser interface provides one method to parse the associated string
 */
public interface Parser {
    /**
     * Method used to parse a string into a specific action.
     * @param s String to parse.
     */
    public void parse(String s);
}