package Operations;

import Complex.Complex;

public class Mod implements Operation1{
    /**
     * Method used to do the module of a complex number 
     * @param a: Complex number 
     * @return Complex number that contains the result after the operation has been executed
     */
    @Override
    public Complex execute(Complex a) {
        if (a.getReal()!=0 || a.getImg()!=0) {
            return new Complex (Math.sqrt(a.getReal()*a.getReal()+a.getImg()*a.getImg()), 0);
        } else {
            return new Complex (0,0);
        }
    }
    
}
