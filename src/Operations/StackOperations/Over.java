package Operations.StackOperations;

import Complex.Complex;
import complexcalculator.StackNumber;

public class Over implements Operation0{
    /**
     * Method used to duplicate the second element from the top of the provided 
     * StackNumber.
     * Ex. stackNumber: [10, 10+1j] -> stackNumber: [10+1j, 10, 10+1j]
     * @param stackNumber: StackNumber object to work with.
     */
    @Override
    public void execute(StackNumber stackNumber) {
        if (stackNumber.isEmpty() || stackNumber.size()==1) return;
        Complex cSecond = stackNumber.get(1);
        stackNumber.push(cSecond);
    }
}