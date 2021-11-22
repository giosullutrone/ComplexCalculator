package complexcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class LayoutController implements Initializable {
    @FXML
    private TextField textField;
    @FXML
    private TableView<?> tableView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void enterPressed(ActionEvent event) {
    }    
}
