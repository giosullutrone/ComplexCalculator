package Operations;

import Complex.Complex;
import complexcalculator.StackNumber;

public class Swap implements Operation0{
    @Override
    public void execute(StackNumber stackNumber) {
        if (stackNumber.isEmpty() || stackNumber.size()==1) return;
        Complex cFirst = stackNumber.pop();
        Complex cSecond = stackNumber.pop();
        
        stackNumber.push(cFirst);
        stackNumber.push(cSecond);
    }
}