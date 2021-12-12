package complexcalculator;

import Dict.DictHelp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;


public class HelpController implements Initializable {

    @FXML
    private ListView<String> operationList;
    @FXML
    private TextArea textArea;

    /**
    * Method called on the start of the interface and initialize the operationList,
    * setting to each of them a syntax and a description. The manual is thus created
    *
    * @param url the url used to resolve relative paths for the root object, or null if the location is not known
    * @param rb the resource used to localize the root object, or null if the root object was not localized
    *
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        operationList.getItems().addAll(DictHelp.keyList());
        
        operationList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            /**
             * Method that is called if the value of an ObservableValue changes. 
             * So, depending on the selected operation, a different description is assigned

             * @param ov The ObservableValue which value changed
             * @param old_val The old value
             * @param new_val The new value
             */
            @Override
            public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
                String selectedItem = operationList.getSelectionModel().getSelectedItem();
                textArea.setWrapText(true);
                textArea.setText(DictHelp.values(selectedItem));
            }
        });
    }  
    
        
    
}
