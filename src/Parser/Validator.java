package Parser;

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
        return operations.stream().noneMatch(operation -> (!(dictFunction.contains(operation) || DictToken.contains(operation))));
    }
    
}
