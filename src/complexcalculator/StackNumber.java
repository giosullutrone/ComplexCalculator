package complexcalculator;

import Complex.Complex;
import java.util.LinkedList;
import java.util.List;

public class StackNumber extends LinkedList<Complex> {
    public List<String> getStack(int n_elements) {
        n_elements = (this.size() < n_elements) ? this.size() : n_elements;
        List<String> listString = new LinkedList<>();
        for (Complex c: this.subList(0, n_elements)) {
            listString.add(c.toString());
        }
        return listString;
    }
}