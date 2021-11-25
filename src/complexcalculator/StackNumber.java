package complexcalculator;

import Complex.Complex;
import java.util.LinkedList;
import java.util.List;

/**
 * Class that extends a LinkedList of Complex with the addition of problem specific
 * functions.
 */
public class StackNumber extends LinkedList<Complex> {
    /**
     * Returns a list of strings containing the top user's specified elements from
     * the top of the stack, without removing them.
     * @param nElements: int that defines the number of elements to get from the
     * top of the stack
     * @return List of String containing the top nElements converted to string
     */
    public List<String> getStack(int nElements) {
        List<String> listString = new LinkedList<>();
        
        if (this.isEmpty() || nElements==0) return listString;
        
        nElements = (this.size() < nElements) ? this.size() : nElements;
        for (Complex c: this.subList(0, nElements)) {
            listString.add(c.toString());
        }
        return listString;
    }
    
    /**
     * Returns a list of strings containing all elements from the top of the 
     * stack, without removing them.
     * @return List of String containing the elements converted to string
     */
    public List<String> getStack() {
        List<String> listString = new LinkedList<>();
        
        if (this.isEmpty()) return listString;
        
        for (Complex c: this) {
            listString.add(c.toString());
        }
        return listString;
    }
}