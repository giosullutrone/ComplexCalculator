package Parser;

import java.util.HashMap;

/**
 * Class that provides methods used to execute specific operations on a provided 
 * function.
 */
public class DictFunction {
    private final HashMap<String, String> dict;
    
    /**
     * Constructor of DictFunction class
     */
    public DictFunction() {
        this.dict = new HashMap<>();
    }
    
    /**
     * Method used to insert a value into the specified key.
     * @param key name of the function.
     * @param value single string of multiple operations associated with the key.
     */
    public void put(String key, String value) {
        this.dict.put(key, value);
    }
    
    /**
     * Method used to get a value from the specified key.
     * @param key name of the function.
     * @return String value associated with the key.
     */
    public String get(String key) {
        return this.dict.get(key);
    }
    
    /**
     * Method used to get a set of all keys.
     * @return iterable of all keys.
     */
    public Iterable<String> keySet() {
        return this.dict.keySet();
    }
    
    /**
     * Method used to check if a .
     * @return boolean indicating if a function is used inside another function.
     */
    public boolean isUsed() {
        return false;
    }
}