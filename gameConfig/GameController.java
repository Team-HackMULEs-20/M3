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
                "check your FXML file 'playerStart.fxml'.";
    }

    @FXML
    public static void beginTurn() {
        start = new Stage();
        start.setScene(Launcher.startScene);
        start.setTitle(Turns.getTurn().getName() + "'s Turn");
        start.show();
    }

    public void startButtonClicked(ActionEvent event) {
        if (event.getSource() == startButton) {
            Timer timer = new Timer(Turns.timeForTurn(Turns.getTurn()));
            timer.start(new Stage());
            start.close();
        }
    }
}
