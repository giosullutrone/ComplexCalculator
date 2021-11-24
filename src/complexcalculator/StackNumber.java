package complexcalculator;

import Complex.Complex;
import java.util.LinkedList;
import java.util.List;

public class StackNumber extends LinkedList<Complex> {
    public List<String> getStack(int nElements) {
        List<String> listString = new LinkedList<>();
        
        if (this.isEmpty() || nElements==0) return listString;
        
        nElements = (this.size() < nElements) ? this.size() : nElements;
        for (Complex c: this.subList(0, nElements)) {
            listString.add(c.toString());
        }
        return listString;
    }
}