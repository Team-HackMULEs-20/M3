package gameConfig;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private static TextField bidAmount;

    @FXML
    private static Label currentBidLabel;

    @FXML
    private Button bidButton;

    @FXML
    private Button bidPassButton;

    @FXML
    private Button gambleButton;

    @FXML
    private Button backButton;

    @FXML
    private Button backButton2;

    @FXML
    private Button storeButton;

    @FXML
    private Button gambleOkButton;

    @FXML
    private Button passSelect;

    @FXML
    private Button selectLand;

    @FXML
    private Label foodCostLabel;

    @FXML
    private Label energyCostLabel;

    @FXML
    private Label smithoreCostLabel;

    @FXML
    private Label chrystiteCostLabel;

    @FXML
    private Label muleCostLabel;

    @FXML
    private Label foodQuantityLabel;

    @FXML
    private Label energyQuantityLabel;

    @FXML
    private Label smithoreQuantityLabel;

    @FXML
    private Label chrystiteQuantityLabel;

    @FXML
    private Label muleQuantityLabel;


    public static int numPasses = 0;
    private static Stage start;
    private Stage newStage;
    private static Stage auctionStage;
    private static int startingBid;
    public static int landNotTaken;
    public static int numBids;
    private boolean selectPhase = true;


    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert startButton != null : "fx:id=\"startButton\" was not injected: " +
                "check your FXML file 'playerStart.fxml'.";
        assert landBuyButton != null : "fx:id=\"landBuyButton\" was not injected: " +
                "check your FXML file 'landBuyInterface.fxml'.";
        assert passButton != null : "fx:id=\"passButton\" was not injected: " +
                "check your FXML file 'landBuyInterface.fxml'.";
        assert townButton != null : "fx:id=\"townButton\" was not injected: " +
                "check your FXML file 'MainMap.fxml'.";
        assert landOfficeButton != null : "fx:id=\"landOfficeButton\" was not injected: " +
                "check your FXML file 'TownMap.fxml'.";
    }

    @FXML
    public static void beginTurn() {
        Launcher.primaryStage.hide();
        start = new Stage();
        start.setScene(Launcher.startScene);
        start.setTitle(Turns.getTurn().getName() + "'s Turn");
        start.show();
    }

    public void startButtonClicked(ActionEvent event) {
        newStage = new Stage();
        if (event.getSource() == startButton) {
            Timer timer = new Timer(Turns.timeForTurn(Turns.getTurn()));
            timer.start(new Stage());
            start.close();
            if (numPasses < Controller.numPlayer) {
                System.out.println("Land Selection Phase");
                selectPhase = true;
                newStage.setScene(Launcher.selectLandPhase);
                newStage.setTitle(Turns.getTurn().getName());
                newStage.show();
            } else {
                selectPhase = false;
            }
        }
    }

    public static boolean isAuctionTime() {
        boolean auctionTime = false;
        landNotTaken = 44;
        for (Land[] item: Controller.landPlots) {
            for (Land plot: item) {
                if (plot.isOwned()) {
                    landNotTaken--;
                }
            }
        }
        if (landNotTaken < Controller.numPlayer) {
            auctionTime = true;
        }
        startingBid = Land.getBuyPrice() / 2;
        return auctionTime;
    }

    public static void startAuction() {
        auctionStage = new Stage();
        auctionStage.setScene(Launcher.auctionScene);
        auctionStage.setTitle(Turns.getTurn().getName() + "'s Turn");
    }

    @FXML
    public void bidButtonClicked(ActionEvent event) {
        if (event.getSource() == bidButton) {
            int currentBidAmount = Integer.parseInt(bidAmount.getText());
            Player p = Turns.getTurn();
            if (currentBidAmount > startingBid && p.getMoney() > currentBidAmount) {
                startingBid = currentBidAmount;
                currentBidLabel.setText("Current Bid is: " + startingBid);
                GameController.numBids++;
            }
        } else if (event.getSource() == bidPassButton) {
            Timer.endTurn();
            auctionStage.close();
        }
    }

    public void townButtonClicked(ActionEvent e) {
        newStage = new Stage();
        if (e.getSource() == townButton) {
            Launcher.primaryStage.hide();
            newStage.setScene(Launcher.townScene);
            newStage.setTitle("Town");
            newStage.show();
            Player p = Turns.getTurn();
        }
    }

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
            //System.out.println("BUTTON PRESSED");
            int timeLeft = Timer.getTimeLeft();
            Player p = Turns.getTurn();
            p.gamble(timeLeft);
            Timer.endTurn();

            newStage.setScene(Launcher.gambleConfirm);
            newStage.setTitle("Congratulations");
            newStage.show();
        }
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void gambleConfirm(ActionEvent e) {
        if (e.getSource() == gambleOkButton) {
        }
        Stage stage = (Stage) gambleOkButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void backButtonClicked(ActionEvent e) {
       newStage = new Stage();
        if (e.getSource() == backButton) {
            newStage.setScene(Launcher.townScene);
            newStage.setTitle("Town");
            newStage.show();
        }
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void backButtonClicked2(ActionEvent e) {
        newStage = new Stage();
        if (e.getSource() == backButton2) {
            newStage.setScene(Launcher.townScene);
            newStage.setTitle("Town");
            newStage.show();
        }
        Stage stage = (Stage) backButton2.getScene().getWindow();
        stage.close();
    }

    public void buyLandButtonClicked(ActionEvent e) {
        if (e.getSource() == landBuyButton) {
            if (Turns.getTurn().getLandGrants() > 0 || Turns.getTurn().getMoney() > 300)//make sure player can buy land
                Land.landBuyEnable = true;
            Stage stage = (Stage) landBuyButton.getScene().getWindow();
            stage.close();
        } else if (e.getSource() == passButton) {
            Stage stage = (Stage) passButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void selectionPhase(ActionEvent event) {
        if (event.getSource() == selectLand) {
            if (Turns.getTurn().getLandGrants() > 0 || Turns.getTurn().getMoney() > 300)//make sure player can buy land
                Land.landBuyEnable = true;
            Stage stage = (Stage) selectLand.getScene().getWindow();
            stage.close();
        } else {
            numPasses++;
            Stage stage = (Stage) passSelect.getScene().getWindow();
            stage.close();
            Timer.endTurn();
        }
    }

    public void storeButtonClicked(ActionEvent e) {
        newStage = new Stage();
        if (e.getSource() == storeButton) {
            newStage.setScene(Launcher.storeScene);
            newStage.setTitle("Store");
            newStage.show();
        }
        Stage stage = (Stage) storeButton.getScene().getWindow();
        stage.close();
    }


    public void purchaseLand(ActionEvent e) {
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
            if (selectPhase) {
                Timer.endTurn();
            }
        }
    }
}
