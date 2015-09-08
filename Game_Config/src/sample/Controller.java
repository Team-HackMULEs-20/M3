package sample;

<<<<<<< HEAD
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import java.net.URL;

public class Controller implements Initializable {

    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

=======
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.control.Button;

public class Controller implements Initializable {

    @FXML
    private Button nextButton;

    @FXML
    private Button cancelButton;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert nextButton != null : "fx:id=\"nextButton\" was not injected: " +
                "check your FXML file 'M.U.L.E Game Setup.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: " +
                "check your FXML file 'M.U.L.E Game Setup.fxml'.";
        nextButton.setOnAction(e -> buttonClicked(e));
        cancelButton.setOnAction(e -> buttonClicked(e));
    }


    @FXML
    private void buttonClicked(ActionEvent e) {
        if (e.getSource() == nextButton) {
            System.out.println("Next Button was pressed");
        } else if (e.getSource() == cancelButton) {
            System.out.println("Cancel Button was pressed");
        }
    }
>>>>>>> master

    }
}
