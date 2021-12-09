package Parser;

import AlertMessage.OperationException;
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
            this.dict.put(String.valueOf((char) ('a' + i)), null);
        }
        
        this.dictCopy = new HashMap<>(this.dict);
    }
    
    /**
     * Method used to insert a value into the specified key.
     * @param key
     * @throw OperationException if key is outside the accepted range of [a-z].
     * @param value
     */
    public void put(String key, Complex value) {
        if (!this.dict.containsKey(key)) throw new OperationException("Could not save variable, variable not in the accepted range");
        this.dict.put(key, value);
    }
    
    /**
     * Method used to get a value from the specified key.
     * @param key
     * @throw OperationException if key is outside the accepted range of [a-z].
     * @throw OperationException if key has not been previously written to.
     * @return Complex value associated with the key.
     */
    public Complex get(String key) {
        if (!this.dict.containsKey(key)) throw new OperationException("Could not load variable, variable not in the accepted range");
        if (this.dict.get(key)==null) throw new OperationException("Could not load variable, no value has been assigned to the variable");
        return this.dict.get(key);
    }
    
    /**
     * Method used to insert the result of the addition between value and the old
     * value associated with the key inside the same key.
     * @param key
     * @param value
     * @throw OperationException if key has not been previously written to.
     */
    public void add(String key, Complex value) {
        if (this.dict.get(key)==null) throw new OperationException("Could not update variable, no value has been assigned to the variable");
        this.dict.put(key, new Add().execute(this.dict.get(key), value));
    }
    
    /**
     * Method used to insert the result of the difference between value and the old
     * value associated with the key inside the same key.
     * @param key
     * @param value
     * @throw OperationException if key has not been previously written to.
     */
    public void sub(String key, Complex value) {
        if (this.dict.get(key)==null) throw new OperationException("Could not update variable, no value has been assigned to the variable");
        this.dict.put(key, new Sub().execute(this.dict.get(key), value));
    }

    /**
     * Method used to delete the value associated with the key.
     * @param key
    */
    public void delete(String key) {
        this.dict.put(key, null);
    }

    /**
     * Method used to delete the value of all associated with the key.
     */
    public void deleteAll() {
        for(String key: this.dict.keySet()){
            this.dict.put(key, null);
        }
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