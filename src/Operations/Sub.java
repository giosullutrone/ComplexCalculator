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
public class Sub implements Operation2{

    @Override
    public Complex execute(Complex a, Complex b) {
        return new Complex(a.getReal() - b.getReal(), a.getImg() - b.getImg());
    }
    
}
