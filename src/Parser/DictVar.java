package Parser;

import Complex.Complex;
import Operations.NumOperations.Add;
import Operations.NumOperations.Sub;
import java.util.HashMap;

/**
 * Class that provides methods used to execute specific operations on a provided 
 * variable and to save and restore a set of variables.
 */
public class DictVar {
    private final HashMap<String, Complex> dict;
    private final HashMap<String, Complex> dictCopy;
    
    /**
     * Constructor of DictVar class
     */
    public DictVar() {
        this.dict = new HashMap<>();
        
        for (int i=0; i<26; i++) {
            this.dict.put(String.valueOf((char) ('a' + 1)), new Complex(0, 0));
        }
        
        this.dictCopy = new HashMap<>(this.dict);
    }
    
    /**
     * Method used to insert a value into the specified key.
     * @param key
     * @param value
     */
    public void put(String key, Complex value) {
        this.dict.put(key, value);
    }
    
    /**
     * Method used to get a value from the specified key.
     * @param key
     * @return Complex value associated with the key.
     */
    public Complex get(String key) {
        return this.dict.get(key);
    }
    
    /**
     * Method used to insert the result of the addition between value and the old
     * value associated with the key inside the same key.
     * @param key
     * @param value
     */
    public void add(String key, Complex value) {
        this.dict.put(key, new Add().execute(this.dict.get(key), value));
    }
    
    /**
     * Method used to insert the result of the difference between value and the old
     * value associated with the key inside the same key.
     * @param key
     * @param value
     */
    public void sub(String key, Complex value) {
        this.dict.put(key, new Sub().execute(this.dict.get(key), value));
    }
    
    /**
     * Method used to save the current variable dict.
     */
    public void save() {
        this.dictCopy.clear();
        this.dictCopy.putAll(this.dict);
    }
    
    /**
     * Method used to restore the previously saved variable dict.
     */
    public void restore() {
        this.dict.clear();
        this.dict.putAll(this.dictCopy);
    }
}