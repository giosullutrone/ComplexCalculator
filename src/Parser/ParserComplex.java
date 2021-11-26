package Parser;

import AlertMessage.AlertMessage;
import Complex.Complex;
import complexcalculator.StackOperator;

public class ParserComplex implements Parser{
    private final StackOperator stackOperator;
    private final String stringRegex = "(?=[+-])";
    private final String wrongInputAlert="Wrong Input!!!";

    public ParserComplex(StackOperator stackOperator) {
        this.stackOperator = stackOperator;
    }

    public void parse(String real, String img) {
        try{
            Double realDouble = Double.parseDouble(real);
            Double imgDouble = Double.parseDouble(img);
            this.stackOperator.execute(new Complex(realDouble, imgDouble));
        } catch(NumberFormatException e){
            new AlertMessage(wrongInputAlert);
        }
    }
    
    
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
                    new AlertMessage(wrongInputAlert);
                break;
            default:
                new AlertMessage(wrongInputAlert);
                break;
        }
        
    }
}
