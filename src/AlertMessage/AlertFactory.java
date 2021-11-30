package AlertMessage;

public class AlertFactory {
    public AlertMessage handle(OperationException e){
        return new AlertMessage("Wrong Operation", e.getMessage());
    }
    
    public AlertMessage handle(SyntaxException e){
        return new AlertMessage("Wrong Syntax", e.getMessage());
    }
} 
