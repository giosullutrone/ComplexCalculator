package Operations;

import complexcalculator.StackNumber;

public class Drop implements Operation0{
    @Override
    public void execute(StackNumber stackNumber) {
        stackNumber.pop();
    }
}