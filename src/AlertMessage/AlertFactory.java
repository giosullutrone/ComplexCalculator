package AlertMessage;

public class AlertFactory {
    /**
     * The method is used to handle the Alert following the OperationException
     * @param e the Exception involving an operation
     * @return an AlertMessage object that generates an Alert containing the exception message as a description
     */
    public static AlertMessage handle(OperationException e){
        return new AlertMessage("Wrong Operation", e.getMessage());
    }
    
    /**
     * The method is used to handle the Alert following the SyntaxException
     * @param e the Exception involving the syntax
     * @return an AlertMessage object that generates an Alert containing the exception message as a description
     */
    public static AlertMessage handle(SyntaxException e){
        return new AlertMessage("Wrong Syntax", e.getMessage());
    }
    
    /**
     * The method is used to handle the Alert to confirm the action
     * @param message the action to be confirmed
     * @return an AlertConfirmation object that generates an Alert containing the message as a description
     */
    public static AlertConfirmation handle(String message){
        return new AlertConfirmation("Look, a Confirmation Dialog", message);
    }

    /**
     * The method is used to handle the Alert to confirm the action on a File
     * @param message the action to be confirmed
     * @param nameFile string representing the file name
     * @return an AlertConfirmation object that generates an Alert containing the message as a description
     
     */
    public static AlertConfirmation handle(String message, String nameFile){
        return new AlertConfirmation("Look, a Confirmation Dialog", message, nameFile);
    }
} 
