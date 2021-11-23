package Parser;

import Complex.*;
import complexcalculator.StackOperator;
import Operations.*;
import java.util.Arrays;
import java.util.List;
public class Parser {
    
    private class Splitter {
        
        private String separator;
        private double real=0;
        private double img=0;
        
        public void setSeparator(String separator) {
            this.separator = separator;
        }
        
        private void setParts(String real, String img){
            this.real=Double.parseDouble(real);
            this.img=Double.parseDouble(img);
        }
        
        private void split(String toSplit){
            //Array that contains real and img part
            String[] parts;
            if(this.separator.equals("+")){
                //Change argument of split function to "\\+" to avoid Java meta
                parts = toSplit.split("\\+");
                
                //Return in order Real and Img part
                if(parts[0].contains("j")){
                    this.setParts(parts[1], parts[0].trim().split("j")[0]);
                }else{
                    this.setParts(parts[0], parts[1].trim().split("j")[0]);
                }
                return;
            }
            
            //Handle the case of "-" operator twice
            if(toSplit.indexOf("-")==0 && this.separator.equals("-")){
                parts = toSplit.substring(1).split(this.separator);
                if(parts[0].contains("j")){
                    this.setParts(this.separator + parts[1], this.separator + parts[0].trim().split("j")[0]);
                }else{
                    this.setParts(this.separator + parts[0], this.separator + parts[1].trim().split("j")[0]);}
            }
            else if(this.separator.equals("-")){
                parts = toSplit.split(this.separator);
                if(parts[0].contains("j")){
                    this.setParts(this.separator + parts[1], parts[0].trim().split("j")[0]);
                }else{
                    this.setParts(parts[0], this.separator + parts[1].trim().split("j")[0]);
                }
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
        s = s.trim();
        
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
        
        
        //if there is al least one operator
        if(s.contains(separators.get(0)) || s.contains(separators.get(1))){
            System.out.println(s);
            //if there is only first operator
            if(s.contains(separators.get(0)) && !s.contains(separators.get(1))){
                //if there is first operator twice
                System.out.println(s);
                if (s.chars().filter(ch -> ch == '+').count() == 2)
                    s=s.substring(1);
                System.out.println(s);
                splitter.setSeparator(separators.get(0));
            }
            //if there is only second operator
            //splitter class will control if there are two second operators or only one
            if(!s.contains(separators.get(0)) && s.contains(separators.get(1))){
                    splitter.setSeparator(separators.get(1));
            }
            //if there are both the operators
            if(s.contains(separators.get(0)) && s.contains(separators.get(1))){
                //if first come before second
                if(s.indexOf(separators.get(0)) > s.indexOf(separators.get(1)))
                    splitter.setSeparator(separators.get(0));
                //if second come before first
                if(s.indexOf(separators.get(0)) < s.indexOf(separators.get(1)))
                    splitter.setSeparator(separators.get(1));
            }
            splitter.split(s);
            this.stackOperator.execute(new Complex(splitter.real, splitter.img));
        }
    
  
    }
}