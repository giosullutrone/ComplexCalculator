package Stack;

import AlertMessage.OperationException;
import Complex.Complex;
import Operations.NumOperations.Operation2;
import Operations.NumOperations.Operation1;
import Operations.StackOperations.Operation0;

/**
 * Class that provides methods used to execute specific operations on a provided 
 * StackNumber object
 */
public class StackOperator {
    private final StackNumber stackNumber;
    
    /**
     * Constructor for the StackOperator class
     * @param stackNumber: StackNumber object to do its operations on
     */
    public StackOperator(StackNumber stackNumber) {
        this.stackNumber = stackNumber;
    }
    
    /**
     * Pushes its input into the top of the stack
     * @param c: Complex object to push
     */
    public void execute(Complex c) {
        this.stackNumber.push(c);
    }
    
    /**
     * Calls its input's execute method by passing the stack to the former
     * @param op: Operation0 object of whom to call the method
     */
    public void execute(Operation0 op) {
        op.execute(this.stackNumber);
    }
    
    /**
     * Calls its input's execute method by passing the top of the stack to the former
     * @param op: Operation1 object of whom to call the method
     * @throw OperationException if the operation takes more elements as input than the size of the stack.
     */
    public void execute(Operation1 op) {
        if (stackNumber.size() < 1) {
            throw new OperationException("Operation takes 1 elements, less than 1 were given.");
        }
        
        Complex result = op.execute(this.stackNumber.pop());
        this.stackNumber.push(result);
    }
    
    /**
     * Calls its input's execute method by passing the top two elements of the 
     * stack to the former
     * @param op: Operation2 object of whom to call the method
     * @throw OperationException if the operation takes more elements as input than the size of the stack.
     */
    public void execute(Operation2 op) {
        if (stackNumber.size() < 2) {
            throw new OperationException("Operation takes 2 elements, less than 2 were given.");
        }
        
        Complex result = op.execute(this.stackNumber.pop(),
                                    this.stackNumber.pop());
        this.stackNumber.push(result);
    }
}