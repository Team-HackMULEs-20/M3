package gameConfig;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.naming.ldap.Control;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private Button startButton;

    @FXML
    private Button landBuyButton;

    @FXML
    private Button passButton;

    @FXML
    private Button townButton;

    @FXML
    private Button landOfficeButton;

    @FXML
    private Button pubButton;

    @FXML
    private Button gambleButton;

    public static int numPasses = 0;

    private static Stage start;

    private Stage newStage;


    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert startButton != null : "fx:id=\"startButton\" was not injected: " +
                "check your FXML file 'playerStart.fxml'.";
        assert landBuyButton != null : "fx:id=\"townButton\" was not injected: " +
                "check your FXML file 'M.U.L.E Game Setup.fxml'.";
        assert passButton != null : "fx:id=\"townButton\" was not injected: " +
                "check your FXML file 'M.U.L.E Game Setup.fxml'.";
        assert townButton != null : "fx:id=\"townButton\" was not injected: " +
                "check your FXML file 'M.U.L.E Game Setup.fxml'.";
    }

    @FXML
    public static void beginTurn() {
        start = new Stage();
        start.setScene(Launcher.startScene);
        start.setTitle(Turns.getTurn().getName() + "'s Turn");
        start.show();
    }

    @FXML
    public void startButtonClicked(ActionEvent event) {
        newStage = new Stage();
        if (event.getSource() == startButton) {
            Timer timer = new Timer(Turns.timeForTurn(Turns.getTurn()));
            timer.start(new Stage());
            start.close();
            if (numPasses < Controller.numPlayer) {
                System.out.println("Land Selection Phase");
                newStage.setScene(Launcher.landBuyIntScene);
                newStage.setTitle(Turns.getTurn().getName());
                newStage.show();
            }
        }
    }

    @FXML
    public static boolean isAuctionTime() {
        boolean auctionTime = false;
        int notTaken = 44;
        for (Land[] item: Controller.landPlots) {
            for (Land plot: item) {
                if (plot.isOwned()) {
                    notTaken--;
                }
            }
        }
        if (notTaken < Controller.numPlayer) {
            auctionTime = true;
        }
        return auctionTime;
    }

    @FXML
    public static void startAuction() {
        Stage auctionStage = new Stage();
        auctionStage.setScene(Launcher.auctionScene);
    }

    @FXML
    public void townButtonClicked(ActionEvent e) {
        newStage = new Stage();
        if (e.getSource() == townButton) {
            Launcher.primaryStage.hide();
            newStage.setScene(Launcher.townScene);
            newStage.setTitle("Town");
            newStage.show();
            Player p = Turns.getTurn();
            p.setLocation(Player.Location.TOWN);
        }
    }

    @FXML
    public void landOfficeButtonClicked(ActionEvent e) {
        newStage = new Stage();
        if (e.getSource() == landOfficeButton) {
            newStage.setScene(Launcher.landBuyIntScene);
            newStage.setTitle(Turns.getTurn().getName());
            newStage.show();
        }
        Stage stage = (Stage) landOfficeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void pubButtonClicked(ActionEvent e) {
        newStage = new Stage();
        if (e.getSource() == pubButton) {
            newStage.setScene(Launcher.pubGambleScene);
            newStage.setTitle(Turns.getTurn().getName());
            newStage.show();
        }
        Stage stage = (Stage) pubButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void gambleButtonClicked(ActionEvent e) {
        newStage = new Stage();
        if (e.getSource() == gambleButton) {
            int timeLeft = Timer.getTimeLeft();
            System.out.println(timeLeft);
        }
    }

    @FXML
    public void buttonClicked5(ActionEvent e) {
        if (e.getSource() == landBuyButton) {
            if (Turns.getTurn().getLandGrants() > 0 || Turns.getTurn().getMoney() > 300)//make sure player can buy land
                Land.landBuyEnable = true;
            Stage stage = (Stage) landBuyButton.getScene().getWindow();
            stage.close();
        } else if (e.getSource() == passButton) {
            numPasses++;
            Stage stage = (Stage) passButton.getScene().getWindow();
            stage.close();
            Timer.endTurn();
        }
    }

    @FXML
    public void landBuyButtonClicked(ActionEvent e) {
        if (Land.landBuyEnable) {
            Player currentP = Turns.getTurn();
            if (currentP.landGrants > 0)//check for land grants
                currentP.landGrants--;
            else//if not grants sub money
                currentP.addSubMoney(-300);
            Node landButton = (Node) e.getSource();
            GridPane grid = (GridPane) landButton.getParent();
            Rectangle color =  new Rectangle();
            color.setFill(currentP.getColor());
            color.setHeight(25);
            color.setWidth(25);
            color.setOpacity(1);
            grid.add(color, GridPane.getColumnIndex(landButton), GridPane.getRowIndex(landButton));
            GridPane.setHalignment(color, HPos.LEFT);
            GridPane.setValignment(color, VPos.TOP);
            landButton.setDisable(true);//disable the land button since land is purchased
            Land.landBuyEnable = false;//disable land buying for next turn

            Timer.endTurn();
        }
    }
}
