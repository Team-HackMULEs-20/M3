import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;

public class M3Example extends Application {

    private Button btnscene1, btnscene2;
    private Label lblscene1, lblscene2;
    private FlowPane pane1, pane2;
    private Scene scene1, scene2, scene3;
    private Stage thestage;

    @Override
    public void start(Stage stage) {
        thestage = stage;
        //can now use the stage in other methods

        //make things to put on panes
        btnscene1=new Button("Click to go to next screen");
        btnscene2=new Button("Play!");
        btnscene1.setOnAction(e-> ButtonClicked(e));
        btnscene2.setOnAction(e-> ButtonClicked(e));
        lblscene1=new Label("Choose a Difficulty");
        lblscene2=new Label("Select Your Credentials");

        ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
                "Easy", "Medium", "Hard"));

        Label playerLbl = new Label("Choose how many players");

        ChoiceBox cb2 = new ChoiceBox(FXCollections.observableArrayList(
                "2", "3", "4"));

        Label mapLbl = new Label("Select a map type");

        ChoiceBox cb3 = new ChoiceBox(FXCollections.observableArrayList(
                "Standard", "Random"));

        VBox vbox = new VBox();
        vbox.getChildren().addAll(lblscene1, cb, playerLbl, cb2);

        VBox vbox2 = new VBox();
        vbox2.getChildren().addAll(mapLbl, cb3);

        //make 2 Panes
        pane1=new FlowPane();
        pane2=new FlowPane();
        FlowPane pane3 = new FlowPane();
        pane1.setVgap(10);
        pane2.setVgap(10);
        //set background color of each Pane
        pane1.setStyle("-fx-background-color: lightblue;-fx-padding: 10px;");
        pane2.setStyle("-fx-background-color: tan;-fx-padding: 10px;");
        pane3.setStyle("-fx-background-color: lightgreen;-fx-padding: 10px");

        //add everything to panes
        pane1.getChildren().addAll(vbox, vbox2, btnscene1);
        pane2.getChildren().addAll(lblscene2, btnscene2);


        //make 2 scenes from 2 panes
        scene1 = new Scene(pane1, 200, 200);
        scene2 = new Scene(pane2, 200, 100);
        scene3 = new Scene(pane3, 500, 500);

        thestage.setTitle("MULE Game");
        thestage.setScene(scene1);
        thestage.show();
    }

    public void ButtonClicked(ActionEvent e) {
        if (e.getSource()==btnscene1) {
            thestage.setScene(scene2);
            thestage.setTitle("Scene 2");
        } else {
            thestage.setScene(scene3);
            thestage.setTitle("Scene 3");
        }
    }


}