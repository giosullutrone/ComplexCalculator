package Parser;

import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * Class that provides a method used to split a string in a list of single string
 */
public class Splitter {
    /**
     * Method used to split the string in a list of single strings
     * @param function string to split
     * @return list of strings
     */
    public LinkedList<String> split(String function){
        LinkedList<String> operationList = new LinkedList<>();
        StringTokenizer iterator = new StringTokenizer(function);
        while (iterator.hasMoreTokens())
            operationList.add(iterator.nextToken());
        return operationList;
    }
    
    
    
    
    
}

