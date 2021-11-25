package Parser;

import AlertMessage.AlertMessage;
import Complex.*;
import complexcalculator.StackOperator;
import Operations.*;
import java.util.List;
public class Parser {
    
    
    private final StackOperator stackOperator;
    private final String stringRegex = "(?=[+-])";
    private final String wrongInputAlert="Wrong Input!!!";

    
    public Parser(StackOperator s) {
        this.stackOperator = s;
    }
    
    public void parse(List<String> ss) {
        ss.forEach(string -> {
            parse(string);
        });
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
    
    
    public void parse(String s) {
        s = s.trim().toLowerCase();
        //OPERATIONS BLOCK
        if(s.compareTo("+")==0){
            this.stackOperator.execute(new Add());
            return;
        }
        if(s.compareTo("-")==0){
            this.stackOperator.execute(new Sub());
            return;
        }
        if(s.compareTo("*")==0){
            this.stackOperator.execute(new Mul());
            return;
        }
        if(s.compareTo("/")==0){
            this.stackOperator.execute(new Div());
            return;
        }
        // TMP CLEAR PARSER
        if(s.compareTo("clear")==0){
            this.stackOperator.execute(new Clear());
            return;
        }
        
        //COMPLEX BLOCK
        
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