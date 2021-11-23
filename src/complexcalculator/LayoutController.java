package complexcalculator;

import Parser.Parser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class LayoutController implements Initializable {
    @FXML
    private TextField textField;
    @FXML
    private TableView<String> tableView;
    @FXML
    private TableColumn<String, String> stackColumn;
    
    private ObservableList<String> stackList;
    
    StackNumber stackNum;
            
    StackOperator stackOp;
    
    Parser par;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Initialize the two stacks
        StackNumber stackNum = new StackNumber();
        StackOperator stackOp = new StackOperator(stackNum);
        
        //Initialize the Parser
        //par= new Parser();
        
        //Initialize the tableview 
        tableView = new TableView<>();
        
        //Initialize the ObservableList
        stackList= FXCollections.observableArrayList();       
        
        //Initialize the column of the stack
        stackColumn = new TableColumn<>();
    }

    @FXML
    private void enterPressed(ActionEvent event) {
        //Parse the content of the string
        //par.parse(textField.getText());
        
        //resest the textFileld
        textField.setText(""); 
    }    
}
