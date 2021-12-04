/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexcalculator;


import AlertMessage.AlertConfirmation;
import AlertMessage.AlertFactory;
import AlertMessage.OperationException;
import AlertMessage.SyntaxException;
import Parser.DictFunction;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
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
    public static DictFunction display(DictFunction operations){
    
        //Generating pices of the interface
        Stage window = new Stage();
        ListView<String> opList = new ListView();
        
        //Updating the ListView
        opList.getItems().clear();
        for (String key :operations.keySet()){
            opList.getItems().add(key);
        }
                 
        //creating the text interfaces
        TextArea opArea= new TextArea();
        TextArea newOpArea = new TextArea();
        TextField nameOpField = new TextField();
        
        //Creating the buttons
        Button deleteOp = new Button("DELETE");
        Button modifyOp = new Button ("MODIFY");
        Button saveOp = new Button("SAVE");
        Button addOp = new Button("ADD");
        
        //Binding of the buttons
        deleteOp.disableProperty().bind(Bindings.createBooleanBinding( () -> (opArea.getText().isEmpty()), opArea.textProperty()));
        modifyOp.disableProperty().bind(Bindings.createBooleanBinding( () -> (opArea.getText().isEmpty()), opArea.textProperty()));
        addOp.disableProperty().bind(Bindings.createBooleanBinding( () -> (newOpArea.getText().isEmpty() || nameOpField.getText().isEmpty()), newOpArea.textProperty(), nameOpField.textProperty()));
        saveOp.setDisable(true);
        
        //Creating a context menu
        ContextMenu contextMenu = new ContextMenu();
        //Creating the menu Items for the context menu
        MenuItem saveMenu = new MenuItem("SAVE");
        MenuItem realoadMenu = new MenuItem("RELOAD");
        MenuItem clearMenu = new MenuItem("CLEAR");
        contextMenu.getItems().addAll(saveMenu, realoadMenu,clearMenu);
        
        opArea.setWrapText(true);
        newOpArea.setWrapText(true);
        
        //Setting hint text
        nameOpField.setPromptText("Name");
        newOpArea.setPromptText("Insert here the list of operation of the new custom operation usong space as separator");
        opArea.setPromptText("Select an existing user defined operation to see the corresponding list of operations");
        
        //Styling 
        window.setTitle("Custom Operation Manager");
        window.getIcons().add(
            new Image(
                ComplexCalculator.class.getResourceAsStream( "512Logo.png" )));
        
        //application logic
        
        //selection of the custom operation
        opList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
                String selectedItem = opList.getSelectionModel().getSelectedItem();
                try{
                    opArea.setText(operations.get(selectedItem));
                } catch (OperationException e) {
                    
                }
            }
        });
        
        //deleting of the selected operations
        deleteOp.setOnAction(new EventHandler<ActionEvent>(){
         public void handle(ActionEvent e)
            {
                opArea.setEditable(false);
                saveOp.setDisable(true);
                String selectedItem = opList.getSelectionModel().getSelectedItem();
                //allet cancellazzione sei sicuro?
                AlertConfirmation alert = new AlertConfirmation("Delete Confirm","Do you want to delete "+ selectedItem + "?");
                if(alert.state()== ButtonType.OK){  
                    operations.removeCascade(selectedItem);
                    opArea.setText("");
                }
                //Update the list deleting the operations
                opList.getItems().clear();
                for (String key :operations.keySet()){
                    opList.getItems().add(key);
                }
            } 
        });
        
        //Enable modify of the op area 
        modifyOp.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e)
            {
                opArea.setEditable(true);
                saveOp.setDisable(false);
            }
        });
        
        //Saves the modified operation
        saveOp.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e)
            {
                opArea.setEditable(false);
                //LOGIC BEHIND THE SAVE
                try {
                    operations.put(opList.getSelectionModel().getSelectedItem(),opArea.getText());
                } catch(SyntaxException putException) {
                    AlertFactory.handle(putException);
                }
                opList.getItems().clear();
                    for (String key :operations.keySet()){
                opList.getItems().add(key);
                }
                opArea.setText("");
                saveOp.setDisable(true);
                
            }
         });
        
        //Add a new operation
        addOp.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e)
            {
                //LOGIC BEHIND THE ADD
                try {
                operations.put(nameOpField.getText(), newOpArea.getText());
                } catch(SyntaxException putException) {
                    AlertFactory.handle(putException);
                }
                opList.getItems().clear();
                    for (String key :operations.keySet()){
                opList.getItems().add(key);
                newOpArea.setText("");
                nameOpField.setText("");
        }
            }
         });
        
        //Save on a file the operation list
        saveMenu.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e)
            {
            try {
                //LOGIC BEHIND THE SAVE ON FILE
                operations.toFile("UserDefined.txt");
            } catch (IOException ex) {
                Logger.getLogger(OperationManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
         });
        
        //Reload form a file the operation list
        realoadMenu.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e)
            {
            try {
                //LOGIC BEHIND THE RELOAD FROM FILE
                operations.fromFile("UserDefined.txt");
                opList.getItems().clear();
                    for (String key :operations.keySet()){
                opList.getItems().add(key);
                }
            } catch (IOException ex) {
                Logger.getLogger(OperationManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(OperationManager.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
         });
        
        //Clear the dict
        clearMenu.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e)
            {
                //LOGIC BEHIND THE DICT CLEAR
                operations.clear();
                opList.getItems().clear();
            }
        });
        
        //window managment
        
        opArea.setEditable(false);
        opList.setEditable(false);
        
        window.initModality(Modality.APPLICATION_MODAL); 
        
        //Adding the context menu to the list view
        opList.setContextMenu(contextMenu);
        
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
        modifyOp.setMaxWidth(Double.MAX_VALUE);
        saveOp.setMaxWidth(Double.MAX_VALUE);
        delBox.getChildren().addAll(opArea, deleteOp,modifyOp,saveOp);
        
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
        return operations;
    }
}
