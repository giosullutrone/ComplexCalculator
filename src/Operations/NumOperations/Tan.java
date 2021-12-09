package Operations.NumOperations;

import Complex.Complex;

public class Tan implements Operation1{
    /**
     * Method used to do the tangent of a complex number 
     * @param a: Complex number 
     * @return Complex number that contains the result after the operation has been executed
     */

    @Override
    public Complex execute(Complex a) {
        return new Div().execute(new Sin().execute(a), new Cos().execute(a));
    }
    
}
