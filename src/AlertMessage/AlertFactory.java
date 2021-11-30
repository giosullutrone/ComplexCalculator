package AlertMessage;

public class AlertFactory {
    public static AlertMessage handle(OperationException e){
        return new AlertMessage("Wrong Operation", e.getMessage());
    }
    
    public static AlertMessage handle(SyntaxException e){
        return new AlertMessage("Wrong Syntax", e.getMessage());
    }
} 
