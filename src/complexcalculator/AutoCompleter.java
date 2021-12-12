package complexcalculator;

import Stack.StackNumber;
import Dict.DictToken;
import impl.org.controlsfx.skin.AutoCompletePopup;
import java.util.LinkedList;
import java.util.stream.Collectors;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import Dict.DictFunction;
import Dict.DictVar;
import java.util.Arrays;
import javafx.scene.control.TextField;

public class AutoCompleter {
    private final AutoCompletionBinding<String> stringAutoCompletionBinding;
    private final AutoCompletePopup<String> autoCompletionPopup;
    private LinkedList<String> completeDict;
    private DictFunction dictFun;
    private TextField textField;
    private DictVar dictVars;
    private StackNumber stackNumber;
    String last;
    
    public AutoCompleter(DictFunction dictFun, DictVar dictVars ,TextField textField, StackNumber stackNumber) {
        
        this.dictFun=dictFun;
        this.textField=textField;
        this.dictVars = dictVars;
        this.stackNumber = stackNumber;
        completeDict = DictToken.getCompleteDict(dictFun);
        
        stringAutoCompletionBinding = TextFields.bindAutoCompletion(textField, provider -> {
            last = provider.getUserText();
            
            return completeDict.stream().filter(elem -> {
                String[] ss = provider.getUserText().toLowerCase().split(" ");
                return elem.toLowerCase().contains(ss[ss.length-1]);
            }).sorted((String t, String t1) -> t.indexOf(last) - t1.indexOf(last)).collect(Collectors.toList());
        });
        
        stringAutoCompletionBinding.setOnAutoCompleted(value -> {
            String[] ss = Arrays.copyOfRange(last.split(" "), 0, last.split(" ").length-1);
            textField.setText(String.join(" ", ss) + ((ss.length==0) ? "": " ") + value.getCompletion()); 
            textField.end();
        });
        
        stringAutoCompletionBinding.setVisibleRowCount(2);
        autoCompletionPopup = stringAutoCompletionBinding.getAutoCompletionPopup();
        autoCompletionPopup.setAutoFix(true);
        autoCompletionPopup.setStyle("");
        autoCompletionPopup.setStyle("-fx-control-inner-background:#44475A;"
                + "-fx-accent: #44475A;"
                + "-fx-selection-bar-non-focused:#ffb86c;"
                + "-fx-font:13px 'Calibri'");
    }
    
    public void update(){
        autoCompletionPopup.setMinWidth(textField.getWidth());
        autoCompletionPopup.setMaxWidth(textField.getWidth());
        if(completeDict.isEmpty()){
            completeDict.addAll(DictToken.getCompleteDict(dictFun));
            if(!dictVars.getkeyList().isEmpty()){
                Arrays.asList('!', '<','>', '+', '-').forEach(token -> {
                    dictVars.getkeyList().forEach(letter -> {
                        if(!stackNumber.isEmpty() && !dictVars.isNull(letter) && Arrays.asList('+', '-').contains(token))
                            completeDict.add(""+token+letter);                            
                        else if(!dictVars.isNull(letter) && !Arrays.asList('+','-','>').contains(token))
                            completeDict.add(""+token+letter);
                        else if(token=='>' && !stackNumber.isEmpty())
                            completeDict.add(""+token+letter);
                });
            });
            }
        }
            
    }
    
    public void clear(){
        completeDict.clear();
    }
    //
}
