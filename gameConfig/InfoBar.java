package gameConfig;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Objects;

public class InfoBar {

    private Stage infoStage;
    private final Label moneyLeft = new Label();
    private final Label foodLeft = new Label();
    private final Label currRound = new Label();
    private final Label energyLeft = new Label();
    private final Label oreLeft = new Label();
    private final Label currPlayer = new Label();
    private final Label crystiteLeft = new Label(); //added
    private final Label numMules = new Label(); //added
    public static final Label timerLabel = new Label();
    public static final Button endButton = new Button("End Turn");


    public InfoBar() {
        infoStage = new Stage();
        Player p = Turns.getTurn();
        //infoBarCreated = true;
        infoStage.setTitle("Information Bar");
        infoStage.setAlwaysOnTop(true);
        Group t2 = new Group();
        Scene scene2 = new Scene(t2, 600, 140);

        timerLabel.setFont(new Font("American Typewriter Bold", 30));

        currRound.setText("Round " + Turns.rounds);
        currRound.setFont(new Font("American Typewriter Bold", 18));

        currPlayer.setText("It is " + p.getName() + "'s Turn");
        currPlayer.setFont(new Font("American Typewriter Bold", 18));
        if (!Objects.equals(p.getColor(), Color.WHITE.toString())) {
            currPlayer.setTextFill(Color.valueOf(p.getColor()));
        } else {
            currPlayer.setTextFill(Color.valueOf(p.getColor()));
            currPlayer.setBackground(new Background(new BackgroundFill(Color.BLACK,
                    CornerRadii.EMPTY, Insets.EMPTY)));
        }


        moneyLeft.setText("Money: " + p.getMoney());
        moneyLeft.setFont(new Font("American Typewriter", 15));

        foodLeft.setText("Food: " + p.getFood());
        foodLeft.setFont(new Font("American Typewriter", 15));

        energyLeft.setText("Energy: " + p.getEnergy());
        energyLeft.setFont(new Font("American Typewriter", 15));

        oreLeft.setText("Ore: " + p.getOre());
        oreLeft.setFont(new Font("American Typewriter", 15));
        
        crystiteLeft.setText("Crystite: " + p.getCrystite()); //Added
        crystiteLeft.setFont(new Font("American Typewriter", 15)); // added

        numMules.setText("Mules Owned: " + p.mulesOwned.size()); //added
        numMules.setFont(new Font("American Typewriter", 15)); //added

        Label l1 = new Label("                   ");
        Button saveGame = new Button("Save Game");
        Button endGame = new Button(" End Game");
        Label l5 = new Label("                   ");
        Label l4 = new Label(" Timer");
        l4.setFont(new Font("American Typewriter Bold", 18));

        saveGame.setOnAction((ActionEvent e) -> {
            LoadSaveGame.save();
            System.out.println("Game saved");
        });

        Stage newStage = new Stage();
        Label message = new Label("Would you like to save your progress first?");
        message.setFont(new Font("American Typewriter", 15));
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        Button cancel = new Button(("Cancel"));
        GridPane yesNoGrid = new GridPane();
        yesNoGrid.add(message, 1, 0);
        yesNoGrid.add(yesButton, 0, 1);
        yesNoGrid.add(noButton, 1, 1);
        yesNoGrid.add(cancel, 2, 1);
        newStage.setScene(new Scene(yesNoGrid));
        String[] reply = new String[1];

        yesButton.setOnAction((ActionEvent e) -> {
            reply[0] = "true";
            newStage.close();
        });
        noButton.setOnAction((ActionEvent e) -> {
            reply[0] = "false";
            newStage.close();
        });
        cancel.setOnAction((ActionEvent e) -> {
            reply[0] = "cancel";
            newStage.close();
        });
        endGame.setOnAction((ActionEvent e) -> {
            newStage.showAndWait();
            if (Objects.equals(reply[0], "true")) {
                LoadSaveGame.save();
                System.exit(0);
            } else if (Objects.equals(reply[0], "false")) {
                System.exit(0);
            } else {
                newStage.close();
            }
        });

        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(20);
        grid2.setVgap(10);
        grid2.add(l1, 1, 0);
        grid2.add(currPlayer, 2, 0);
        grid2.add(currRound, 4, 0);
        grid2.add(saveGame, 1, 1);
        grid2.add(moneyLeft, 2, 1);
        grid2.add(foodLeft, 4, 1);
        grid2.add(endGame, 1, 2);
        grid2.add(energyLeft, 2, 2);
        grid2.add(oreLeft, 4, 2);
        grid2.add(l5, 1,3);
        grid2.add(crystiteLeft, 2, 3);
        grid2.add(numMules,4, 3);
        grid2.add(timerLabel, 5, 1);
        grid2.add(endButton, 5, 2);
        grid2.add(l4, 5, 0);
        t2.getChildren().add(grid2);

        infoStage.setScene(scene2);
        infoStage.show();
        infoStage.toFront();
    }

    public void updateInfoBar() {
        infoStage = new Stage();
        Player p = Turns.getTurn();

        currRound.setText("Round " + Turns.rounds);
        currRound.setFont(new Font("American Typewriter Bold", 18));

        currPlayer.setText("It is " + p.getName() + "'s Turn");
        currPlayer.setFont(new Font("American Typewriter Bold", 18));
        if (!Objects.equals(p.getColor(), Color.WHITE.toString())) {
            currPlayer.setTextFill(Color.valueOf(p.getColor()));
            currPlayer.setBackground(new Background(new BackgroundFill(Color.WHITE,
                    CornerRadii.EMPTY, Insets.EMPTY)));
        } else {
            currPlayer.setTextFill(Color.valueOf(p.getColor()));
            currPlayer.setBackground(new Background(new BackgroundFill(Color.BLACK,
                    CornerRadii.EMPTY, Insets.EMPTY)));
        }

        moneyLeft.setText("Money: " + p.getMoney());
        //System.out.println("in info bar "+ p.getName() + " " + p.getMoney());
        moneyLeft.setFont(new Font("American Typewriter", 15));

        foodLeft.setText("Food: " + p.getFood());
        foodLeft.setFont(new Font("American Typewriter", 15));

        energyLeft.setText("Energy: " + p.getEnergy());
        energyLeft.setFont(new Font("American Typewriter", 15));

        oreLeft.setText("Ore: " + p.getOre());
        oreLeft.setFont(new Font("American Typewriter", 15));
        
        crystiteLeft.setText("Crystite: " + p.getCrystite());
        crystiteLeft.setFont(new Font("American Typewriter", 15));

        numMules.setText("Mules Owned: " + p.mulesOwned.size()); //added
        numMules.setFont(new Font("American Typewriter", 15)); //added
        
        //System.out.println("INFO BAR UPDATED");

        if (Turns.rounds + 1 == 14) {
            infoStage.close();
        }
    }
}
