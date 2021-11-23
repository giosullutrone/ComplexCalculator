package Operations;

import Complex.Complex;
import complexcalculator.StackNumber;

public class Dup implements Operation0{
    @Override
    public void execute(StackNumber stackNumber) {
        Complex c = stackNumber.peekFirst();
        if (c==null) return;
        stackNumber.push(c);
    }
}