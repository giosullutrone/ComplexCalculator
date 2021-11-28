package Operations.StackOperations;

import Complex.Complex;
import complexcalculator.StackNumber;

public class Swap implements Operation0{
    /**
     * Method used to swap the top two elements from the provided StackNumber.
     * Ex. stackNumber: [10, 10+1j] -> stackNumber: [10+1j, 10]
     * @param stackNumber: StackNumber object to work with.
     */
    @Override
    public void execute(StackNumber stackNumber) {
        if (stackNumber.isEmpty() || stackNumber.size()==1) return;
        Complex cFirst = stackNumber.pop();
        Complex cSecond = stackNumber.pop();
        
        stackNumber.push(cFirst);
        stackNumber.push(cSecond);
    }
}