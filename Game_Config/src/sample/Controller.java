package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller extends Application {

    public void start(Stage primarystage) {
        try {
            GridPane page = FXMLLoader.load(Controller.class.getResource("sample.fxml"));
            Scene scene = new Scene(page);
            primarystage.setScene(scene);
            primarystage.show();
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void buttonClicked(ActionEvent event) {
        System.out.println("Yoooo something worked");
    }

}
