package AlertMessage;

import javafx.scene.control.Alert;

public class AlertMessage {
    public AlertMessage(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setContentText(errorMessage);
        alert.showAndWait();  
    }
}
