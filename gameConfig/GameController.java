package gameConfig;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by findleyck on 9/21/15.
 */
public class GameController implements Initializable {

    @FXML
    private Button startButton;

    private static Stage start;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert startButton != null : "fx:id=\"startButton\" was not injected: " +
                "check your FXML file ''.";
    }

    public static void beginTurn() {
        // show start turn window (stage will be made in launcher
        // when timer ends (or end button is pressed) this window should pop up
        start = new Stage();
        start.setScene(Launcher.playerStart);
        start.setTitle(Turns.getNextTurn().getName() + "'s turn");
        start.show();
    }

    @FXML
    public void startTurnButton(ActionEvent event) {
        if (event.getSource() == startButton) {
            Timer timer = new Timer(Turns.timeForTurn(Turns.getNextTurn()));
            timer.start(new Stage());
            start.close();
        }
    }
}
