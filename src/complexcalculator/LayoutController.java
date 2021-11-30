package complexcalculator;

import AlertMessage.AlertFactory;
import AlertMessage.OperationException;
import AlertMessage.SyntaxException;
import Parser.Parser;
import Parser.ParserFactory;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class LayoutController implements Initializable {
    @FXML
    private TextField textField;
    
    StackNumber stackNum;
    
    Parser parser_chained;
    @FXML
    private ListView<String> listView;
    

    /**
    * Method called on the start of the interface and initialize the stack of number,
    * the stack of operator and the parser
    *
    * @param url
    * @param rb
    *
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Initialize the stack
        stackNum = new StackNumber();

        //Initialize the ParserFactory
        ParserFactory par= new ParserFactory(stackNum);
        parser_chained = par.chain();
        
    }
    
    /**
    * Method called by the user interface on the press of the enter button
    * calls the enterHandler function to perform operation
    *
    * @param event
    *
    */
    @FXML
    private void enterPressed(ActionEvent event) {
        enterHandler(); 
    }  
    
    /**
    * Method called by the user interface on the press of any key on
    * the keyboard while manipulating the textfield, check if the last
    * key pressed is an enter and calls the enterHandler function to perform operation
    *
    * @param KeyEvent
    *
    */
    @FXML
    private void textEnterPressed(KeyEvent event) {
        if(event.getText().contains("\r")){
            enterHandler(); 
        }
    }
    
    /**
    * Method for handling the usage of the enter button and the enter key.
    * Take the string in the text field and gives it to the parser, resets the 
    * text field and updates the list view
    *
    */
    private void enterHandler(){
        //Parse the content of the string
        try {
            parser_chained.parse(textField.getText());
        } catch(SyntaxException e) {
            AlertFactory.handle(e);
        } catch (OperationException e) {
            AlertFactory.handle(e);
        }
        
        //resest the textFileld
        textField.setText(""); 
        
        //Deleting the current rows and replacing with the new
        listView.getItems().clear();   
        listView.getItems().addAll(stackNum.getStack());
        
    }
}