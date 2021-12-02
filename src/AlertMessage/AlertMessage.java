package AlertMessage;

import javafx.scene.control.Alert;

public class AlertMessage {
    /**
     * An object that generates an Aler of type error
     * @param headerMessage string representing the Alert's header
     * @param errorMessage string representing the Alert's content
     */
    public AlertMessage(String headerMessage, String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(headerMessage);
        alert.setContentText(errorMessage);
        alert.showAndWait();  
    }
}
