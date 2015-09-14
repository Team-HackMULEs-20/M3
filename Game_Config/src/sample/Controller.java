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

    @FXML
    private Button okButton;

    public static Integer playerNum;
    
    private static int count;

    private Stage newStage;

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
        assert okButton != null : "fx:id=\"okButton\" was not injected: " +
                "check your FXML file 'configError.fxml'.";
    }


    @FXML
    private void buttonClicked(ActionEvent e) throws NullPointerException {
        try {
            if (e.getSource() == nextButton) {
                playerNum = Integer.parseInt(numPlayers.getSelectionModel().getSelectedItem().toString());
                Main.primaryStage.setScene(Main.nextScene);
                Main.primaryStage.setTitle("Player 1 Configuration");
                count = 1;
            } else if (e.getSource() == cancelButton) {
                Main.primaryStage.close();
            }
        } catch (NullPointerException error){
            Main.primaryStage.setScene(Main.errorMessage);
        }

    }

    @FXML
    private void buttonClicked2(ActionEvent e) {
        newStage = new Stage();
        if (e.getSource() == nextButton2) {
            if (count == 1) {
                Main.primaryStage.setTitle("Player 2 Configuration");
                Main.primaryStage.toFront();
                count = 2;
            } else if (count == 2) {
                if (count == playerNum) {
                    Main.primaryStage.hide();
                    newStage.setScene(new Scene(new FlowPane(), 600, 400));
                    newStage.setTitle("Game Screen");
                    newStage.show();
                } else {
                    Main.primaryStage.setTitle("Player 3 Configuration");
                    Main.primaryStage.toFront();
                }
                count += 1;
            } else if (count == 3) {

                if (count == playerNum) {
                    Main.primaryStage.hide();
                    newStage.setScene(new Scene(new FlowPane(), 600, 400));
                    newStage.setTitle("Game Screen");
                    newStage.show();
                } else {
                    Main.primaryStage.setTitle("Player 4 Configuration");
                    Main.primaryStage.toFront();
                }
                count += 1;
            } else if (count == 4) {
                Main.primaryStage.hide();
                newStage.setScene(new Scene(new FlowPane(), 600, 400));
                newStage.setTitle("Game Screen");
                newStage.show();
            }

        } else if (e.getSource() == backButton) {
            Main.primaryStage.setScene(Main.rootScene);
            Main.primaryStage.setTitle("M.U.L.E. Game Setup");
        }
    }

    public void errorBox(ActionEvent event) {
        if (event.getSource() == okButton) {
                Main.primaryStage.setScene(Main.rootScene);
        }
    }

}
