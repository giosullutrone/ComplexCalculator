package Dict;

import AlertMessage.OperationException;
import AlertMessage.SyntaxException;
import Parser.Validator;
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
    /**
     * Constructor of DictFunction class
     */
    public DictFunction() {
        this.dict = new HashMap<>();
    }
    
    /**
     * Method used to check if function's name is valid.
     * @param key name to check.
     * @throws SyntaxException if not valid.
     */
    private void isKeyValid(String key) {
        if(key.contains(" ")) throw new SyntaxException("Function's name cannot contain spaces");
        if(Pattern.compile("[^a-zA-Z]").matcher(key).find()) throw new SyntaxException("Function's name cannot contain anything other than letters");
        if(key.length() < 2) throw new SyntaxException("Function's name cannot be shorter than 2 characters");
    }
    
    /**
     * Method used to insert a value into the specified key.
     * @param key name of the function.
     * @param value single string of multiple operations associated with the key.
     * @throws SyntaxException if key already exists or is a token
     */
    public void put(String key, String value) {
        key = key.trim();
        value = value.trim().replaceAll("\\s+", " ");
        if(DictToken.getCompleteDict(this).contains(key)) throw new SyntaxException("Function already exists");
        isKeyValid(key);
        
        this.replace(key, value);
    }
    
    /**
     * Method used to modify the value of a specified key.
     * @param key name of the function.
     * @param value single string of multiple operations associated with the key.
     * @throws SyntaxException if value is not valid or there is a recursion
     */
    public void replace(String key, String value) {
        value = value.trim().replaceAll("\\s+", " ");
        if(!Validator.isValid(value, this.keyList()) || (" "+value+" ").contains(" "+ key +" ")) throw new SyntaxException("Invalid set of operations");
        this.dict.put(key, value);
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
     * Method used to get a list of all keys.
     * @return LinkedList of all keys.
     */
    public List<String> keyList() {
        return new LinkedList<>(this.dict.keySet());
    }
    
    /**
     * Method used to rename a function while handling all cascading changes.
     * @param key function to rename.
     * @param keyRenamed function's new name.
     * @throw OperationException if dict does not contain the key.
     */
    public void renameCascade(String key, String keyRenamed) {
        // Check if key is inside dict
        if (!this.dict.containsKey(key)) throw new OperationException("Could not rename the given function, function does not exist.");
        isKeyValid(keyRenamed);
        
        // Rename function
        String v = this.dict.get(key);
        this.dict.remove(key);
        this.dict.put(keyRenamed, v);
        
        // Raname all occurances of that function inside the dict.
        for (String k: this.dict.keySet()) {
            String p = "\\b" + key + "\\b";

            Pattern pattern = Pattern.compile(p);
            Matcher matcher = pattern.matcher(this.dict.get(k));
            
            this.dict.replace(k, matcher.replaceAll(keyRenamed));
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
    
    /**
     * Method used to clear dict of all keys.
     */
    public void clear() {
        this.dict.clear();
    }
    
    /**
     * Method used to save the dict to file.
     * @param filePath
     * @throws IOException 
     */
    public void toFile(String filePath) throws IOException {
        FileOutputStream file = new FileOutputStream(filePath);
        try (ObjectOutputStream output = new ObjectOutputStream(file)) {
            output.writeObject(this.dict);
        }
    }
    
    /**
     * Method used to load dict from file.
     * @param filePath
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void fromFile(String filePath) throws IOException, ClassNotFoundException {
        FileInputStream fileStream = new FileInputStream(filePath);
        try (ObjectInputStream input = new ObjectInputStream(fileStream)) {
            this.dict = (HashMap<String, String>) input.readObject();
        }
    }
    
    
}