package Parser;

import Complex.*;
import complexcalculator.StackOperator;
import Operations.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {
    
    private class Splitter {
        
        private String separator;
        private double real=0;
        private double img=0;
        
        private Splitter() {
        }

        public void setSeparator(String separator) {
            this.separator = separator;
        }
        
        private void setParts(String real, String img){
            this.real=Double.parseDouble(real);
            this.img=Double.parseDouble(img);
        }
        
        private void split(String toSplit){
            String[] parts;
            if(this.separator.equals("+"))
                parts = toSplit.trim().split("\\+");
            else
                parts = toSplit.trim().split(this.separator);
            
            
            if(parts[0].contains("j")){
                this.setParts(this.separator + parts[1], parts[0].trim().split("j")[0]);
            }else{
                this.setParts(parts[0], this.separator + parts[1].trim().split("j")[0]);
            }
        }
        

        
        

    
    }
    private final StackOperator stackOperator;
    private Splitter splitter = new Splitter();
    
    private List<String> separators = Arrays.asList("+", "-");
    
    public Parser(StackOperator s) {
        this.stackOperator = s;
        this.splitter = new Splitter();
    }
    
    public void parse(List<String> ss) {
        ss.forEach(string -> {
            parse(string);
        });
    }
    
    public void parse(String s) {
        s = s.toLowerCase();
      
        if(s.compareTo("+")==0){
            this.stackOperator.execute(new Add());
            return;
        }
        if(s.compareTo("-")==0){
            //this.stackOperator.execute();
            return;
        }
        if(s.compareTo("*")==0){
            //this.stackOperator.execute();
            return;
        }
        if(s.compareTo("/")==0){
            //this.stackOperator.execute();
            return;
        }
        if(s.compareTo("clear")==0){
            //this.stackOperator.clear();
            return;
        }
        
        if(s.contains(separators.get(0)) || s.contains(separators.get(1))){
            if((s.contains(separators.get(0)) && !s.contains(separators.get(1))))
                splitter.setSeparator(separators.get(0));
            if(!s.contains(separators.get(0)) && s.contains(separators.get(1)))
                splitter.setSeparator(separators.get(1));
            if(s.contains(separators.get(0)) && s.contains(separators.get(1))){
                if(s.indexOf(separators.get(0)) > s.indexOf(separators.get(1)))
                    splitter.setSeparator(separators.get(0));
                if(s.indexOf(separators.get(0)) < s.indexOf(separators.get(1)))
                    splitter.setSeparator(separators.get(1));
            }
            splitter.split(s);
            this.stackOperator.execute(new Complex(splitter.real, splitter.img));
        }
    
  
    }
}