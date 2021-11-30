/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations.NumOperations;

import Complex.Complex;

public class Exp implements Operation1{
    /**
     * Method used to do the exponential of a complex number 
     * @param a: Complex number 
     * @return Complex number that contains the result after the operation has been executed
     */
    @Override
    public Complex execute(Complex a) {
        return new Complex(Math.exp(a.getReal())*Math.cos(a.getImg()),Math.exp(a.getReal())*Math.sin(a.getImg()));
    }
    
}
