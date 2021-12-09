package Operations.NumOperations;

import Complex.Complex;

public class Pow implements Operation2{

    /**
     * Method used to do complex power 
     * @param a: Complex base 
     * @param b: Complex exponent
     * @return Complex number that contains the result after the operation has been executed
     */
    
    @Override
    public Complex execute(Complex a, Complex b) {
    // get polar of base
	double r = new Mod().execute(a).getReal();
	double theta = new Arg().execute(a).getReal();
		
	Complex f1 = new Complex((Math.pow(r, b.getReal())*Math.pow(Math.E, -b.getImg()*theta)),0);
	Complex f2 = new Complex(Math.cos(b.getImg()*Math.log(r)+b.getReal()*theta),Math.sin(b.getImg()*Math.log(r)+b.getReal()*theta));
		
	return new Mul().execute(f1, f2);
    }
    
}
