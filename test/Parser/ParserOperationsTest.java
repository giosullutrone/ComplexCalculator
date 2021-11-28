package Parser;

import Operations.NumOperations.Operation2;
import Operations.NumOperations.Operation1;
import Operations.StackOperations.Operation0;
import Operations.StackOperations.Swap;
import Operations.StackOperations.Over;
import Operations.StackOperations.Dup;
import Operations.StackOperations.Drop;
import Operations.StackOperations.Clear;
import Operations.NumOperations.Arg;
import Operations.NumOperations.Mod;
import Operations.NumOperations.Invert;
import Operations.NumOperations.Sqrt;
import Operations.NumOperations.Div;
import Operations.NumOperations.Mul;
import Operations.NumOperations.Sub;
import Operations.NumOperations.Add;
import Complex.Complex;
import complexcalculator.StackNumber;
import complexcalculator.StackOperator;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParserOperationsTest {
    
    public ParserOperationsTest() {
    }
    
    /**
     * @param operationObj
     * @param operationString
    */ 
    public void test(Object operationObj, String operationString) {
        // Feedback
        System.out.println("Testing: Parser("+ operationObj.getClass().getSimpleName() +")");
        
        // Var initialization
        StackNumber stackNumber = new StackNumber(), parseStackNumber = new StackNumber();
        ParserFactory factoryIstance = new ParserFactory(parseStackNumber); 
        StackOperator stackOperator= new StackOperator(stackNumber);
        Parser parser = factoryIstance.Chain();
        Operation0 op0;
        Operation1 op1;
        Operation2 op2;
        Complex num1 = new Complex(10, 10), num2 =new Complex(10, -10);
        
        //Testing
        stackOperator.execute(num1);
        stackOperator.execute(num2);
        
        // Operation selection
        switch (operationObj.getClass().getInterfaces()[0].getSimpleName()){
            case "Operation0":
                op0 = (Operation0)operationObj;
                stackOperator.execute(op0);
                break;
            case "Operation1":
                op1 = (Operation1)operationObj;
                stackOperator.execute(op1);
                break;
            case "Operation2":
                op2 = (Operation2)operationObj;
                stackOperator.execute(op2);
                break;
            default:
                assertTrue(false);
                break;
        }
        parser.parse(num1.toString());
        parser.parse(num2.toString());
        parser.parse(operationString);
        assertEquals(stackNumber ,parseStackNumber);
        
    }
    
    @Test 
    public void testNumOperations(){
        
        test(new Add(), "+");
        
        test(new Sub(), "-");
        
        test(new Mul(), "*");
        
        test(new Div(), "/");
        
        test(new Sqrt(), "sqrt");
        
        test(new Invert(), "+-");
        
        test(new Mod(), "mod");
        
        test(new Arg(), "arg");     
        
    }
    
    @Test 
    public void testStackOperations(){
        
        test(new Clear(), "clear");
        
        test(new Drop(), "drop");
        
        test(new Dup(), "dup");
        
        test(new Over(), "over");
        
        test(new Swap(), "swap");
        
    }
    
    
}
