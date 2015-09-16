package gameConfig;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;

public class Timer extends Application{
    private int beginTime;// = 50;
    private Integer timeLeft;// = beginTime;
    private Timeline timeline;
    private Label timerLabel = new Label();

    public Timer(int beginTime) {
        this.beginTime = beginTime;
        timeLeft = beginTime;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start (Stage stage) {
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
        t.getChildren().add(box);

        stage.setScene(scene);
        stage.show();

    }

}
