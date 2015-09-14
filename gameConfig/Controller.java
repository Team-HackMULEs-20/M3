package gameConfig;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;

import java.util.Objects;
import java.util.ResourceBundle;
import java.net.URL;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Controller implements Initializable {

    @FXML
    private Button nextButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button nextButton2;

    @FXML
    private Button backButton;

    @FXML
    private ChoiceBox numPlayers;

    public static Integer playerNum;
    private Stage secondStage;
    private Stage thirdStage;
    private Stage fourthStage;
    private static int count;

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
        assert numPlayers != null : "fx:id=\"numPlayer\" was not injected: " +
                "check your FXML file 'M.U.LE Game Setup.fxml'.";
    }

    @FXML
    private void buttonClicked(ActionEvent e) {
        secondStage = new Stage();
        thirdStage = new Stage();
        fourthStage = new Stage();
        if (e.getSource() == nextButton) {
            playerNum = Integer.parseInt(numPlayers.getSelectionModel().getSelectedItem().toString());
            Launcher.primaryStage.setScene(Launcher.nextScene);
            Launcher.primaryStage.setTitle("Player 1 Configuration");
            count = 1;
        } else if (e.getSource() == cancelButton) {
            Launcher.primaryStage.close();
        }
    }

    @FXML
    private void buttonClicked2(ActionEvent e) {
        secondStage = new Stage();
        thirdStage = new Stage();
        fourthStage = new Stage();
        Stage newStage = new Stage();
        if (e.getSource() == nextButton2) {
            if (count == 1) {
                Launcher.primaryStage.setTitle("Player 2 Configuration");
                Launcher.primaryStage.toFront();
                count = 2;
            } else if (count == 2) {
                if (count == playerNum) {
                    Launcher.primaryStage.hide();
                    newStage.setScene(new Scene(new FlowPane(), 600, 400));
                    newStage.setTitle("Game Screen");
                    newStage.show();
                } else {
                    Launcher.primaryStage.setTitle("Player 3 Configuration");
                    Launcher.primaryStage.toFront();
                }
                count += 1;
            } else if (count == 3) {

                if (count == playerNum) {
                    Launcher.primaryStage.hide();
                    newStage.setScene(new Scene(new FlowPane(), 600, 400));
                    newStage.setTitle("Game Screen");
                    newStage.show();
                } else {
                    Launcher.primaryStage.setTitle("Player 4 Configuration");
                    Launcher.primaryStage.toFront();
                }
                count += 1;
            } else if (count == 4) {
                Launcher.primaryStage.hide();
                newStage.setScene(new Scene(new FlowPane(), 600, 400));
                newStage.setTitle("Game Screen");
                newStage.show();
            }

        } else if (e.getSource() == backButton) {
            Launcher.primaryStage.setScene(Launcher.rootScene);
            Launcher.primaryStage.setTitle("M.U.L.E. Game Setup");
        }
    }

}
