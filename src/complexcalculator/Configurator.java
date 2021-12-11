package complexcalculator;

import AlertMessage.OperationException;
import Parser.DictFunction;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;

public class Configurator {
    
    /**
     * Read from the configuration file the name of the name of the file to execute the reload
     * 
     * @return String -> the name of the filePath to reload 
     */
    public static String getReloaderFile(){
        try{
            FileInputStream fileStream = new FileInputStream("./configuration.txt");
            ObjectInputStream input = new ObjectInputStream(fileStream);
            String file = (String) input.readObject();
            input.close();
            return file;
        }catch (FileNotFoundException ex) {
            File f = new File("./configuration.txt");
        }catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Update the configuration file inserting in it the filepath 
     * 
     * @param filePath 
     */
    public static void updateReloaderFile(String filePath){
        try{
            FileOutputStream file = new FileOutputStream("./configuration.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(filePath);
            output.close();
        }catch (FileNotFoundException ex){
        }catch (IOException ex) {

        }
    }
    
    /**
     * Return the DictFunctionfrom the last file
     * 
     * @return DictFunction ->  Function dictionary populated
     */
    public static DictFunction startConfiguration(){
        DictFunction dictFun = new DictFunction();
        try {
            String filePath = getReloaderFile();
            dictFun.fromFile(filePath);
        } catch (EOFException | FileNotFoundException |NullPointerException ex) {
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dictFun;
    }
    
    /**
    * Opens a pop up for the user to make him select or create a file
    * 
    * @param mode false for file creatore true for file chooser
    * 
    * @return (String) the path of the selected file or null if fails
    */
    public static String fileChooserManager(boolean mode){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("./"));
        File selectedFile;
        if(mode)
            selectedFile = fc.showOpenDialog(null);
        else
            selectedFile = fc.showSaveDialog(null);
        try{
            String path = selectedFile.getAbsolutePath();
            if(path.contains("configuration.txt")) {
                throw new OperationException("Protected File");
            }
            else return path;       
        }catch(NullPointerException ex){
        }
        return null;
    }
}
