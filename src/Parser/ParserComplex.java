package Parser;

import AlertMessage.SyntaxException;
import Complex.Complex;
import complexcalculator.StackOperator;

/**
 * Class that converts user's input into a Complex object
 */
public class ParserComplex implements Parser{
    private final StackOperator stackOperator;
    private final String stringRegex = "(?=[+-])";
    private final String wrongInputAlert="Wrong Input!!!";

    /**
     * Constructor of ParserComplex class
     * @param stackOperator StackOperator on the calculator's stack
     */
    public ParserComplex(StackOperator stackOperator) {
        this.stackOperator = stackOperator;
    }

    /**
     * Method used to parse two string in a Complex object
     * @param real String to parse to real part of Complex
     * @param img String to parse to img part of Complex
     */
    
    public void parse(String real, String img) {
        try{
            Double realDouble = Double.parseDouble(real);
            Double imgDouble = Double.parseDouble(img);
            this.stackOperator.execute(new Complex(realDouble, imgDouble));
        } catch(NumberFormatException e){
            throw new SyntaxException(wrongInputAlert);
        }
    }
    
    /**
     * Method used to parse a string in a Complex object
     * @param s string to parse
     */
    @Override
    public void parse(String s) {
        s = s.trim().toLowerCase();
        
        String[] parts= s.split(stringRegex);
        for(String remove : parts){
            remove = remove.replace("+", "");
        }
        switch(parts.length){
            case 1:
                if(parts[0].contains("j"))
                    parse("0", parts[0].replace("j", ""));
                else
                    parse(parts[0], "0");
                break;
            case 2:
                if(parts[0].contains("j"))
                    parse(parts[1], parts[0].replace("j", ""));
                else if(parts[1].contains("j"))
                    parse(parts[0], parts[1].replace("j", ""));
                else
                    throw new SyntaxException(wrongInputAlert);
                break;
            default:
                throw new SyntaxException(wrongInputAlert);
                //break;
        }
        
    }
}
