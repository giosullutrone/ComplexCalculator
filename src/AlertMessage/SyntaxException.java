package AlertMessage;

public class SyntaxException  extends RuntimeException{
    /**
     * The Exception called to handle a syntax error
     * @param msg message describing the error 
     */
    public SyntaxException(String msg){
        super(msg);
    } 
}