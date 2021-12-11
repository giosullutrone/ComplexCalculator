/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexcalculator;

import static complexcalculator.Configurator.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author awdrt
 */
public class ConfiguratorTest {
    
    @Test
    public void testGetRealoader() {
        FileOutputStream file=null;
        try {
            // Feedback
            System.out.println("Testing: Configurator.getReloader");
            // initialization
            String test="test.txt";
            file = new FileOutputStream("./configuration.txt");
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(test);
            output.close();
            String test2=getReloaderFile();
            new File("./configuration.txt").delete();
            assertEquals(test, test2);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConfiguratorTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            assertTrue(false);
        } finally {
            new File("./configuration.txt").delete();
            try {
                file.close();
            } catch (IOException ex) {
                assertTrue(false);
            }
        }
    }
    
    @Test
    public void testUpdateReloaderFile(){
         // Feedback
        System.out.println("Testing: Configurator.updateReloaderFile");
        // Var initialization
        String test="test.txt";
        String test2="";
        try {
            updateReloaderFile(test);
            FileInputStream file=new FileInputStream("./configuration.txt");
            ObjectInputStream input = new ObjectInputStream(file);
            test2=(String) input.readObject();
            input.close();
            new File("./configuration.txt").delete();
            assertEquals(test, test2);
        } catch(IOException | ClassNotFoundException e) {
            assertTrue(false);
        } finally {
            new File("./configuration.txt").delete();
        }
    }
}
    
    
    

    

