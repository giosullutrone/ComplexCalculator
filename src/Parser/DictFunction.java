package Parser;

import AlertMessage.OperationException;
import AlertMessage.SyntaxException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that provides methods used to execute specific operations on a provided 
 * function.
 */
public class DictFunction {
    private HashMap<String, String> dict;
    private DictToken tokens = new DictToken();
    private final String wrongInputAlert="Invalid set of operations";
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
        value = value.trim().replaceAll(" +", " ");
        if(!Validator.isValid(value, tokens)) throw new SyntaxException(wrongInputAlert);
        this.dict.put(key, value);
        this.tokens.update(this);
    }
    
    /**
     * Method used to get a value from the specified key.
     * @param key name of the function.
     * @throw OperationException if dict does not contain the key. 
     * @return String value associated with the key.
     */
    public String get(String key) {
        if (!this.dict.containsKey(key)) throw new OperationException("Could not get function, function does not exist.");
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
     * Method used to rename a function while handling all cascading changes.
     * @param key function to rename.
     * @throw OperationException if dict does not contain the key.
     * @param keyRenamed function's new name.
     */
    public void renameCascade(String key, String keyRenamed) {
        // Check if key is inside dict
        if (!this.dict.containsKey(key)) throw new OperationException("Could not rename the given function, function does not exist."); 
       
        // Rename function
        String v = this.dict.get(key);
        this.dict.remove(key);
        this.dict.put(keyRenamed, v);
        
        // Raname all occurances of that function inside the dict.
        for (String k: this.dict.keySet()) {
            String p = "\\b" + key + "\\b";

            Pattern pattern = Pattern.compile(p);
            Matcher matcher = pattern.matcher(this.dict.get(k));
            
            this.dict.put(k, matcher.replaceAll(keyRenamed));
        }
    }
    
    /**
     * Method used to remove a function while handling all cascading changes.
     * @throw OperationException if dict does not contain the key.
     * @param key function to remove.
     */
    public void removeCascade(String key) {
        // Check if key is inside dict
        if (!this.dict.containsKey(key)) throw new OperationException("Could not remove the given function, function does not exist.");
        
        // Remove function
        this.dict.remove(key);
        
        // Remove all entries inside the dict that use that function.
        List<String> keysToRemove = new LinkedList<>();
        
        for (String k: this.dict.keySet()) {
            String p = "\\b" + key + "\\b";

            Pattern pattern = Pattern.compile(p);
            Matcher matcher = pattern.matcher(this.dict.get(k));
            
            if (matcher.find()) keysToRemove.add(k);
        }
        
        for (String k: keysToRemove) {
            this.dict.remove(k);
        }
    }
    
    /**
     * Method used to check if a function is used inside another function.
     * @param key function to check for.
     * @return boolean indicating if a function is used inside another function.
     */
    public boolean isCalled(String key) {
        for (String value: this.dict.values()) {
            String p = "\\b" + key + "\\b";

            Pattern pattern = Pattern.compile(p);
            Matcher matcher = pattern.matcher(value);

            if (matcher.find()) return true;
        }
        return false;
    }
    
    public void clear() {
        this.dict.clear();
    }
    
    public void toFile(String filePath) throws IOException {
        FileOutputStream file = new FileOutputStream(filePath);
        try (ObjectOutputStream output = new ObjectOutputStream(file)) {
            output.writeObject(this.dict);
        }
    }
    
    public void fromFile(String filePath) throws IOException, ClassNotFoundException {
        FileInputStream fileStream = new FileInputStream(filePath);
        try (ObjectInputStream input = new ObjectInputStream(fileStream)) {
            this.dict = (HashMap<String, String>) input.readObject();
        }
    }
}