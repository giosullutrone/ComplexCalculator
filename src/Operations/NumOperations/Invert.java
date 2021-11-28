package Operations.NumOperations;

import Complex.Complex;

public class Invert implements Operation1{
    /**
     * Method used to invert a complex number 
     * @param a: Complex number 
     * @return Complex number that contains the result after the operation has been executed
     */
    @Override
    public Complex execute(Complex a) {
        return new Complex(a.getReal() * -1,a.getImg() * -1);
    }
    
}
