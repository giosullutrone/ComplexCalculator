package Operations;

import Complex.Complex;
import complexcalculator.StackNumber;

public class Swap implements Operation0{
    @Override
    public void execute(StackNumber stackNumber) {
        Complex cFirst = stackNumber.pop();
        Complex cSecond = stackNumber.pop();
        
        stackNumber.push(cSecond);
        stackNumber.push(cFirst);
    }
}