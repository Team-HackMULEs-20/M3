package gameConfig;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class Timer {
    private int beginTime;// = 50; //TODO unused var
    private static Integer timeLeft;// beginTime;
    private Timeline timeline;
    //public Label timerLabel = new Label();
    //private static Button endButton;

    public Timer(int beginTime) {
        this.beginTime = beginTime;
        timeLeft = beginTime;
    }

    public void start() {
        Player p = Turns.getTurn();
        System.out.print("Round " + Turns.rounds);
        System.out.print(" | It is " + p.getName() + "'s Turn");
        System.out.println(" | Money: " + p.getMoney() + "; Food: " + p.getFood()
                + "; Energy: " + p.getEnergy() + "; Ore: " + p.getOre());
        InfoBar.timerLabel.setText("  " + timeLeft.toString());
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        event -> {
                            timeLeft--;
                            // update timerLabel
                            InfoBar.timerLabel.setText("  "
                                    + timeLeft.toString());
                            if (timeLeft <= 0) {
                                timeline.stop();
                                Turns.playerTurn++;
                                GameController.newStage.close();
                                GameController.beginTurn();
                            }
                        }));
        timeline.playFromStart();
        InfoBar.endButton.setOnAction((ActionEvent e) -> {
            timeline.stop();
            Turns.playerTurn++;
            GameController.newStage.close();
            GameController.beginTurn();
        });

    }

    //simulates "End Turn" button pressed
    public static void endTurn() {
        InfoBar.endButton.fire();
    }

    public static int getTimeLeft() {return timeLeft;}

    public static void main(String[] args) {
        Application.launch(args);
    }

}
