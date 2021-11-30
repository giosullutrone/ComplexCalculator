package complexcalculator;

import Parser.Parser;
import Parser.ParserFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

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
        parser_chained = par.chain();
        
    }
    
    /**
    * Method called by the user interface on the press of the enter button
    * calls the enterHandler function to perform operation
    *
    * @param ActionEvent
    *
    */
    @FXML
    private void enterPressed(ActionEvent event) {
        enterHandler(); 
    }  
    
    /**
    * Method called by the user interface on the press of any key on
    * the keyboard while maniplating the textfield, check if the last
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
    * Method for handeling the usage of the enter button and the enter key.
    * Take the string in the text field and gives it to the parser, resets the 
    * text field and updates the list view
    *
    */
    private void enterHandler(){
        //Parse the content of the string
        parser_chained.parse(textField.getText());
          
        //resest the textFileld
        textField.setText(""); 
        
        //Deleting the current rows and replacing with the new
        listView.getItems().clear();   
        listView.getItems().addAll(stackNum.getStack());
        
    }

    /**
     * Method to make the help pop-up appear
     * 
     * @param event 
     */
    @FXML
    private void helpRequest(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("help.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            stage.setTitle("Help Page");
            stage.getIcons().add(
                    new Image( 
                            ComplexCalculator.class.getResourceAsStream( "512Logo.png" )));
        } catch (IOException ex) {
            Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }


        
        
    }
}