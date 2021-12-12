package complexcalculator;


import AlertMessage.*;
import Dict.DictFunction;
import static complexcalculator.Configurator.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class OperationManager {
    
    
    /**
     * method to manually create a pop-up for the operation manage
     * requires the operation dict
     * 
     * @param operations
     * @return 
     */
    public static DictFunction display(DictFunction operations){
        //Generating pices of the interface
        Stage window = new Stage();
        ListView<String> opList = new ListView();
        List<Integer> flag = new ArrayList<>();
        
        //Updating the ListView
        opList.getItems().clear();
        opList.getItems().addAll(operations.keyList());
        opList.setEditable(true);
        
        //creating the text interfaces
        TextArea opArea= new TextArea();
        TextArea newOpArea = new TextArea();
        TextField nameOpField = new TextField();
        TextField renameOpField = new TextField();
        
        //Creating the buttons
        Button renameOp = new Button("RENAME");
        Button deleteOp = new Button("DELETE");
        Button modifyOp = new Button ("MODIFY");
        Button saveOp = new Button("SAVE");
        Button addOp = new Button("ADD");
        
        //Binding of the buttons
        renameOp.disableProperty().bind(Bindings.createBooleanBinding( () -> (renameOpField.getText().isEmpty() || !saveOp.isDisabled()), renameOpField.textProperty() , saveOp.disabledProperty()));
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
        renameOpField.setPromptText("Select to rename");
        nameOpField.setPromptText("Insert name here");
        newOpArea.setPromptText("Insert here the list of operations or numbers using space as separator");
        opArea.setPromptText("Select an existing user defined operation to see the corresponding list of operations");
        
        //Styling 
        nameOpField.setStyle("-fx-background-radius: 10;");
        window.setTitle("Custom Operation Manager");
        window.getIcons().add(
            new Image(
                ComplexCalculator.class.getResourceAsStream( "512Logo.png" )));
        
        //APPLICATION LOGIC
        //selection of the custom operation
        opList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
                String selectedItem = opList.getSelectionModel().getSelectedItem();
                try{
                    opArea.setText(operations.get(selectedItem));
                    renameOpField.setText(selectedItem);
                    renameOpField.setEditable(true);
                } catch (OperationException e) {
                }
            }
        });
        
        
        renameOp.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String selectedItem = opList.getSelectionModel().getSelectedItem();
                String renamedItem = renameOpField.getText();
                renameOpField.setEditable(false);
                try{
                    operations.renameCascade(selectedItem, renamedItem);
                    renameOpField.setText("");
                    opArea.setText("");
                }catch(OperationException ex){
                     AlertFactory.handle(ex);
                }catch(SyntaxException ex){
                     AlertFactory.handle(ex);
                }
                //Update the list
                opList.getItems().clear();
                opList.getItems().addAll(operations.keyList());
                flag.add(1);
            }    
        });
        
        //deleting of the selected operations
        deleteOp.setOnAction(new EventHandler<ActionEvent>(){
         @Override
         public void handle(ActionEvent e)
            {
                opArea.setEditable(false);
                saveOp.setDisable(true);
                String selectedItem = opList.getSelectionModel().getSelectedItem();
                //alert delete
            if(selectedItem != null){
                AlertConfirmation alert = new AlertConfirmation("Delete Confirm","Do you want to delete "+ selectedItem + "?");
                if(alert.state()== ButtonType.OK){  
                    operations.removeCascade(selectedItem);
                    opArea.setText("");
                    renameOpField.setText("");
                    renameOpField.setEditable(false);
                }
                //Update the list deleting the operations
                opList.getItems().clear();
                opList.getItems().addAll(operations.keyList());
                flag.add(1);
            } 
            }
        });
        
        //Enable modify of the op area 
        modifyOp.setOnAction(new EventHandler<ActionEvent>(){
         @Override
        public void handle(ActionEvent e)
            {
                opArea.setEditable(true);
                saveOp.setDisable(false);
            }
        });
        
        //Saves the modified operation
        saveOp.setOnAction(new EventHandler<ActionEvent>(){
         @Override
        public void handle(ActionEvent e)
            {
                opArea.setEditable(false);
                try {
                    operations.replace(opList.getSelectionModel().getSelectedItem(),opArea.getText());
                } catch(SyntaxException putException) {
                    AlertFactory.handle(putException);
                }
                opList.getItems().clear();
                opList.getItems().addAll(operations.keyList());
                opArea.setText("");
                renameOpField.setText("");
                saveOp.setDisable(true);
                renameOpField.setEditable(false);
                flag.add(1);
            }
         });
        
        //Add a new operation
        addOp.setOnAction(new EventHandler<ActionEvent>(){
         @Override
        public void handle(ActionEvent e)
            {
                //LOGIC BEHIND THE ADD
                try {
                operations.put(nameOpField.getText(), newOpArea.getText());
                newOpArea.setText("");
                nameOpField.setText("");
                renameOpField.setText("");
                opArea.setText("");
                flag.add(1);
                } catch(SyntaxException putException) {
                    AlertFactory.handle(putException);
                }
                opList.getItems().clear();
                opList.getItems().addAll(operations.keyList());  
            }
            
        });
        
        //Save on a file the operation list
        saveMenu.setOnAction(new EventHandler<ActionEvent>(){
         @Override
        public void handle(ActionEvent e)
            {
            try {
                //LOGIC BEHIND THE SAVE ON FILE
                String filePath=fileChooserManager(false);
                operations.toFile(filePath);
                updateReloaderFile(filePath);
            } catch (IOException ex) {
                Logger.getLogger(OperationManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex){
            } catch (OperationException ex){
                     AlertFactory.handle(ex);
            }
            }
         });
        
        //Reload form a file the operation list
        realoadMenu.setOnAction(new EventHandler<ActionEvent>(){
         @Override
        public void handle(ActionEvent e)
            {
            try {
                //LOGIC BEHIND THE RELOAD FROM FILE
                operations.fromFile(fileChooserManager(true));
                opList.getItems().clear();
                opList.getItems().addAll(operations.keyList());
                
            } catch (IOException |ClassNotFoundException ex) {
               new AlertMessage("Operation error","An error occurred while reading the file");
            } catch (NullPointerException ex){ 
            }
            }
        });
        
        //Clear the dict
        clearMenu.setOnAction(new EventHandler<ActionEvent>(){
         @Override
        public void handle(ActionEvent e)
            {
                //LOGIC BEHIND THE DICT CLEAR
                 AlertConfirmation alert = new AlertConfirmation("Clear Confirm","Do you want to clear all operations ?");
                if(alert.state()== ButtonType.OK){  
                    operations.clear();
                    opList.getItems().clear();
                    opArea.setText("");
                    renameOpField.setText("");
                    renameOpField.setEditable(false);
                }
            }
        });
        
        //create a pop up of comfirmation of the exit
        //TO DO: verify if file is modified
        window.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event) {
                //LOGIC BEHIND THE POP-UP CLOSING
                boolean eye= false;
                if(!flag.isEmpty())
                {
                    AlertConfirmation alert = new AlertConfirmation("Save Reminder","Do you want to save on file before exit?", 2);
                    ButtonType state =alert.state();
                    if(state == alert.buttonTypeCancel){
                        event.consume();
                    }
                    else
                        if(state == alert.buttonTypeSave){
                            try {
                                String filePath=fileChooserManager(false);
                                operations.toFile(filePath);
                                updateReloaderFile(filePath);
                            } catch (IOException ex) {
                                Logger.getLogger(OperationManager.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (OperationException ex){
                                AlertFactory.handle(ex);
                                event.consume();
                                eye = true;
                            } catch (NullPointerException ex){
                                event.consume();
                                eye = true;
                            }
                        
                            if(!eye)
                                window.close();
                        }
                        if(state == alert.buttonTypeNotSave){
                            window.close();
                        }
                }else
                    window.close();  
            }   
            });
        
        //window managment
        opArea.setEditable(false);
        opList.setEditable(false);
        window.initModality(Modality.APPLICATION_MODAL); 
        
        //Adding the context menu to the list view
        opList.setContextMenu(contextMenu);
        
        //SETTING DIMENSION OF THE ELEMENTS
        
        //LIST
        opList.setPrefSize(0, 0);
        
        //OP_AREA & OP_BUTTONS
        renameOp.setPrefSize(60,25);
        renameOpField.setPrefSize(200,26);
        deleteOp.setPrefSize(260, 25);
        modifyOp.setPrefSize(260, 25);
        saveOp.setPrefSize(260, 25);
        opArea.setMaxWidth(260);
        
        //NEW_OP_AREA
        newOpArea.setPrefSize(292, 69);
        
        //NAME_FIELD
        nameOpField.setPrefSize(170, 33);
        
        //ADD_BUTTON
        addOp.setPrefSize(170, 25);
        
        //MAIN_PANE
        AnchorPane main = new AnchorPane();
        main.setStyle("-fx-background-color:#282a36");
        
        //adding things to the main pane
        main.getChildren().addAll(opList,deleteOp, modifyOp, saveOp, newOpArea,nameOpField, addOp, opArea, renameOp, renameOpField);
        
        //Setting all the anchors
        
        //LIST
        AnchorPane.setTopAnchor(opList, 15.0);
        AnchorPane.setLeftAnchor(opList, 15.0);
        AnchorPane.setBottomAnchor(opList, 110.0);
        AnchorPane.setRightAnchor(opList, 285.0);
        
        //RENAME_BUTTON
        AnchorPane.setTopAnchor(renameOp, 15.0);
        AnchorPane.setRightAnchor(renameOp, 15.0);
        
        //RENAME_FIELD
        AnchorPane.setTopAnchor(renameOpField, 15.0);
        AnchorPane.setRightAnchor(renameOpField, 75.0);
        
        //DELETE_BUTTON
        AnchorPane.setBottomAnchor(deleteOp, 185.0);
        AnchorPane.setRightAnchor(deleteOp, 15.0);
        
        //MODIFY_BUTTON
        AnchorPane.setBottomAnchor(modifyOp, 150.0);
        AnchorPane.setRightAnchor(modifyOp, 15.0);
        
        //SAVE_BUTTON
        AnchorPane.setBottomAnchor(saveOp, 115.0);
        AnchorPane.setRightAnchor(saveOp, 15.0);
        
        //NEW_OP_AREA
        AnchorPane.setLeftAnchor(newOpArea, 15.0);
        AnchorPane.setBottomAnchor(newOpArea, 30.0);
        AnchorPane.setRightAnchor(newOpArea, 195.0);
        
        //NAME_OP_FIELD
        AnchorPane.setBottomAnchor(nameOpField, 65.0);
        AnchorPane.setRightAnchor(nameOpField, 15.0);
        
        //ADD_BUTTON
        AnchorPane.setBottomAnchor(addOp, 30.0);
        AnchorPane.setRightAnchor(addOp, 15.0);
        
        //OP_AREA   
        AnchorPane.setTopAnchor(opArea, 55.0);
        AnchorPane.setBottomAnchor(opArea, 220.0);
        AnchorPane.setRightAnchor(opArea, 15.0);
        
        Scene scene = new Scene(main, 500, 400);
        scene.getStylesheets().add(OperationManager.class.getResource("Style.css").toExternalForm());
        window.setScene(scene);
        window.showAndWait();
        return operations;
    }

}
