package Operations.NumOperations;

import Complex.Complex;

public class Log implements Operation1 {
    
    /**
     * Method used to do the logarithm of a complex number 
     * @param a: Complex number 
     * @return Complex number that contains the result after the operation has been executed
     */
    @Override
    public Complex execute(Complex a) {
        return new Complex(Math.log(new Mod().execute(a).getReal()),new Arg().execute(a).getReal());
    }
    
}
