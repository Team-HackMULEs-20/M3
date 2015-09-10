package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {

<<<<<<< HEAD:Game_Config/sample/Main.java
=======
    public static Scene nextScene;
    public static Scene rootScene;
    public static Stage primaryStage;

    @Override
>>>>>>> origin/kfindley7:Game_Config/src/sample/Main.java
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("M.U.L.E Game Setup.fxml"));
<<<<<<< HEAD:Game_Config/sample/Main.java
            Parent child = FXMLLoader.load(getClass().getResource("playerSetup.fxml"));
            Scene nextScreen = new Scene(child);
=======
            Parent nextScreen = FXMLLoader.load(getClass().getResource("playerSetup.fxml"));
            nextScene = new Scene(nextScreen);
            rootScene = new Scene(root, 600, 400);
            Main.primaryStage = primaryStage;
>>>>>>> origin/kfindley7:Game_Config/src/sample/Main.java
            primaryStage.setTitle("M.U.L.E. Game Setup");
            primaryStage.setScene(rootScene);
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
