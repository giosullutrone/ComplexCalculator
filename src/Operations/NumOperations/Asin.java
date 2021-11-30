/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations.NumOperations;

import Complex.Complex;

public class Asin implements Operation1{
    /**
     * Method used to do the arcsine of a complex number 
     * @param a: Complex number 
     * @return Complex number that contains the result after the operation has been executed
     */
    
    @Override
    public Complex execute(Complex a) {
        //asin(z)  =  -i * log(i*z + sqrt(1 - z*z);
        Complex result;
	double tempRe, tempIm;
        
        tempRe =  1.0 - ( (a.getReal()*a.getReal()) - (a.getImg()*a.getImg()) );
	tempIm =  0.0 - ( (a.getReal()*a.getImg()) + (a.getImg()*a.getReal()) );

	result =  new Complex(tempRe, tempIm);
	result = new Sqrt().execute(result);
	
	tempRe = -a.getImg();
	tempIm =  a.getReal();
	
        result = new Complex(result.getReal() + tempRe, result.getImg() + tempIm );
	
	tempRe = Math.log(new Mod().execute(result).getReal());
	tempIm = new Arg().execute(result).getReal();
	
        result = new Complex(tempIm, -tempRe);
	
	return result;
    }
    
}
