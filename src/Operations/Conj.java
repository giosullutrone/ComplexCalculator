/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import Complex.Complex;

/**
 *
 * @author francesca
 */
public class Conj implements Operation1{
    /**
     * Method used to do the conjugate of a complex number 
     * @param a: Complex number 
     */
    @Override
    public Complex execute(Complex a) {
        return new Complex(a.getReal(), -a.getImg());
    }
    
}