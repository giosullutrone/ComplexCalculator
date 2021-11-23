package Operations;

import Complex.Complex;

public class Sqrt implements Operation1 {
    public Complex execute(Complex a) {
        double r=Math.sqrt(new Mod().execute(a).getReal());
        double theta=(new Arg().execute(a).getReal())/2;
        return new Complex(r*Math.cos(theta),r*Math.sin(theta));
    }
}