package Operations.NumOperations;

import Complex.Complex;

public class Atan implements Operation1{
    /**
     * Method used to do the arctangent of a complex number 
     * @param a: Complex number 
     * @return Complex number that contains the result after the operation has been executed
     */
    
    @Override
    public Complex execute(Complex a) {
        //atan(z)  =  -i/2 * log( (i-z)/(i+z) );
        Complex result;
	result = new Div().execute(new Complex(-a.getReal(), 1.0 - a.getImg()), new Complex(a.getReal(), 1.0 + a.getImg()));
	result = new Complex(0.5 * new Arg().execute(result).getReal(), - 0.5 * Math.log(new Mod().execute(result).getReal()));
	return result;
    }
}
