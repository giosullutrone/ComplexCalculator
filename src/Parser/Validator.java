package Parser;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
/**
 * Class that provide a method to isValid a user defined operation
 */
public class Validator {
    //Pattern of a complex number
    private static final Pattern pattern = Pattern.compile("\\s([+-]?\\d*\\.?\\d+)[+-](\\d*\\.?\\d+)j\\s|\\s([+-]?\\d*\\.?\\d+j)\\s|\\s([+-]?\\d*\\.?\\d+)\\s");
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
        
        return operations.stream().noneMatch(operation -> (!(dictFunction.contains(operation) || DictToken.contains(operation) || pattern.matcher(" "+operation+" ").find())));
        
    }
    
}

