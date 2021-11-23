package Operations;

import Complex.Complex;

/**
 * An operation with two Complex inputs that returns a Complex result.
 * The Operation2 interface provides one method to execute the associated operation
 */
public interface Operation2{
    public Complex execute(Complex a, Complex b);
}