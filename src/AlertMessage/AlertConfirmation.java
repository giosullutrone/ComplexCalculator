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
    Alert alert;
    public AlertConfirmation(String headerMessage, String confirmationMessage) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(headerMessage);
        alert.setContentText(confirmationMessage);
    }
    
    /**
     * Method to identify which button is pressed
     * @return the value of the button is pressed
     */
    public ButtonType state (){
        Optional<ButtonType> result = alert.showAndWait();
        return result.get();
    }
}