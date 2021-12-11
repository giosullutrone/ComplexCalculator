package complexcalculator;

import Parser.DictToken;
import impl.org.controlsfx.skin.AutoCompletePopup;
import java.util.LinkedList;
import java.util.stream.Collectors;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import Parser.DictFunction;
import java.util.Arrays;
import java.util.Comparator;
import javafx.scene.control.TextField;

public class AutoCompleter {
    private final AutoCompletionBinding<String> stringAutoCompletionBinding;
    private final AutoCompletePopup<String> autoCompletionPopup;
    private LinkedList<String> completeDict;
    private DictFunction dictFun;
    private TextField textField;
    String last;
    
    public AutoCompleter(DictFunction dictFun, TextField textField) {
        
        this.dictFun=dictFun;
        this.textField=textField;
        completeDict = DictToken.getDict(dictFun);
        
        stringAutoCompletionBinding = TextFields.bindAutoCompletion(textField, provider -> {
            last = provider.getUserText();
            
            return completeDict.stream().filter(elem -> {
                String[] ss = provider.getUserText().toLowerCase().split(" ");
                return elem.toLowerCase().contains(ss[ss.length-1]);
            }).sorted(new Comparator<String>() {
                @Override
                public int compare(String t, String t1) {
                    return t.indexOf(last) - t1.indexOf(last);
                }
            }).collect(Collectors.toList());
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
        completeDict.clear();
        completeDict.addAll(DictToken.getCompleteDict(dictFun));
    }
    
    public void clear(){
        completeDict.clear();
    }
    //
}
