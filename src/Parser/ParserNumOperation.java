package Parser;

import Operations.NumOperations.*;
import Stack.StackOperator;

/**
 * Class that converts user's input into methods used to execute specific operations 
 * on the numbers of stack.
 */

public class ParserNumOperation implements Parser{
    private final StackOperator stackOperator;
    private final Parser nextParser;

    /**
     * Constructor of ParserComplex class
     * @param stackOperator StackOperator on the calculator's stack
     * @param nextParser next Parser of the chain
     */
    public ParserNumOperation(StackOperator stackOperator, Parser nextParser) {
        this.stackOperator = stackOperator;
        this.nextParser = nextParser;
    }
    
    /**
     * Method used to parse a string to a NumOperation
     * @param s String to parse
     */
    @Override
    public void parse(String s) {
        s = s.trim().toLowerCase();
        
        switch (s){
            case "+":
                this.stackOperator.execute(new Add());
                return;
            case "-":
                this.stackOperator.execute(new Sub());
                return;
            case "*":
                this.stackOperator.execute(new Mul());
                return;
            case "/":
                this.stackOperator.execute(new Div());
                return;
            case "sqrt":
                this.stackOperator.execute(new Sqrt());
                return;
            case "+-":
                this.stackOperator.execute(new Invert());
                return;
            case "conj":
                this.stackOperator.execute(new Conj());
                return;
                
            //Trascental  Functions
            case "mod":
                this.stackOperator.execute(new Mod());
                return;
            case "arg":
                this.stackOperator.execute(new Arg());
                return;
            case "exp":
                this.stackOperator.execute(new Exp());
                return;
            case "log":
                this.stackOperator.execute(new Log());
                return;
            case "pow":
                this.stackOperator.execute(new Pow());
                return;
            case "sin":
                this.stackOperator.execute(new Sin());
                return;
            case "cos":
                this.stackOperator.execute(new Cos());
                return;
            case "tan":
                this.stackOperator.execute(new Tan());
                return;
            case "asin":
                this.stackOperator.execute(new Asin());
                return;
            case "acos":
                this.stackOperator.execute(new Acos());
                return;
            case "atan":
                this.stackOperator.execute(new Atan());
                return;
        }
        
        nextParser.parse(s);
    }
}
