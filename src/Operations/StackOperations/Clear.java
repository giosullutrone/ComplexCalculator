package Operations.StackOperations;

import Stack.StackNumber;

public class Clear implements Operation0{
    /**
     * Method used to clear the provided StackNumber.
     * Ex. stackNumber: [10, 10+1j] -> stackNumber: []
     * @param stackNumber: StackNumber object to work with.
     */
    @Override
    public void execute(StackNumber stackNumber) {
        stackNumber.clear();
    }
}
