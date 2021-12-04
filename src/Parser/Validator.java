package Parser;

import java.util.LinkedList;
import java.util.List;
/**
 * Class that provide a method to isValid a user defined operation
 */
public class Validator {
    /**
     * Method used to check if all the operations in the input string are
     * implemented in the calculator
     * @param function string of user defined operation
     * @param dictFunction
     * @return true if function is valid, false if it doesn't
     */
    public static boolean isValid(String function, List<String> dictFunction){
        LinkedList<String> operations = Splitter.split(function);
        
        return ((operations.stream().noneMatch(operation -> (!DictToken.contains(operation)))) 
                || (operations.stream().noneMatch(operation -> (!dictFunction.contains(function)))));
    }
    
}
