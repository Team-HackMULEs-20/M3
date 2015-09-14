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

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("M.U.L.E Game Setup.fxml"));
            Parent child = FXMLLoader.load(getClass().getResource("playerSetup.fxml"));
            nextScene = new Scene(child);
            rootScene = new Scene(root, 600, 400);
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
