package Operations.NumOperations;

import Complex.Complex;

/**
 * An operation with one Complex input that returns a Complex result.
 * The Operation1 interface provides one method to execute the associated operation
 */
public interface Operation1{
    /**
     * Method used to execute a specific operation on the provided Complex input.
     * @param a: Complex object used for the operation.
     * @return : Complex result
     */
    public Complex execute(Complex a);
}