package Operations;

import Complex.Complex;

public class Sqrt implements Operation1 {
    public Complex execute(Complex a) {
        return new Complex(Math.sqrt(a.getReal()), 0);
    }
}