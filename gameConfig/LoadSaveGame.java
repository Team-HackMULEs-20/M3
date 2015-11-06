package gameConfig;

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
        return null;
    }
}
