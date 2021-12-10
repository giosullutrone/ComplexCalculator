package AlertMessage;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

public class AlertConfirmation {

    public ButtonType buttonTypeSave, buttonTypeNotSave, buttonTypeCancel;
    /**
     * An object that generates an Alert of type Confirmation
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

    /** An object that generates an Alert of type Confirmation on a File
     * @param headerMessage string representing the Alert's header
     * @param confirmationMessage string representing the Alert's content
     * @param a
    */
    public AlertConfirmation(String headerMessage, String confirmationMessage, int a) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(headerMessage);
        alert.setContentText(confirmationMessage);
        buttonTypeSave = new ButtonType("Save");
        buttonTypeNotSave = new ButtonType("Not Save");
        buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeSave, buttonTypeNotSave, buttonTypeCancel);
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