package AlertMessage;

public class OperationException extends RuntimeException{
    /**
     * The Exception called to handle an operation error
     * @param msg message describing the error
     */
    public OperationException(String msg){
        super(msg);
    } 
}
