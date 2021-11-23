package Operations;

import Complex.Complex;

public class Arg implements Operation1 {

    @Override
    public Complex execute(Complex a) {
        return new Complex (Math.atan2(a.getImg(),a.getReal()), 0) ;
    }
    
}
