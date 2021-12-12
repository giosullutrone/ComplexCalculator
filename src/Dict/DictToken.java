package Dict;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Class that provides methods used to execute specific operations on a provided 
 * variable and to save and restore a set of variables.
 */
public class DictToken {
    private static final List<String> dict = 
            Arrays.asList("+", "-", "*", "/", "sqrt", "+-", "conj",
                            "mod", "arg", "exp", "log", "pow", "sin", "cos", "tan", "asin", "acos", "atan",
                                "clear", "drop", "dup", "over", "swap", 
                                    "clc");
    
    /**
     * Method used to check if the dict contains an operation
     * @param check operation to fin into the dict
     * @return true if dict contains the operation, false if it doesn't
     */
    public static boolean contains(String check){
        return (dict.contains(check) || Pattern.compile("\\s+([!<>+-][a-z])\\s+").matcher(check).find());
    }

    /**
     * @param dictFunction
     * @return 
     */
    public static LinkedList<String> getDict(DictFunction dictFunction){
        LinkedList<String> completeDict = new LinkedList<>(dict);
        completeDict.addAll(dictFunction.keyList());
        return completeDict;
    }

    /**
     * @param dictFunction
     * @return 
     */
    public static LinkedList<String> getCompleteDict(DictFunction dictFunction){
        LinkedList<String> completeDict = getDict(dictFunction);
        completeDict.addAll(Arrays.asList("new","vars", "save", "restore"));
        return completeDict;
    }
}