package complexcalculator;

import AlertMessage.AlertFactory;
import AlertMessage.OperationException;
import AlertMessage.SyntaxException;
import Parser.DictFunction;
import Parser.DictVar;
import Parser.Parser;
import Parser.ParserFactory;
import static complexcalculator.Configurator.startConfiguration;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class LayoutController implements Initializable {
    @FXML
    private TextField textField;
    @FXML
    private ListView<String> listView;
    @FXML
    private ListView<String> listViewVars;
    @FXML
    private AnchorPane varPane;
    @FXML
    private ListView<String> listViewDup;
    
    private DictFunction dictFun;
    private AutoCompleter autoCompleter;
    StackNumber stackNum;
    Parser parser_chained;
    DictVar dictVars;
    
    
    
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
        
        //Making items in the lists non seltionable
        listView.setMouseTransparent( true );
        listView.setFocusTraversable( false );
        listViewDup.setMouseTransparent( true );
        listViewDup.setFocusTraversable( false );
        listViewVars.setMouseTransparent( true );
        listViewVars.setFocusTraversable( false );

        //Initialize the stack
        stackNum = new StackNumber();

        //Initialize the dictionary of function relaoading from the file the operations
        dictFun= startConfiguration();
        
        //Initialize the dictionary of variables
        dictVars = new DictVar(); 
        hideVars();

        //Initialize the ParserFactory
        ParserFactory par= new ParserFactory(stackNum, dictFun, dictVars);
        parser_chained = par.chain();
        
        //Initialize the AutoComplete Function
        autoCompleter = new AutoCompleter(dictFun, textField);

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
            autoCompleter.clear();
            enterHandler();         
        } else {
            autoCompleter.update();
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
        switch(textField.getText().toLowerCase()){
            case "new":
                //resest the textFileld
                textField.setText(""); 
                dictFun = OperationManager.display(dictFun);
                break;
            case "vars":
                //switch to variables view
                if(varPane.getHeight()>0){
                    hideVars();
                }else{
                    updateVarList();
                    showVars();
                }
                break;
            default:
                //Parse the content of the string while catching and 
                //handling possible RuntimeExceptions through the AlertFactory class.
                try {
                    parser_chained.parse(textField.getText());
                    updateVarList();
                } catch(SyntaxException e) {
                    AlertFactory.handle(e);
                } catch (OperationException e) {
                    AlertFactory.handle(e);
                }
                break;
        }
        //reset the textFileld
        textField.setText("");
        //Deleting the current rows and replacing it with the newest
        listView.getItems().clear();   
        listView.getItems().addAll(stackNum.getStack());
        listViewDup.getItems().clear(); 
        listViewDup.getItems().addAll(stackNum.getStack());
        
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
    
    /**
     * Put the Anchor pane with vars on the standard list
     */
    private void showVars(){
        AnchorPane.setTopAnchor(varPane, 70.0);
        AnchorPane.setLeftAnchor(varPane, 20.0);
        AnchorPane.setBottomAnchor(varPane, 30.0);
        AnchorPane.setRightAnchor(varPane, 20.0);
    }
    
    /**
     * Hides the Anchor pane with vars to show the standard stack only
     */
    private void hideVars(){
        AnchorPane.setTopAnchor(varPane, Double.MAX_VALUE);
        AnchorPane.setLeftAnchor(varPane, Double.MAX_VALUE);
        AnchorPane.setBottomAnchor(varPane, Double.MAX_VALUE);
        AnchorPane.setRightAnchor(varPane, Double.MAX_VALUE);
    }
    
    /**
     * Updates the var list tacking only rhe populated elements of the VarDict
     */
    private void updateVarList(){
        listViewVars.getItems().clear();
        for (char c = 'a'; c <= 'z'; c++) {
            try{
                listViewVars.getItems().add(Character.toString(c)+" -> "+dictVars.get(Character.toString(c)).toString());
            }catch(OperationException ex){}
        }
    }
}