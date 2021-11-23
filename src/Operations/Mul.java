package Operations;

import Complex.Complex;

public class Mul implements Operation2{

    @Override
    public Complex execute(Complex a, Complex b) {
        return new Complex(a.getReal()*b.getReal()-a.getImg()*b.getImg(),a.getReal()*b.getImg()+a.getImg()*b.getReal());
    }
    
}
