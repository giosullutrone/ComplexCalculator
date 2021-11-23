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
public class Invert implements Operation1{

    @Override
    public Complex execute(Complex a) {
        return new Complex(a.getReal() * -1,a.getImg() * -1);   //invert img and real (?)
    }
    
}
