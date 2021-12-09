package Operations.NumOperations;

import Complex.Complex;

public class Cos implements Operation1{
    /**
     * Method used to do the cosine of a complex number 
     * @param a: Complex number 
     * @return Complex number that contains the result after the operation has been executed
     */
    
    @Override
    public Complex execute(Complex a) {
        return new Complex((Math.exp(a.getImg())+Math.exp(-a.getImg()))/2*Math.cos(a.getReal()),-(Math.exp(a.getImg())-Math.exp(-a.getImg()))/2*Math.sin(a.getReal()));
    }
    
}
