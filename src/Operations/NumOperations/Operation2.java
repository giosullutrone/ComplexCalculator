package Operations.NumOperations;

import Complex.Complex;

/**
 * An operation with two Complex inputs that returns a Complex result.
 * The Operation2 interface provides one method to execute the associated operation
 */
public interface Operation2{
    /**
     * Method used to execute a specific operation on the provided Complex inputs.
     * @param a: Complex object used for the operation.
     * @param b: Complex object used for the operation.
     * @return : Complex result
     */
    public Complex execute(Complex a, Complex b);
}