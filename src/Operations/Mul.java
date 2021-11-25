package Operations;

import Complex.Complex;

public class Mul implements Operation2{
    /**
     * Method used to multiply two complex numbers
     * @param a: Complex number 
     * @param b: Complex number 
     */
    @Override
    public Complex execute(Complex a, Complex b) {
        return new Complex(a.getReal()*b.getReal()-a.getImg()*b.getImg(),a.getReal()*b.getImg()+a.getImg()*b.getReal());
    }
    
}
