package Parser;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DictHelp {
    public static HashMap<String, String> dict = new HashMap<>();
    
    /**
    * Method used to create user manual
    */
    public static void getHelp(){
        //User defined operation
                dict.put("User defined operation", "Syntax:\t\tnew\n\n" + 
                                          "Description:\tfunction used to view a pop up that allows you to define a new operation by specifying a name and a sequence of operations. The definition may contain other defined operations. " +
                                          "It is possible to delete an operation and modify the definition. \n" + 
                                          "To SAVE to a file the existing defined operations and RELOAD them from a file, you can right mouse click on the operations list. With CLEAR, you can delete all operations list, without modifying file");
        //Operation         
                dict.put("Operation | Addition", "Syntax:\t\t" + "+" + "\n\n" + 
                                          "Description:\tfunction that does the addition of a complex number");

                dict.put("Operation | Subtraction", "Syntax:\t\t" + "-" + "\n\n" + 
                                          "Description:\tfunction that does the subtraction of a complex number");
                dict.put("Operation | Multiplication", "Syntax:\t\t" + "*" + "\n\n" + 
                                          "Description:\tfunction that does the multiplication of a complex number");
                dict.put("Operation | Division", "Syntax:\t\t" + "/" + "\n\n" + 
                                         "Description:\tfunction that does the division of a complex number");
                dict.put("Operation | Invert Sign", "Syntax:\t\t" + "+-" + "\n\n" + 
                                          "Description:\tfunction that does the invert sign of a complex number");
                dict.put("Operation | Square Root", "Syntax:\t\t" + "sqrt" + "\n\n" + 
                                          "Description:\tfunction that does the square root of a complex number");
                dict.put("Operation | Conjugate", "Syntax:\t\t" + "conj" + "\n\n" + 
                                         "Description:\tfunction that does the conjugate of a complex number");
        //Stack operation
                dict.put("Stack operation | Clear", "Syntax:\t\t" + "clear" + "\n\n" + 
                                         "Description:\tfunction used to clear the provided Stack");
                dict.put("Stack operation | Swap", "Syntax:\t\t" + "swap" + "\n\n" + 
                                         "Description:\tfunction used to swap the top two elements from the provided Stack");
                dict.put("Stack operation | Dup", "Syntax:\t\t" + "dup" + "\n\n" + 
                                         "Description:\tfunction used to duplicate the top element from the provided Stack");
                dict.put("Stack operation | Drop", "Syntax:\t\t" + "drop" + "\n\n" + 
                                         "Description:\tfunction used to remove the top element from the provided Stack");
                dict.put("Stack operation | Over", "Syntax:\t\t" + "over" + "\n\n" + 
                                         "Description:\tfunction used to duplicate the second element from the top of the provided Stack");
        //Variables
                dict.put("Variables | Save", "Syntax:\t\t" + ">x" + "\n\n" + 
                                         "Description:\tfunction used to take the top element from the stack and saves it into the variable \"x\"");
                dict.put("Variables | Push", "Syntax:\t\t" + "<x" + "\n\n" + 
                                         "Description:\tfunction used to push the value of the variable \"x\" onto the stack");
                dict.put("Variables | Addition", "Syntax:\t\t" + "+x" + "\n\n" + 
                                         "Description:\tfunction used to take the top element from the stack and adds it to the value of the variable \"x\"");
                dict.put("Variables | Subtraction", "Syntax:\t\t" + "-x" + "\n\n" + 
                                         "Description:\tfunction used to take the top element from the stack and subtracts it from the value of the variable \"x\"");
                dict.put("Variables | Delete", "Syntax:\t\t" + "!x" + "\n\n" + 
                                         "Description:" + "\t" + "function used to delete the value of the variable \"x\"");

                dict.put("Variables | Delete all", "Syntax:\t\t" + "clc" + "\n\n" + 
                                         "Description:\tfunction used to delete the value of all variables ");
        //Stack variables
                dict.put("Stack Variables | Show", "Syntax:\t\t" + "vars" + "\n\n" + 
                                         "Description:\tfunction used to show variables with numbers saved");
                dict.put("Stack Variables | Save", "Syntax:\t\t" + "save" + "\n\n" + 
                                         "Description:\tfunction used to save a copy of all the 26 variables on a variable stack (distinct from the stack used for the operands by the operations)");
                dict.put("Stack Variables | Restore", "Syntax:\t\t" + "restore" + "\n\n" + 
                                         "Description:\tfunction used to restore for all variables the last values that were saved on the variable stack (removing them from that stack)");

        //Trascendental function
                dict.put( "Trascendental Functions | Modulus/Magnitude", "Syntax:\t\t" + "mod" + "\n\n" + 
                                         "Description:\tfunction that does the modulus/magnitude of a complex number");
                dict.put( "Trascendental Functions | Argument/Phase", "Syntax:\t\t" + "arg" + "\n\n" + 
                                         "Description:\tfunction that does the argument/phase of a complex number");
                dict.put( "Trascendental Functions | Natural Logarithm","Syntax:\t\t" + "log" + "\n\n" + 
                                         "Description:\tfunction that does the natural logarithm of a complex number");
                dict.put( "Trascendental Functions | Power","Syntax:\t\t" + "pow" + "\n\n" + 
                                         "Description:\tfunction that does the power of a complex number");
                dict.put( "Trascendental Functions | Sine","Syntax:\t\t" + "sin" + "\n\n" + 
                                         "Description:\tfunction that does the sine of a complex number");
                dict.put( "Trascendental Functions | Cosine","Syntax:\t\t" + "cos" + "\n\n" + 
                                         "Description:\tfunction that does the cosine of a complex number");
                dict.put( "Trascendental Functions | Tangent","Syntax:\t\t" + "tan" + "\n\n" + 
                                         "Description:\tfunction that does the tangent of a complex number");
                dict.put( "Trascendental Functions | Arc sine","Syntax:\t\t" + "asin" + "\n\n" + 
                                         "Description:\tfunction that does the arc sine of a complex number");
                dict.put( "Trascendental Functions | Arc cosine","Syntax:\t\t" + "acos" + "\n\n" + 
                                         "Description:\tfunction that does the arc cosine of a complex number");
                dict.put( "Trascendental Functions | Arc tangent","Syntax:\t\t" + "atan" + "\n\n" + 
                                         "Description:\tfunction that does the arc tangent of a complex number");
                dict.put( "Trascendental Functions | Exponential","Syntax:\t\t" + "exp" + "\n\n" + 
                                         "Description:\tfunction that does the exponential of a complex number");
    }

    /**
     * Method used to get a list of all keys.
     * @return LinkedList of all keys.
     */
    public static List<String> keyList() {
        List<String> s = new LinkedList<>(DictHelp.dict.keySet());
        Collections.sort(s);
        return s;
    }

    /**
     * Method used to get a value from the specified key.
     * @param key name of the function.
     * @return String value associated with the key.
     */
    public static String values(String key) {
        return DictHelp.dict.get(key);
    }
}
