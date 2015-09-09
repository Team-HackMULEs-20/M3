package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import java.net.URL;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class Controller implements Initializable {

    @FXML
    private Button nextButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button nextButton2;

    @FXML
    private Button backButton;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert nextButton != null : "fx:id=\"nextButton\" was not injected: " +
                "check your FXML file 'M.U.L.E Game Setup.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: " +
                "check your FXML file 'M.U.L.E Game Setup.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: " +
                "check your FXML file 'playerSetup.fxml'.";
        assert nextButton2 != null : "fx:id=\"nextButton2\" was not injected: " +
                "check your FXML file 'playerSetup.fxml'.";
    }


    @FXML
    private void buttonClicked(ActionEvent e) {
        if (e.getSource() == nextButton) {
            Main.primaryStage.setScene(Main.nextScene);
        } else if (e.getSource() == nextButton2) {
            Main.primaryStage.setScene(new Scene(new FlowPane(), 300, 300));
        } else if (e.getSource() == backButton) {
            Main.primaryStage.setScene(Main.rootScene);
        } else if (e.getSource() == cancelButton) {
            Main.primaryStage.close();
        }

    }

}
