package AlertMessage;

import javafx.scene.control.Alert;

public class AllertMessage {

    public AllertMessage(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setContentText(errorMessage);
        alert.showAndWait();  
    }
    
     
}
