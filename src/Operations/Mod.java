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
public class Mod implements Operation1{
    
    @Override
    public Complex execute(Complex a) {
        if (a.getReal()!=0 || a.getImg()!=0) {
            return new Complex (Math.sqrt(a.getReal()*a.getReal()+a.getImg()*a.getImg()), 0);
        } else {
            return new Complex (0,0);
        }
    }
    
}
