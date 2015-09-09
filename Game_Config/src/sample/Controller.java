package sample;

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

    public static String players;

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
        assert numPlayers != null : "fx:id=\"numPlayers\" was not injected: " +
                "check your FXML file 'M.U.LE Game Setup.fxml'.";
    }

    @FXML
    private void buttonClicked(ActionEvent e) {
        if (e.getSource() == nextButton) {
            players = numPlayers.getSelectionModel().getSelectedItem().toString();
            Main.primaryStage.setScene(Main.nextScene);
        } else if (e.getSource() == cancelButton) {
            Main.primaryStage.close();
        } else {
            buttonClicked2(e, players);
        }

    }

    private void buttonClicked2(ActionEvent e, String players) {
        Stage newStage = new Stage();
        Stage thirdStage = new Stage();
        Stage fourthStage = new Stage();
        if (e.getSource() == nextButton2) {
            switch (players) {
                case "2":
                    Main.primaryStage.setScene(new Scene(new FlowPane(), 300, 300));
                    Main.primaryStage.setTitle("Player 1 Screen");
                    newStage.setScene(new Scene(new FlowPane(), 300, 300));
                    newStage.setTitle("Player 2 Screen");
                    newStage.show();
                    break;
                case "3":
                    Main.primaryStage.setScene(new Scene(new FlowPane(), 300, 300));
                    Main.primaryStage.setTitle("Player 1 Screen");
                    newStage.setScene(new Scene(new FlowPane(), 300, 300));
                    newStage.setTitle("Player 2 Screen");
                    newStage.show();
                    thirdStage.setScene(new Scene(new FlowPane(), 300, 300));
                    thirdStage.setTitle("Player 3 Screen");
                    thirdStage.show();
                    break;
                case "4":
                    Main.primaryStage.setScene(new Scene(new FlowPane(), 300, 300));
                    Main.primaryStage.setTitle("Player 1 Screen");
                    newStage.setScene(new Scene(new FlowPane(), 300, 300));
                    newStage.setTitle("Player 2 Screen");
                    newStage.show();
                    thirdStage.setScene(new Scene(new FlowPane(), 300, 300));
                    thirdStage.setTitle("Player 3 Screen");
                    thirdStage.show();
                    fourthStage.setScene(new Scene(new FlowPane(), 300, 300));
                    fourthStage.setTitle("Player 4 Screen");
                    fourthStage.show();
                    break;
            }
        } else if (e.getSource() == backButton) {
            Main.primaryStage.setScene(Main.rootScene);
        }
    }

}
