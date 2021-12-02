/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlertMessage;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertConfirmation {
    /**
     * An object that generates an Aler of type Confirmation
     * @param headerMessage string representing the Alert's header
     * @param confirmationMessage string representing the Alert's content
     */
    
    public AlertConfirmation(String headerMessage, String confirmationMessage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(headerMessage);
        alert.setContentText(confirmationMessage);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        // ... user chose OK
        } 
     }
    
    }