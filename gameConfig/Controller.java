package gameConfig;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;

import java.awt.*;
import java.util.Objects;
import java.util.ResourceBundle;
import java.net.URL;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

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
    private ChoiceBox raceChoice;

    @FXML
    private Button okButton;

    @FXML
    private ChoiceBox mapType;

    @FXML
    private ChoiceBox difficulty;

    @FXML
    private TextField playerName;

    @FXML
    private ColorPicker colorPick;

    public static Integer numPlayer;
    public static String name;
    public static String race;
    public static String map;
    public static String level;
    private static int count;
    private static Color color;
    private Stage newStage;
    private Player[] players;
    private Turns gameTurns;

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
    private void buttonClicked(ActionEvent e) throws NullPointerException {
        try {
            if (e.getSource() == nextButton) {
                numPlayer = Integer.parseInt(numPlayers.getSelectionModel().getSelectedItem().toString());
                //initializing players array
                players = new Player[numPlayer];
                map = mapType.getSelectionModel().getSelectedItem().toString();
                level = difficulty.getSelectionModel().getSelectedItem().toString();
                Launcher.primaryStage.setScene(Launcher.nextScene);
                Launcher.primaryStage.setTitle("Player 1 Configuration");
                count = 1;
            } else if (e.getSource() == cancelButton) {
                Launcher.primaryStage.close();
            }
        } catch (NullPointerException error) {
            Launcher.primaryStage.setScene(Launcher.errorMessage);
        }
    }


    @FXML
    private void buttonClicked2(ActionEvent e) throws NullPointerException {
        newStage = new Stage();
        try {
            if (e.getSource() == nextButton2) {

                name = playerName.getText();
                race = raceChoice.getSelectionModel().getSelectedItem().toString();
                if (race.length() > 8) {
                    race = race.toUpperCase().substring(0, race.indexOf(" "));
                } else {
                    race = race.toUpperCase();
                }
                Player.Race r = Player.Race.valueOf(race);
                color = colorPick.getValue();

                //creating Player
                Player p = new Player(count, name, r, color);
                players[count-1] = p;
                if (players[players.length-1] != null) {

                    //when players array is full, begins game turns
                    gameTurns = new Turns(players);
                }

                if (name.equals("")) {
                    Launcher.primaryStage.setScene(Launcher.errorMessage);
                }
                if (count == 1) {
                    Launcher.primaryStage.setTitle("Player 2 Configuration");
                    Launcher.primaryStage.toFront();
                    playerName.clear();
                    count = 2;
                } else if (count == 2) {
                    if (count == numPlayer) {
                        Launcher.primaryStage.hide();
                        newStage.setScene(new Scene(new FlowPane(), 600, 400));
                        newStage.setTitle("Game Screen");
                        newStage.show();
                    } else {
                        Launcher.primaryStage.setTitle("Player 3 Configuration");
                        Launcher.primaryStage.toFront();
                        playerName.clear();
                    }
                    count += 1;
                } else if (count == 3) {
                    if (count == numPlayer) {
                        Launcher.primaryStage.hide();
                        newStage.setScene(new Scene(new FlowPane(), 600, 400));
                        newStage.setTitle("Game Screen");
                        newStage.show();
                    } else {
                        Launcher.primaryStage.setTitle("Player 4 Configuration");
                        Launcher.primaryStage.toFront();
                        playerName.clear();
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
        } catch (NullPointerException error) {
            Launcher.primaryStage.setScene(Launcher.errorMessage);
        }
    }

    public void errorBox(ActionEvent event) {
        if (event.getSource() == okButton) {
            Launcher.primaryStage.setScene(Launcher.rootScene);
        }
    }
}