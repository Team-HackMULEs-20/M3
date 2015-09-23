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

public class Timer extends Application {
    private int beginTime;// = 50;
    private Integer timeLeft;// = beginTime;
    private Timeline timeline;
    private Label timerLabel = new Label();

    public Timer(int beginTime) {
        this.beginTime = beginTime;
        timeLeft = beginTime;
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Turn Timer");
        Group t = new Group();
        Scene scene = new Scene(t,150,150);

        timerLabel.setText(timeLeft.toString());
        timerLabel.setTextFill(Color.BLACK);
        timerLabel.setStyle("-fx-font-size: 5em;");

        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setPrefWidth(scene.getWidth());
        box.setLayoutY(30);
        box.getChildren().add(timerLabel);

        Button endButton = new Button("End Turn");
        box.getChildren().add(endButton);

        t.getChildren().add(box);

        stage.setScene(scene);
        stage.show();
        stage.toFront();

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        event -> {
                            timeLeft--;
                            // update timerLabel
                            timerLabel.setText(
                                    timeLeft.toString());
                            if (timeLeft <= 0) {
                                timeline.stop();
                                Turns.playerTurn++;
                                GameController.beginTurn();
                                stage.close();
                            }
                        }));
        timeline.playFromStart();
        endButton.setOnAction((ActionEvent e) -> {
            timeline.stop();
            stage.close();
            Turns.playerTurn++;
            GameController.beginTurn();
        });

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}

