package complexcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ComplexCalculator extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("Layout.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Complex Calculator");
        stage.getIcons().add(
            new Image(
                ComplexCalculator.class.getResourceAsStream( "512Logo.png" ))); 
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
