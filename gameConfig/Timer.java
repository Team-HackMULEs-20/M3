package gameConfig;
//package fxtimer;

        import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.stage.Stage;

public class Timer extends Application{
    int beginTime;

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
