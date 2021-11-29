package Parser;

import Complex.Complex;
import Operations.NumOperations.Add;
import Operations.NumOperations.Sub;
import java.util.HashMap;

//TODO: change javadoc
/**
 * Class that provides methods used to execute specific operations on a provided 
 * variable and to save and restore a set of variables.
 */
public class DictFunction {
    private final HashMap<String, String> dict;
    
    /**
     * Constructor of DictVar class
     */
    public DictFunction() {
        this.dict = new HashMap<>();
    }
    
    /**
     * Method used to insert a value into the specified key.
     * @param key
     * @param value
     */
    public void put(String key, String value) {
        this.dict.put(key, value);
    }
    
    /**
     * Method used to get a value from the specified key.
     * @param key
     * @return Complex value associated with the key.
     */
    public String get(String key) {
        return this.dict.get(key);
    }
}