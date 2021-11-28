package Operations.StackOperations;

import Complex.Complex;
import complexcalculator.StackNumber;

public class Dup implements Operation0{
    /**
     * Method used to duplicate the top element from the provided StackNumber.
     * Ex. stackNumber: [10, 10+1j] -> stackNumber: [10, 10, 10+1j]
     * @param stackNumber: StackNumber object to work with.
     */
    @Override
    public void execute(StackNumber stackNumber) {
        if (stackNumber.isEmpty()) return;
        Complex c = stackNumber.peekFirst();
        stackNumber.push(c);
    }
}