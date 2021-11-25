package Operations;

import Complex.Complex;

public class Arg implements Operation1 {
    /**
     * Method used to do the argument of a complex number 
     * @param a: Complex number 
     * @return Complex number that contains the result after the operation has been executed
     */
    @Override
    public Complex execute(Complex a) {
        return new Complex (Math.atan2(a.getImg(),a.getReal()), 0) ;
    }
    
}
