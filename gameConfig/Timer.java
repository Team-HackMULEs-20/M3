package gameConfig;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

class Timer {

    private static Integer timeLeft;// beginTime;
    private Timeline timeline;

    /**
     *
     * @param beginTime the int to begin timer at
     */
    public Timer(int beginTime) {
        timeLeft = beginTime;
    }

    public void start() {
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

    /**
     *
     * @return timeLeft the int of time left
     */
    public static int getTimeLeft() {return timeLeft;}

    public static void main(String[] args) {
        Application.launch(args);
    }

}
