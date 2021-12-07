package complexcalculator;

import Parser.DictToken;
import impl.org.controlsfx.skin.AutoCompletePopup;
import java.util.LinkedList;
import java.util.stream.Collectors;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import Parser.DictFunction;
import java.util.Comparator;
import javafx.scene.control.TextField;

public class AutoCompleter {
    private AutoCompletionBinding<String> stringAutoCompletionBinding;
    private AutoCompletePopup<String> autoCompletionPopup;
    private LinkedList<String> completeDict;
    private DictFunction dictFun;
    private TextField textField;
    
    public AutoCompleter(DictFunction dictFun, TextField textField) {
        
        this.dictFun=dictFun;
        this.textField=textField;
        completeDict = DictToken.getCompleteDict(dictFun);
        
        stringAutoCompletionBinding = TextFields.bindAutoCompletion(textField, provider -> {
            return completeDict.stream().filter(elem
                    -> {
                return elem.toLowerCase().contains(provider.getUserText().toLowerCase());
            }).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
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
    
    public void update(){
        autoCompletionPopup.setMinWidth(textField.getWidth());
        autoCompletionPopup.setMaxWidth(textField.getWidth());
        completeDict.clear();
        completeDict.addAll(DictToken.getCompleteDict(dictFun));
    }
    
    public void erase(){
        completeDict.clear();
    }
    
}
