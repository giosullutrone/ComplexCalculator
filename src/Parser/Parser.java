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
            this.separator=null;
        }

        public void setSeparator(String separator) {
            this.separator = separator;
        }
        
        private void setParts(String real, String img){
            this.real=Double.parseDouble(real);
            this.img=Double.parseDouble(img);
        }
        
        private void split(String toSplit){
            String[] parts = toSplit.split(this.separator);
            parts[1] = separator+parts[1].replace("j", "");
            this.setParts(parts[0], parts[1]);
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
            try {
                parse(string);
            } catch (IOException ex) {
                Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void parse(String s) throws IOException {
        s = s.trim();
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
        
        for(String separator : separators){
            if(s.contains(separator)){
                splitter.setSeparator(separator);
                splitter.split(s);
                this.stackOperator.execute(new Complex(splitter.real, splitter.img));
                return;
            }
            
        }
        
        throw new IOException();
            
        
        
    }
}