package Operations;

import Complex.Complex;

public class Sub implements Operation2{

    @Override
    public Complex execute(Complex a, Complex b) {
        return new Complex(a.getReal() - b.getReal(), a.getImg() - b.getImg());
    }
    
}
