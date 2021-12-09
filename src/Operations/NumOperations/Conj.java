package Operations.NumOperations;

import Complex.Complex;

public class Conj implements Operation1{
    /**
     * Method used to do the conjugate of a complex number 
     * @param a: Complex number 
     * @return Complex number that contains the result after the operation has been executed
     */
    @Override
    public Complex execute(Complex a) {
        return new Complex(a.getReal(), - a.getImg());
    }
    
}
