package Operations;

import calculatortest.StackNumber;

public class Drop implements Operation0{
    @Override
    public void execute(StackNumber s) {
        s.pop();
    }
}