/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;


public class HelpController implements Initializable {

    @FXML
    private ListView<String> operationList;
    @FXML
    private TextArea textArea;

    /**
    * Method called on the start of the interface and initialize the operationList,
    * setting to each of them a syntax and a description. The manual is thus created
    *
    * @param url
    * @param rb
    *
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        operationList.getItems().addAll(
                "User defined operation",
                "Operation | Addition", "Operation | Subtraction", "Operation | Multiplication", "Operation | Division", "Operation | Invert Sign", "Operation | Square Root", "Operation | Conjugate",
                "Stack operation | Clear", "Stack operation | Swap", "Stack operation | Dup", "Stack operation | Drop", "Stack operation | Over",
                "Variables | Save", "Variables | Push", "Variables | Addition", "Variables | Subtraction",
                "Stack Variables | Save", "Stack Variables | Restore",
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
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "new" + "\n" + "\n"+ 
                                          "Description:" + "\t" +  "function used to view a pop up that allows you to define a new operation by specifying a name and a sequence of operations. The definition may contain other defined operations. " +
                                          "It is possible to delete an operation and modify the definition. \n" + 
                                          "To SAVE to a file the existing defined operations and RELOAD them from a file, you can right mouse click on the operations list. With CLEAR, you can delete all operations list, without modifying file");
                        break;
                    //operation
                    case "Operation | Addition":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "+" + "\n" + "\n"+ 
                                         "Description:" + "\t" + "function that does the addition of a complex number");
                        break;
                    case "Operation | Subtraction":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "-" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the subtraction of a complex number");
                        break;
                    case "Operation | Multiplication":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "*" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the multiplication of a complex number");
                        break;
                    case "Operation | Division":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "/" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the division of a complex number");
                        break;
                    case "Operation | Invert Sign":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "+-" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the invert sign of a complex number");
                        break;
                    case "Operation | Square Root":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "sqrt" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the square root of a complex number");
                        break;
                    case "Operation | Conjugate":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "conj" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the conjugate of a complex number");
                        break;
                        
                    //stack
                    case "Stack operation | Clear":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "clear" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function used to clear the provided Stack");
                        break;
                    case "Stack operation | Swap":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "swap" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function used to swap the top two elements from the provided Stack");
                        break;
                    case "Stack operation | Dup":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "dup" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function used to duplicate the top element from the provided Stack");
                        break;
                    case "Stack operation | Drop":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "drop" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function used to remove the top element from the provided Stack");
                        break;
                    case "Stack operation | Over":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "over" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function used to duplicate the second element from the top of the provided Stack");
                        break;
                        
                    //variables
                    case "Variables | Save":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + ">x" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function used to take the top element from the stack and saves it into the variable \"x\"");
                        break;
                    case "Variables | Push":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "<x" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function used to push the value of the variable \"x\" onto the stack");
                        break;
                    case "Variables | Addition":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "+x" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function used to take the top element from the stack and adds it to the value of the variable \"x\"");
                        break;
                    case "Variables | Subtraction":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "-x" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function used to take the top element from the stack and subtracts it from the value of the variable \"x\"");
                        break;
                        
                    // stack variables
                    case "Stack Variables | Save":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "save" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function used to save a copy of all the 26 variables on a variable stack (distinct from the stack used for the operands by the operations)");
                        break;
                    case "Stack Variables | Restore":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "restore" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function used to restore for all variables the last values that were saved on the variable stack (removing them from that stack)");
                        break;  
                        
                    //trascendental function
                    case "Trascendental Functions | Modulus/Magnitude":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "mod" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the modulus/magnitude of a complex number");
                        break;
                    case "Trascendental Functions | Argument/Phase":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "arg" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the argument/phase of a complex number");
                        break;
                    case "Trascendental Functions | Natural Logarithm":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "log" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the natural logarithm of a complex number");
                        break;
                    case "Trascendental Functions | Power":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "pow" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the power of a complex number");
                        break;
                    case "Trascendental Functions | Sine":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "sin" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the sine of a complex number");
                        break;
                    case "Trascendental Functions | Cosine":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "cos" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the cosine of a complex number");
                        break;
                    case "Trascendental Functions | Tangent":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "tan" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the tangent of a complex number");
                        break;
                    case "Trascendental Functions | Arc sine":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "asin" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the arc sine of a complex number");
                        break;
                    case "Trascendental Functions | Arc cosine":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "acos" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the arc cosine of a complex number");
                        break;
                    case "Trascendental Functions | Arc tangent":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "atan" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the arc tangent of a complex number");
                        break;
                    case "Trascendental Functions | Exponential":
                        textArea.setText("Syntax:" + "\t" + "\t"+ "\t" + "exp" + "\n" + "\n"+ 
                                         "Description:" + "\t" +"function that does the exponential of a complex number");
                        break;
                    default:
                        textArea.setText("");
                }   
            }
        });
    }  
    
        
    
}
