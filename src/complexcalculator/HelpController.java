package complexcalculator;

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
        operationList.getItems().addAll(
                "User defined operation",
                "Operation | Addition", "Operation | Subtraction", "Operation | Multiplication", "Operation | Division", "Operation | Invert Sign", "Operation | Square Root", "Operation | Conjugate",
                "Stack operation | Clear", "Stack operation | Swap", "Stack operation | Dup", "Stack operation | Drop", "Stack operation | Over",
                "Variables | Save", "Variables | Push", "Variables | Addition", "Variables | Subtraction", "Variables | Delete", "Variables | Delete all", 
                "Stack Variables | Show", "Stack Variables | Save", "Stack Variables | Restore",
                "Trascendental Functions | Modulus/Magnitude", "Trascendental Functions | Argument/Phase", "Trascendental Functions | Natural Logarithm", "Trascendental Functions | Exponential", "Trascendental Functions | Power", "Trascendental Functions | Sine", "Trascendental Functions | Cosine", "Trascendental Functions | Tangent", "Trascendental Functions | Arc sine", "Trascendental Functions | Arc cosine", "Trascendental Functions | Arc tangent");
        
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
                //textArea.setFont(Font.font(null, FontPosture.REGULAR, 32));
                switch(selectedItem){
                    
                    //user defined operation
                    case "User defined operation":
                        textArea.setText("Syntax:\t\tnew\n\n" + 
                                          "Description:\tfunction used to view a pop up that allows you to define a new operation by specifying a name and a sequence of operations. The definition may contain other defined operations. " +
                                          "It is possible to delete an operation and modify the definition. \n" + 
                                          "To SAVE to a file the existing defined operations and RELOAD them from a file, you can right mouse click on the operations list. With CLEAR, you can delete all operations list, without modifying file");
                        break;
                    //operation
                    case "Operation | Addition":
                        textArea.setText("Syntax:\t\t" + "+" + "\n\n" + 
                                          "Description:\tfunction that does the addition of a complex number");
                        break;
                    case "Operation | Subtraction":
                        textArea.setText("Syntax:\t\t" + "-" + "\n\n" + 
                                          "Description:\tfunction that does the subtraction of a complex number");
                        break;
                    case "Operation | Multiplication":
                        textArea.setText("Syntax:\t\t" + "*" + "\n\n" + 
                                          "Description:\tfunction that does the multiplication of a complex number");
                        break;
                    case "Operation | Division":
                        textArea.setText("Syntax:\t\t" + "/" + "\n\n" + 
                                         "Description:\tfunction that does the division of a complex number");
                        break;
                    case "Operation | Invert Sign":
                        textArea.setText("Syntax:\t\t" + "+-" + "\n\n" + 
                                          "Description:\tfunction that does the invert sign of a complex number");
                        break;
                    case "Operation | Square Root":
                        textArea.setText("Syntax:\t\t" + "sqrt" + "\n\n" + 
                                          "Description:\tfunction that does the square root of a complex number");
                        break;
                    case "Operation | Conjugate":
                        textArea.setText("Syntax:\t\t" + "conj" + "\n\n" + 
                                         "Description:\tfunction that does the conjugate of a complex number");
                        break;
                        
                    //stack
                    case "Stack operation | Clear":
                        textArea.setText("Syntax:\t\t" + "clear" + "\n\n" + 
                                         "Description:\tfunction used to clear the provided Stack");
                        break;
                    case "Stack operation | Swap":
                        textArea.setText("Syntax:\t\t" + "swap" + "\n\n" + 
                                         "Description:\tfunction used to swap the top two elements from the provided Stack");
                        break;
                    case "Stack operation | Dup":
                        textArea.setText("Syntax:\t\t" + "dup" + "\n\n" + 
                                         "Description:\tfunction used to duplicate the top element from the provided Stack");
                        break;
                    case "Stack operation | Drop":
                        textArea.setText("Syntax:\t\t" + "drop" + "\n\n" + 
                                         "Description:\tfunction used to remove the top element from the provided Stack");
                        break;
                    case "Stack operation | Over":
                        textArea.setText("Syntax:\t\t" + "over" + "\n\n" + 
                                         "Description:\tfunction used to duplicate the second element from the top of the provided Stack");
                        break;
                        
                    //variables
                    case "Variables | Save":
                        textArea.setText("Syntax:\t\t" + ">x" + "\n\n" + 
                                         "Description:\tfunction used to take the top element from the stack and saves it into the variable \"x\"");
                        break;
                    case "Variables | Push":
                        textArea.setText("Syntax:\t\t" + "<x" + "\n\n" + 
                                         "Description:\tfunction used to push the value of the variable \"x\" onto the stack");
                        break;
                    case "Variables | Addition":
                        textArea.setText("Syntax:\t\t" + "+x" + "\n\n" + 
                                         "Description:\tfunction used to take the top element from the stack and adds it to the value of the variable \"x\"");
                        break;
                    case "Variables | Subtraction":
                        textArea.setText("Syntax:\t\t" + "-x" + "\n\n" + 
                                         "Description:\tfunction used to take the top element from the stack and subtracts it from the value of the variable \"x\"");
                        break;
                    case "Variables | Delete":
                        textArea.setText("Syntax:\t\t" + "!x" + "\n\n" + 
                                         "Description:" + "\t" + "function used to delete the value of the variable \"x\"");
                        break;
                    case "Variables | Delete all":
                        textArea.setText("Syntax:\t\t" + "clc" + "\n\n" + 
                                         "Description:\tfunction used to delete the value of all variables ");
                        break;
                        
                    // stack variables
                    case "Stack Variables | Show":
                        textArea.setText("Syntax:\t\t" + "vars" + "\n\n" + 
                                         "Description:\tfunction used to show variables with numbers saved");
                        break;
                    case "Stack Variables | Save":
                        textArea.setText("Syntax:\t\t" + "save" + "\n\n" + 
                                         "Description:\tfunction used to save a copy of all the 26 variables on a variable stack (distinct from the stack used for the operands by the operations)");
                        break;
                    case "Stack Variables | Restore":
                        textArea.setText("Syntax:\t\t" + "restore" + "\n\n" + 
                                         "Description:\tfunction used to restore for all variables the last values that were saved on the variable stack (removing them from that stack)");
                        break;  
                        
                    //trascendental function
                    case "Trascendental Functions | Modulus/Magnitude":
                        textArea.setText("Syntax:\t\t" + "mod" + "\n\n" + 
                                         "Description:\tfunction that does the modulus/magnitude of a complex number");
                        break;
                    case "Trascendental Functions | Argument/Phase":
                        textArea.setText("Syntax:\t\t" + "arg" + "\n\n" + 
                                         "Description:\tfunction that does the argument/phase of a complex number");
                        break;
                    case "Trascendental Functions | Natural Logarithm":
                        textArea.setText("Syntax:\t\t" + "log" + "\n\n" + 
                                         "Description:\tfunction that does the natural logarithm of a complex number");
                        break;
                    case "Trascendental Functions | Power":
                        textArea.setText("Syntax:\t\t" + "pow" + "\n\n" + 
                                         "Description:\tfunction that does the power of a complex number");
                        break;
                    case "Trascendental Functions | Sine":
                        textArea.setText("Syntax:\t\t" + "sin" + "\n\n" + 
                                         "Description:\tfunction that does the sine of a complex number");
                        break;
                    case "Trascendental Functions | Cosine":
                        textArea.setText("Syntax:\t\t" + "cos" + "\n\n" + 
                                         "Description:\tfunction that does the cosine of a complex number");
                        break;
                    case "Trascendental Functions | Tangent":
                        textArea.setText("Syntax:\t\t" + "tan" + "\n\n" + 
                                         "Description:\tfunction that does the tangent of a complex number");
                        break;
                    case "Trascendental Functions | Arc sine":
                        textArea.setText("Syntax:\t\t" + "asin" + "\n\n" + 
                                         "Description:\tfunction that does the arc sine of a complex number");
                        break;
                    case "Trascendental Functions | Arc cosine":
                        textArea.setText("Syntax:\t\t" + "acos" + "\n\n" + 
                                         "Description:\tfunction that does the arc cosine of a complex number");
                        break;
                    case "Trascendental Functions | Arc tangent":
                        textArea.setText("Syntax:\t\t" + "atan" + "\n\n" + 
                                         "Description:\tfunction that does the arc tangent of a complex number");
                        break;
                    case "Trascendental Functions | Exponential":
                        textArea.setText("Syntax:\t\t" + "exp" + "\n\n" + 
                                         "Description:\tfunction that does the exponential of a complex number");
                        break;
                    default:
                        textArea.setText("");
                }   
            }
        });
    }  
    
        
    
}
