package Operations;

import Complex.Complex;

public class Add implements Operation2 {
    /**
     * Method used to add two complex number 
     * @param a: Complex number 
     * @param b: Complex number 
     */
    @Override
    public Complex execute(Complex a, Complex b) {
        return new Complex(a.getReal() + b.getReal(), a.getImg() + b.getImg());
    }
}