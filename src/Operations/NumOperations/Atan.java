/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
	double tempRe, tempIm;
        
        result =  new Complex(-a.getReal(), 1.0 - a.getImg());
        tempRe =  a.getReal();
	tempIm =  1.0 + a.getImg();
        
        result = new Div().execute(result, new Complex(tempRe, tempIm));
	
	tempRe = Math.log(new Mod().execute(result).getReal());
	tempIm = new Arg().execute(result).getReal();
	
        result = new Complex(0.5 * tempIm,-0.5 * tempRe);
	
	return result;
    }
    
}
