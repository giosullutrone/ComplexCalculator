package Parser;

import Complex.Complex;
import Operations.NumOperations.Add;
import Operations.NumOperations.Sub;
import java.util.HashMap;

public class VarDict {
    private final HashMap<String, Complex> dict;
    private final HashMap<String, Complex> dictCopy;
    
    public VarDict() {
        this.dict = new HashMap<>();
        
        for (int i=0; i<26; i++) {
            this.dict.put(String.valueOf((char) ('a' + 1)), new Complex(0, 0));
        }
        
        this.dictCopy = new HashMap<>(this.dict);
    }
    
    public void put(String key, Complex value) {
        this.dict.put(key, value);
    }
    
    public Complex get(String key) {
        return this.dict.get(key);
    }
    
    public void add(String key, Complex value) {
        this.dict.put(key, new Add().execute(this.dict.get(key), value));
    }
    
    public void sub(String key, Complex value) {
        this.dict.put(key, new Sub().execute(this.dict.get(key), value));
    }
    
    public void save() {
        this.dictCopy.clear();
        this.dictCopy.putAll(this.dict);
    }
    
    public void restore() {
        this.dict.clear();
        this.dict.putAll(this.dictCopy);
    }
}