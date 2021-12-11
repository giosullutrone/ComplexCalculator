package Parser;

import AlertMessage.SyntaxException;
import java.util.LinkedList;
import java.util.List;
/**
 * Class that provide a method to isValid a user defined operation
 */
public class Validator {
    /**
     * Method used to check if all the operations in the input string are
     * implemented in the calculator (as default or user defined operations)
     * @param function string of user defined operation
     * @param dictFunction Dictionary of all user defined operations
     * @return true if function is valid, false if it doesn't
     */
    public static boolean isValid(String function, List<String> dictFunction){
        if(function.replaceAll(" +", "").isEmpty()) return false;
        LinkedList<String> operations = Splitter.split(function);

        return operations.stream().allMatch(operation -> (dictFunction.contains(operation) || DictToken.contains(operation) || Validator.isValidComplex(operation)));
    }
    
    /**
     * Private method used to check whether a string is a valid Complex.
     * @param complex string to check.
     * @return boolean corresponding to the result of the test.
     */
    private static boolean isValidComplex(String complex) {
        try {
            // Try to parse string to Complex
            ParserComplex parser = new ParserComplex(null);
            parser.parse(complex);
        } catch(SyntaxException e) {
            // If it throws a SyntaxException it means that the parser could not
            // convert the string to Complex therefore it is not a valid value
            return false;
        } catch(Exception e) {}
        // Else return true because the operation was successfull
        return true;
    }
}

