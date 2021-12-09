package Operations.NumOperations;

import Complex.Complex;

public class Acos implements Operation1{
    /**
     * Method used to do the arccosine of a complex number 
     * @param a: Complex number 
     * @return Complex number that contains the result after the operation has been executed
     */
    
    @Override
    public Complex execute(Complex a) {
        //acos(z)  =  -i * log(z + i * sqrt(1 - z*z));
        Complex result;
        
	result = new Sqrt().execute(new Complex(1.0 - (new Mul().execute(a, a).getReal()), 0.0 - (new Mul().execute(a, a).getImg())));
        result = new Complex(a.getReal() - result.getImg(),a.getImg() + result.getReal());
	result = new Complex(new Arg().execute(result).getReal(), - Math.log(new Mod().execute(result).getReal()));
	return result;
    } 
}
