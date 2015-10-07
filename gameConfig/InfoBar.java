package gameConfig;

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

/**
 * Created by jessicahoffman on 10/7/15.
 */
public class InfoBar {
    private Stage infoStage;
    private Label moneyLeft = new Label();
    private Label foodLeft = new Label();
    private Label currRound = new Label();
    private Label energyLeft = new Label();
    private Label oreLeft = new Label();
    private Label currPlayer = new Label();
    public static Label timerLabel = new Label();
    public static Button endButton = new Button("End Turn");


    public InfoBar() {
        infoStage = new Stage();
        Player p = Turns.getTurn();
        //infoBarCreated = true;
        infoStage.setTitle("Information Bar");
        infoStage.setAlwaysOnTop(true);
        Group t2 = new Group();
        Scene scene2 = new Scene(t2, 600, 120);

        timerLabel.setFont(new Font("American Typewriter Bold", 30));

        currRound.setText("Round " + Turns.rounds);
        currRound.setFont(new Font("American Typewriter Bold", 18));

        currPlayer.setText("It is " + p.getName() + "'s Turn");
        currPlayer.setFont(new Font("American Typewriter Bold", 18));
        if (p.getColor() != Color.WHITE) {
            currPlayer.setTextFill(p.getColor());
        } else {
            currPlayer.setTextFill(p.getColor());
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

        Label l1 = new Label("                   ");
        Label l2 = new Label("                   ");
        Label l3 = new Label("                   ");
        Label l4 = new Label(" Timer");
        l4.setFont(new Font("American Typewriter Bold", 18));

        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(20);
        grid2.setVgap(10);
        grid2.add(l1, 1, 0);
        grid2.add(currPlayer, 2, 0);
        grid2.add(currRound, 4, 0);
        grid2.add(l2, 1, 1);
        grid2.add(moneyLeft, 2, 1);
        grid2.add(foodLeft, 4, 1);
        grid2.add(l3, 1, 2);
        grid2.add(energyLeft, 2, 2);
        grid2.add(oreLeft, 4, 2);
        grid2.add(timerLabel, 5, 1);
        grid2.add(endButton, 5, 2);
        grid2.add(l4, 5, 0);
        t2.getChildren().add(grid2);

        infoStage.setScene(scene2);
        infoStage.show();
        infoStage.toFront();

        System.out.println("INFO BAR CREATED");
    }

    public void updateInfoBar() {
        infoStage = new Stage();
        Player p = Turns.getTurn();

        currRound.setText("Round " + Turns.rounds);
        currRound.setFont(new Font("American Typewriter Bold", 18));

        currPlayer.setText("It is " + p.getName() + "'s Turn");
        currPlayer.setFont(new Font("American Typewriter Bold", 18));
        if (p.getColor() != Color.WHITE) {
            currPlayer.setTextFill(p.getColor());
            currPlayer.setBackground(new Background(new BackgroundFill(Color.WHITE,
                    CornerRadii.EMPTY, Insets.EMPTY)));
        } else {
            currPlayer.setTextFill(p.getColor());
            currPlayer.setBackground(new Background(new BackgroundFill(Color.BLACK,
                    CornerRadii.EMPTY, Insets.EMPTY)));
        }

        moneyLeft.setText("Money: " + p.getMoney());
        System.out.println("in info bar "+ p.getName() + " " + p.getMoney());
        moneyLeft.setFont(new Font("American Typewriter", 15));

        foodLeft.setText("Food: " + p.getFood());
        foodLeft.setFont(new Font("American Typewriter", 15));

        energyLeft.setText("Energy: " + p.getEnergy());
        energyLeft.setFont(new Font("American Typewriter", 15));

        oreLeft.setText("Ore: " + p.getOre());
        oreLeft.setFont(new Font("American Typewriter", 15));
        System.out.println("INFO BAR UPDATED");

        if (Turns.rounds + 1 == 14) {
            infoStage.close();
        }
    }
}

    /*
    public void infoBar() {
        infoStage = new Stage();
        Player p = Turns.getTurn();
        if (!infoBarCreated) {
            infoBarCreated = true;
            infoStage.setTitle("Information Bar");
            infoStage.setAlwaysOnTop(true);
            Group t2 = new Group();
            Scene scene2 = new Scene(t2, 600, 100);

            currRound.setText("Round " + Turns.rounds);
            currRound.setFont(new Font("American Typewriter Bold", 18));

            currPlayer.setText("It is " + p.getName() + "'s Turn");
            currPlayer.setFont(new Font("American Typewriter Bold", 18));
            if (p.getColor() != Color.WHITE) {
                currPlayer.setTextFill(p.getColor());
            } else {
                currPlayer.setTextFill(p.getColor());
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

            Label l1 = new Label("                                          ");
            Label l2 = new Label("                                          ");
            Label l3 = new Label("                                          ");

            GridPane grid2 = new GridPane();
            grid2.setAlignment(Pos.CENTER);
            grid2.setHgap(20);
            grid2.setVgap(10);
            grid2.add(l1, 1, 0);
            grid2.add(currPlayer, 2, 0);
            grid2.add(currRound, 4, 0);
            grid2.add(l2, 1, 1);
            grid2.add(moneyLeft, 2, 1);
            grid2.add(foodLeft, 4, 1);
            grid2.add(l3, 1, 2);
            grid2.add(energyLeft, 2, 2);
            grid2.add(oreLeft, 4, 2);
            t2.getChildren().add(grid2);

            infoStage.setScene(scene2);
            infoStage.show();
            infoStage.toFront();

            System.out.println("INFO BAR CREATED");

        } else {
            currRound.setText("Round " + Turns.rounds);
            currRound.setFont(new Font("American Typewriter Bold", 18));

            currPlayer.setText("It is " + p.getName() + "'s Turn");
            currPlayer.setFont(new Font("American Typewriter Bold", 18));
            if (p.getColor() != Color.WHITE) {
                currPlayer.setTextFill(p.getColor());
                currPlayer.setBackground(new Background(new BackgroundFill(Color.WHITE,
                        CornerRadii.EMPTY, Insets.EMPTY)));
            } else {
                currPlayer.setTextFill(p.getColor());
                currPlayer.setBackground(new Background(new BackgroundFill(Color.BLACK,
                        CornerRadii.EMPTY, Insets.EMPTY)));
            }

            moneyLeft.setText("Money: " + p.getMoney());
            System.out.println("in info bar "+ p.getName() + " " + p.getMoney());
            moneyLeft.setFont(new Font("American Typewriter", 15));

            foodLeft.setText("Food: " + p.getFood());
            foodLeft.setFont(new Font("American Typewriter", 15));

            energyLeft.setText("Energy: " + p.getEnergy());
            energyLeft.setFont(new Font("American Typewriter", 15));

            oreLeft.setText("Ore: " + p.getOre());
            oreLeft.setFont(new Font("American Typewriter", 15));
            System.out.println("INFO BAR UPDATED");
        }

        if (Turns.rounds + 1 == 14) {
            infoStage.close();
        }
    }

}
*/
