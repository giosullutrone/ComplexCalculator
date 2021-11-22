package complexcalculator;

import Complex.Complex;
import Operations.Operation2;
import Operations.Operation1;
import Operations.Operation0;

public class StackOperator {
    private final StackNumber stackNumber;
    
    public StackOperator(StackNumber stackNumber) {
        this.stackNumber = stackNumber;
    }
    
    // TODO: Is this necessary?
    public void execute(Complex c) {
        this.stackNumber.push(c);
    }
    
    public void execute(Operation0 op) {
        op.execute(this.stackNumber);
    }
    
    public void execute(Operation1 op) {
        Complex result = op.execute(this.stackNumber.pop());
        this.stackNumber.push(result);
    }
    
    public void execute(Operation2 op) {
        Complex result = op.execute(this.stackNumber.pop(),
                                    this.stackNumber.pop());
        this.stackNumber.push(result);
    }
}