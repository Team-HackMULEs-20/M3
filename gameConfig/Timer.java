package gameConfig;
//package fxtimer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.scene.control.Label;

public class Timer extends Application{
    private int beginTime;
    private Timeline timeline;
    private Label timerLabel = new Label();

    public Timer(int beginTime) {
        this.beginTime = beginTime;
    }

    @Override
    public void start (Stage stage) {

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
