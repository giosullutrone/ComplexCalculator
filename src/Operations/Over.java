package Operations;

import Complex.Complex;
import complexcalculator.StackNumber;

public class Over implements Operation0{
    @Override
    public void execute(StackNumber stackNumber) {
        Complex cSecond = stackNumber.get(1);
        stackNumber.push(cSecond);
    }
}