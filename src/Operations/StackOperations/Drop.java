package Operations.StackOperations;

import complexcalculator.StackNumber;

public class Drop implements Operation0{
    /**
     * Method used to remove the top element from the provided StackNumber.
     * Ex. stackNumber: [10, 10+1j] -> stackNumber: [10+1j]
     * @param stackNumber: StackNumber object to work with.
     */
    @Override
    public void execute(StackNumber stackNumber) {
        if (stackNumber.isEmpty()) return;
        stackNumber.pop();
    }
}