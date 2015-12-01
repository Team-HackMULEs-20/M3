package gameConfig;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.*;
import sun.audio.*;

public class Launcher extends Application {

    public static Scene nextScene;
    public static Scene rootScene;
    public static Stage primaryStage;
    public static Scene errorMessage;
    private static Scene oreErrorScene;

    /**
     *
     * @param primaryStage the main stage of the game
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("UIFiles/M.U.L.E Game Setup.fxml"));
            Parent child = FXMLLoader.load(getClass().getResource("UIFiles/playerSetup.fxml"));
            Parent error = FXMLLoader.load(getClass().getResource("UIFiles/configError.fxml"));
            Parent oreError = FXMLLoader.load(getClass().getResource("UIFiles/oreShortageError.fxml"));
            errorMessage = new Scene(error);
            nextScene = new Scene(child);
            rootScene = new Scene(root, 600, 400);
            oreErrorScene = new Scene(oreError);
            Launcher.primaryStage = primaryStage;
            primaryStage.setTitle("M.U.L.E. Game Setup");
            primaryStage.setScene(rootScene);
            primaryStage.show();

            InputStream inputStream = getClass().getResourceAsStream("UIFiles/Media/itAlwaysTakes.wav");
		    AudioStream audioStream = new AudioStream(inputStream);
		    AudioPlayer.player.start(audioStream);
        } catch (Exception ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
