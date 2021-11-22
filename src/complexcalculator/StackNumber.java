package calculatortest;

import Complex.Complex;
import java.util.LinkedList;

public class StackNumber extends LinkedList<Complex> {
    public void addToStack(Complex e) {
        super.addFirst(e);
    }

    public String getStack(int n_elements) {
        n_elements = (this.size() < n_elements) ? this.size() : n_elements;
        return this.subList(0, n_elements).toString();
    }
}