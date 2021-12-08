package complexcalculator;

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

public class Configurator {
    
    /**
     * Read from the configuration file the name of the name of the file to execute the reload
     * 
     * @return String -> the name of the filePath to reload 
     */
    public static String getReloaderFile(){
        try{
            FileInputStream fileStream = new FileInputStream("configuration.txt");
            ObjectInputStream input = new ObjectInputStream(fileStream);
            String file = (String) input.readObject();
            return file;
        }catch (FileNotFoundException ex) {
            File f = new File("configuration.txt");
            return "UserDefined.txt";
        }catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "UserDefined.txt";
    }
    
    /**
     * Update the configuration file inserting in it the filepath 
     * 
     * @param filePath 
     */
    public static void updateReloaderFile(String filePath){
        try{
            FileOutputStream file = new FileOutputStream("configuration.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(filePath);
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
        } catch (EOFException | FileNotFoundException ex) {
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dictFun;
    }
}
