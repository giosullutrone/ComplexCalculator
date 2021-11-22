package Operations;

import Complex.Complex;
import calculatortest.StackNumber;

public class Swap implements Operation0{
    @Override
    public void execute(StackNumber s) {
        Complex cFirst = s.pop();
        Complex cSecond = s.pop();
        
        s.push(cSecond);
        s.push(cFirst);
    }
}