package complexcalculator;

import Complex.Complex;
import Operations.Sqrt;
import Operations.Clear;
import Parser.ParserFactory;

public class CalculatorTest {
    public static void main(String[] args) {
        StackNumber s = new StackNumber();
        StackOperator m = new StackOperator(s);
        ParserFactory testing = new ParserFactory(m);
        //testing.parse("13+4j");
        
        int n_elements_to_show = 10;
        
        testing.parse("-10-5j");
        //m.execute(new Complex(10, 5));
        System.out.println(s.getStack(n_elements_to_show));
        
        m.execute(new Complex(-2, -2));
        System.out.println(s.getStack(n_elements_to_show));
        
        testing.parse("   +  ");
        System.out.println(s.getStack(n_elements_to_show));
        
        m.execute(new Sqrt());
        System.out.println(s.getStack(n_elements_to_show));
        
        m.execute(new Clear());
    }
}