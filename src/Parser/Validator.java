package Parser;

import java.util.LinkedList;
/**
 * Class that provide a method to isValid a user defined operation
 * @author geral
 */
public class Validator {
    /**
     * Method used to check if all the operations in the input string are
     * implemented in the calculator
     * @param function string of user defined operation
     * @return true if function is valid, false if it doesn't
     */
    public static boolean isValid(String function, DictToken dict){
        LinkedList<String> operations = Splitter.split(function);
        return operations.stream().noneMatch(operation -> (!dict.contains(operation)));
    }
    
}
