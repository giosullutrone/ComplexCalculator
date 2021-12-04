package Parser;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Class that provides methods used to execute specific operations on a provided 
 * variable and to save and restore a set of variables.
 */
public class DictToken {
    private static final List<String> numDict = Arrays.asList("+", "-", "*", "/", "sqrt", "+-", "conj");
    private static final List<String> trasDict = Arrays.asList("mod", "arg", "exp", "log", "pow", "sin", "cos", "tan", "asin", "acos", "atan");
    private static final List<String> stackDict = Arrays.asList("clear", "drop", "dup", "over", "swap");
    private LinkedList<String> dict = new LinkedList<>();
    
    /**
     * Constructor of DictToken class
     */
    public DictToken() {
        dict.addAll(numDict);
        dict.addAll(trasDict);
        dict.addAll(stackDict);
    }
    
    /**
     * Method used to remove all User defined operation from the dict
     */
    public void clear(){
     dict.clear();
     this.dict = new DictToken().getDict();
    }
    
    /**
     * Method used to update User defined operations from the dictFunction
     */
    public void update(DictFunction functions){
        this.clear();
        for (String function : functions.keySet())
            dict.add(function);
    }
    
    /**
     * Method used to remove a single operation from the dict
     * @param toRemove operation to remove
     */
    public void remove(String toRemove){
        dict.remove(toRemove);
    }
    
    /**
     * Method used to check if the dict contains an operation
     * @param check operation to fin into the dict
     * @return true if dict contains the operation, false if it doesn't
     */
    public boolean contains(String check){
        return dict.contains(check);
    }
    
    /**
     * Method used to get the dict from the DictToken istance
     * @return list of all the operations
     */
    public LinkedList<String> getDict() {
        return dict;
    }
    
    /**
     * Method used to format the output of DictToken
     * @return example: "Avaible operations are : + | - | /"
     */
    @Override
    public String toString() {
        String toReturn = "Avaible operations are : ";
        for (String operation : dict){
            toReturn += " "+operation;
            if(!dict.getLast().equals(operation))
                toReturn += " |";
            }
        return toReturn;
    }
    
    
}