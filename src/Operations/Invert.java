package Operations;

import Complex.Complex;

public class Invert implements Operation1{

    @Override
    public Complex execute(Complex a) {
        return new Complex(a.getReal() * -1,a.getImg() * -1);   //invert img and real (?)
    }
    
}
