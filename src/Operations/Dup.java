package Operations;

import Complex.Complex;
import complexcalculator.StackNumber;

public class Dup implements Operation0{
    @Override
    public void execute(StackNumber s) {
        Complex c = s.peekFirst();
        s.push(c);
    }
}