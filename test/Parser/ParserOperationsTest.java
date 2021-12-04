package Parser;

import Operations.NumOperations.*;
import Operations.StackOperations.*;
import Complex.Complex;
import complexcalculator.*;

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
        ParserFactory factoryIstance = new ParserFactory(parseStackNumber, null); 
        StackOperator stackOperator= new StackOperator(stackNumber);
        Parser parser = factoryIstance.chain();
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
        
        test(new Exp(), "exp");
        
        test(new Log(), "log");
        
        test(new Sin(), "sin");
        
        test(new Cos(), "cos");
        
        test(new Tan(), "tan");
        
        test(new Asin(), "asin");
        
        test(new Acos(), "acos");
        
        test(new Atan(), "atan");
        
        test(new Conj(), "conj");
        
        test(new Pow(), "pow");
        
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
