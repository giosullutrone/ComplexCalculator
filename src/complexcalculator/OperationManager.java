/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexcalculator;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * 
 */
public class OperationManager {
    /**
     * method to manualy create a pop-up for the operation manage
     * requires the operation dict
     * 
     * @param operations
     * @return 
     */
    public static String display(String operations){
    
        //Generating pices of the interface
        Stage window = new Stage();
        ListView<String> opList = new ListView();
        TextArea opArea= new TextArea();
        TextArea newOpArea = new TextArea();
        TextField nameOpField = new TextField();
        Button deleteOp = new Button("DELETE");
        Button addOp = new Button("ADD");
        
        opArea.setWrapText(true);
        newOpArea.setWrapText(true);
        
        //Setting hint text
        nameOpField.setPromptText("Name");
        newOpArea.setPromptText("Insert here the list of operation of the new custom operation");
        opArea.setPromptText("Select an existing user defined operation to see the corresponding list of operations");
        
        //Styling 
        window.setTitle("Custom Operation Manager");
        window.getIcons().add(
            new Image(
                ComplexCalculator.class.getResourceAsStream( "512Logo.png" )));
        
        //application logic
            //TODO
        
        
        //window managment
        opArea.setEditable(false);
        opList.setEditable(false);
        
        window.initModality(Modality.APPLICATION_MODAL); 
        
        VBox mainBox = new VBox(10);
        mainBox.setStyle("-fx-background-color:#282a36");
        mainBox.setPadding(new Insets(20, 20 , 20 , 20));
        
        //TOP PART OF THE INTERFACE
        HBox topBox = new HBox(10);
        topBox.setMinSize(200, 200);
        //creating the little VBOX for delete
        VBox delBox = new VBox(10);
        opList.setMinSize(150, 200);
        delBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        deleteOp.setMaxWidth(Double.MAX_VALUE);
        delBox.getChildren().addAll(opArea, deleteOp);
        //adding elements to the top hbox
        topBox.getChildren().addAll(opList, delBox);
        
        //BOTTOM PART OF THE INTERFACE
        HBox bottomBox = new HBox(10);
        //creating the little VBOX for add
        VBox addBox = new VBox(10);
        addBox.getChildren().addAll(nameOpField, addOp);
        
        //adding elements to the bottom hbox
        bottomBox.getChildren().addAll(newOpArea, addBox);
        newOpArea.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        addBox.setMinSize(100, 100);
        addOp.setMaxWidth(Double.MAX_VALUE);
        //adding the top and the bottom part to the vbox
        mainBox.getChildren().addAll(topBox, bottomBox);
        
        Scene scene = new Scene(mainBox, 500, 350);
        scene.getStylesheets().add(OperationManager.class.getResource("Style.css").toExternalForm());
        window.setScene(scene);
        window.showAndWait();
        return "";
    }
}
