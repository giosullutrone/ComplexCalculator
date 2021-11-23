package Operations;

import complexcalculator.StackNumber;

/**
 * An operation with no defined inputs, but with direct access to the stackNumber 
 * it should work on.
 * The Operation0 interface provides one method to execute the associated operation
 */
public interface Operation0{
    public void execute(StackNumber stackNumber);
}