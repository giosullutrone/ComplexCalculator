package Operations;

import Complex.Complex;

public class Sqrt implements Operation1 {
    /**
     * Method used to do the square root of a complex numbers
     * @param a: Complex number 
     */
    public Complex execute(Complex a) {
        double r=Math.sqrt(new Mod().execute(a).getReal());
        double theta=(new Arg().execute(a).getReal())/2;
        return new Complex(r*Math.cos(theta),r*Math.sin(theta));
    }
}