package AlertMessage;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;

public class AlertMessage {
    /**
     * An object that generates an Alert of type error
     * @param headerMessage string representing the Alert's header
     * @param errorMessage string representing the Alert's content
     */
    public AlertMessage(String headerMessage, String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        
        alert.setTitle("Error Dialog");
        alert.setHeaderText(headerMessage);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
}
