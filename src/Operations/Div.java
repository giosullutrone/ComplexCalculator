/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import Complex.Complex;
import javafx.scene.control.Alert;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author francesca
 */
public class Div implements Operation2{

    @Override
    public Complex execute(Complex a, Complex b) {
        
        if(b.getReal() == 0 && b.getImg() == 0){
            //Alert alert = new Alert(Alert.AlertType.ERROR);
            //alert.setTitle("Error Dialog");
            //alert.setHeaderText(null);
            //alert.setContentText("WRONG OPERATION");
            //alert.showAndWait();
          //showMessageDialog(null, "WRONG DIVISION");
          //throw new Exception("WRONG DIVISION");
        }
        double den=Math.pow(new Mod().execute(a).getReal(),2);
        return new Complex((a.getReal()*b.getReal()+a.getImg()*b.getImg())/den,(a.getImg()*b.getReal()-a.getReal()*b.getImg())/den);
    }
    
}
