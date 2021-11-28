package Operations.NumOperations;

import AlertMessage.AlertMessage;
import Complex.Complex;
import javafx.scene.control.Alert;
import static javax.swing.JOptionPane.showMessageDialog;

public class Div implements Operation2{
   /**
     * Method used to divide two complex number 
     * @param a: Complex number 
     * @param b: Complex number 
     * @return Complex number that contains the result after the operation has been executed
     */
    @Override
    public Complex execute(Complex a, Complex b) {
        //TODO: not insert 0+0j after alert
        if(b.getReal() == 0 && b.getImg() == 0){
            new AlertMessage("WRONG OPERATION");
          //showMessageDialog(null, "WRONG DIVISION");
          //throw new Exception("WRONG DIVISION");
        }
        double den=Math.pow(new Mod().execute(b).getReal(),2);
        return new Complex((a.getReal()*b.getReal()+a.getImg()*b.getImg())/den,(a.getImg()*b.getReal()-a.getReal()*b.getImg())/den);
    }
    
}
