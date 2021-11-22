package Operations;

import calculatortest.StackNumber;

public class Clear implements Operation0{
    @Override
    public void execute(StackNumber s) {
        s.clear();
    }
}
