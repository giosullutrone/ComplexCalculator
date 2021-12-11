package AlertMessage;

import complexcalculator.ComplexCalculator;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
        Stage stage = (Stage) dialogPane.getScene().getWindow();
        stage.getIcons().add(new Image(ComplexCalculator.class.getResourceAsStream( "512Logo.png")));
        
        alert.setTitle("Error Dialog");
        alert.setHeaderText(headerMessage);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
}
