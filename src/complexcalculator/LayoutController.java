package complexcalculator;

import Parser.Parser;
import Parser.ParserFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class LayoutController implements Initializable {
    @FXML
    private TextField textField;
    
    StackNumber stackNum;
    
    Parser parser_chained;
    @FXML
    private ListView<String> listView;
    

    /**
    * Method called on the start of the interface and initaliaze the stack of number,
    * the stack of operator and the parser
    *
    * @param URL
    * @param ResourceBundle
    *
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Initialize the stack
        stackNum = new StackNumber();

        //Initialize the ParserFactory
        ParserFactory par= new ParserFactory(stackNum);
        parser_chained = par.Chain();
        
    }
    /**
    * Method called by the user interface on the press of the enter button
    * take the string in the text field and gives it to the parser, resets the 
    * text field and updates the list view
    *
    * @param ActionEvent
    *
    */
    @FXML
    private void enterPressed(ActionEvent event) {
        //Parse the content of the string
        parser_chained.parse(textField.getText());
          
        //resest the textFileld
        textField.setText(""); 
        
        //Deleting the current rows and replacing with the new
        listView.getItems().clear();   
        listView.getItems().addAll(stackNum.getStack(12));
        
        
    }    
}