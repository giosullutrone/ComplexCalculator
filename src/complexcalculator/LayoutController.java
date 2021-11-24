package complexcalculator;

import Complex.Complex;
import Parser.Parser;
import complexcalculator.StackNumber;
import complexcalculator.StackOperator;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class LayoutController implements Initializable {
    @FXML
    private TextField textField;
    
    StackNumber stackNum;
            
    StackOperator stackOp;
    
    Parser par;
    @FXML
    private ListView<String> listView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Initialize the two stacks
        stackNum = new StackNumber();
        stackOp = new StackOperator(stackNum);
        
        //Initialize the Parser
        par= new Parser(stackOp);
   
    }

    @FXML
    private void enterPressed(ActionEvent event) {
        //Parse the content of the string
        par.parse(textField.getText());
          
        //resest the textFileld
        textField.setText(""); 
        
        //Deleting the current rows and replacing with the new
        listView.getItems().clear();
        
            
        listView.getItems().addAll(stackNum.getStack(12));
        
        
    }    
}