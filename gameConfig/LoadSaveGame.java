package gameConfig;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadSaveGame {

    private LoadSaveGame() { //created for checkstyle

    }

    public static void save() {
        try {
            Land[][] landPlots = Controller.landPlots;
            String currentLevel = Controller.level;
            Store currentStore = StoreController.store;
            Player[] currentPlayers = Controller.players;
            int passes = GameController.numPasses;
            int currentRound = Turns.rounds;
            FileOutputStream fos = new FileOutputStream("saveGame.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(landPlots);
            oos.writeUTF(currentLevel);
            oos.writeObject(currentStore);
            oos.writeObject(currentPlayers);
            oos.writeInt(passes);
            oos.writeInt(currentRound);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Object> load() {
        try {
            List<Object> data = new ArrayList<>();
            FileInputStream fis = new FileInputStream("saveGame.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Land[][] plots = (Land[][]) ois.readObject();
            String level = ois.readUTF();
            Store store = (Store) ois.readObject();
            Player[] players = (Player[]) ois.readObject();
            int passes = ois.readInt();
            int round = ois.readInt();
            data.add(plots);
            data.add(level);
            data.add(store);
            data.add(players);
            data.add(passes);
            data.add(round);
            ois.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    
    public static void messageBox() {
        Stage savedStage = new Stage();
        savedStage.setTitle("Saved");
        savedStage.setAlwaysOnTop(true);
        Group t = new Group();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        Label errorLabel = new Label("Your game has been successfully saved");
        errorLabel.setFont(new Font("American Typewriter", 15));
        Button errorButton = new Button("Ok");
        errorButton.setFont(new Font("American Typewriter", 17));
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.add(errorButton, 0, 0);
        grid.add(errorLabel, 1, 0);
        grid.add(grid2, 1, 1);
        t.getChildren().add(grid);
        Scene errorScene = new Scene(t);
        savedStage.setScene(errorScene);
        savedStage.show();
        savedStage.toFront();
        errorButton.setOnAction((ActionEvent e) -> savedStage.close());
    }
}
