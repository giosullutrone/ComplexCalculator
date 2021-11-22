package complexcalculator;

import Complex.Complex;
import Operations.Add;
import Operations.Sqrt;
import Operations.Clear;

public class CalculatorTest {
    public static void main(String[] args) {
        StackNumber s = new StackNumber();
        StackOperator m = new StackOperator(s);
        
        int n_elements_to_show = 10;
        
        m.execute(new Complex(10, 5));
        System.out.println(s.getStack(n_elements_to_show));
        
        m.execute(new Complex(-2, -2));
        System.out.println(s.getStack(n_elements_to_show));
        
        m.execute(new Add());
        System.out.println(s.getStack(n_elements_to_show));
        
        m.execute(new Sqrt());
        System.out.println(s.getStack(n_elements_to_show));
        
        m.execute(new Clear());
    }
}