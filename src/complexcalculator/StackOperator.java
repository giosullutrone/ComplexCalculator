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
    public void executeOperation(Complex c) {
        this.stackNumber.push(c);
    }
    
    public void executeOperation(Operation0 op) {
        op.execute(this.stackNumber);
    }
    
    public void executeOperation(Operation1 op) {
        Complex result = op.execute(this.stackNumber.pop());
        this.stackNumber.push(result);
    }
    
    public void executeOperation(Operation2 op) {
        Complex result = op.execute(this.stackNumber.pop(),
                                    this.stackNumber.pop());
        this.stackNumber.push(result);
    }
}