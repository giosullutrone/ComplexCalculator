package Operations;

import Complex.Complex;

public class Sub implements Operation2{
    /**
     * Method used to subtract two complex numbers
     * @param a: Complex number 
     * @param b: Complex number 
     * @return Complex number that contains the result after the operation has been executed
     */
    @Override
    public Complex execute(Complex a, Complex b) {
        return new Complex(a.getReal() - b.getReal(), a.getImg() - b.getImg());
    }
    
}
