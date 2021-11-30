package AlertMessage;

import javafx.scene.control.Alert;

public class AlertMessage {
    public AlertMessage(String headerMessage, String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(headerMessage);
        alert.setContentText(errorMessage);
        alert.showAndWait();  
    }
}
