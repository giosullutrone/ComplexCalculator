package Operations;

import Complex.Complex;
import calculatortest.StackNumber;

public class Over implements Operation0{
    @Override
    public void execute(StackNumber s) {
        Complex cSecond = s.get(1);
        s.push(cSecond);
    }
}