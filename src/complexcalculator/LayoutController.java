package complexcalculator;

import AlertMessage.AlertFactory;
import AlertMessage.OperationException;
import AlertMessage.SyntaxException;
import Parser.DictFunction;
import Parser.DictToken;
import Parser.Parser;
import Parser.ParserFactory;
import static complexcalculator.Configurator.startConfiguration;
import impl.org.controlsfx.skin.AutoCompletePopup;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;


public class LayoutController implements Initializable {
    @FXML
    private TextField textField;
    
    StackNumber stackNum;
    
    Parser parser_chained;
    @FXML
    private ListView<String> listView;
    
    private DictFunction dictFun;
    private LinkedList<String> completeDict;
    
    AutoCompletionBinding<String> stringAutoCompletionBinding;
    AutoCompletePopup<String> autoCompletionPopup;
    
    
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
        
        textField.setPromptText("Insert operations or numbers here");
        //Making items in the list non seltionable
        listView.setMouseTransparent( true );
        listView.setFocusTraversable( false );

        //Initialize the stack
        stackNum = new StackNumber();

        //Initialize the dictionary of function relaoading from the file the operations
        dictFun= startConfiguration();
                
        //Initialize the ParserFactory
        ParserFactory par= new ParserFactory(stackNum, dictFun);
        parser_chained = par.chain();
        
        //Initialize the AutoComplete Function
        completeDict = DictToken.getCompleteDict(dictFun);
        stringAutoCompletionBinding = TextFields.bindAutoCompletion(textField, provider -> {
            return completeDict.stream().filter(elem
                    -> {
                return elem.toLowerCase().startsWith(provider.getUserText().toLowerCase());
            }).collect(Collectors.toList());
        });
        stringAutoCompletionBinding.setVisibleRowCount(2);
        autoCompletionPopup = stringAutoCompletionBinding.getAutoCompletionPopup();
        autoCompletionPopup.setAutoFix(true);
        autoCompletionPopup.setStyle("");
        autoCompletionPopup.setStyle("-fx-control-inner-background:#44475A;"
                + "-fx-accent: #ffb86c;"
                + "-fx-selection-bar-non-focused:#ffb86c;"
                + "-fx-font:12px 'Calibri'");
        

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
        autoCompletionPopup.setMinWidth(textField.getWidth());
        autoCompletionPopup.setMaxWidth(textField.getWidth());
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
        //parse new for the generation of a user definied operation
        if("new".equals(textField.getText().toLowerCase())){
            dictFun = OperationManager.display(dictFun);
        }
        else{
        //Parse the content of the string while catching and 
        //handling possible RuntimeExceptions through the AlertFactory class.
            try {
                parser_chained.parse(textField.getText());
            } catch(SyntaxException e) {
                AlertFactory.handle(e);
            } catch (OperationException e) {
                AlertFactory.handle(e);
            }
        }
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