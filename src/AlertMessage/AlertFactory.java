/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlertMessage;
import javafx.scene.control.Alert;

public class AlertFactory {
    
    public AlertMessage operation(OperationException e){
        return new AlertMessage("Wrong Operation", e.getMessage());
    }
    
    public AlertMessage syntax(SyntaxException e){
        return new AlertMessage("Wrong Syntax", e.getMessage());
    }
    
    
        
    
} 
