package gameConfig;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Launcher extends Application {

    public static Scene nextScene;
    public static Scene rootScene;
    public static Stage primaryStage;
    public static Scene errorMessage;
    public static Scene gameScene;
    public static Scene townScene;
    public static Scene startScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("M.U.L.E Game Setup.fxml"));
            Parent child = FXMLLoader.load(getClass().getResource("playerSetup.fxml"));
            Parent error = FXMLLoader.load(getClass().getResource("configError.fxml"));
            Parent gameRoot = FXMLLoader.load(getClass().getResource("MainMap.fxml"));
            Parent town = FXMLLoader.load(getClass().getResource("TownMap.fxml"));
            Parent startWindow = FXMLLoader.load(getClass().getResource("playerStart.fxml"));
            startScene = new Scene(startWindow);
            errorMessage = new Scene(error);
            nextScene = new Scene(child);
            rootScene = new Scene(root, 600, 400);
            gameScene = new Scene(gameRoot);
            townScene = new Scene(town);
            Launcher.primaryStage = primaryStage;
            primaryStage.setTitle("M.U.L.E. Game Setup");
            primaryStage.setScene(rootScene);
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
