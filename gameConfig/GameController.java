package gameConfig;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.naming.ldap.Control;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

	@FXML
	private Button startButton;

	@FXML
	private Button landBuyButton;

	@FXML
	private Button backButton2;

	@FXML
	private Button townButton;

	@FXML
	private Button landOfficeButton;

	@FXML
	private Button pubButton;

	@FXML
	private TextField bidAmount;

	@FXML
	public static Label currentBidLabel;

	@FXML
	private Button bidButton;

	@FXML
	private Button bidPassButton;

	@FXML
	private Button gambleButton;

	@FXML
	private Button backButton;

	@FXML
	private Button storeButton;

	@FXML
	private Button gambleOkButton;

	@FXML
	private Button passSelect;

	@FXML
	private Button selectLand;


	private Label foodCostLabel;

	private Label energyCostLabel;

	private Label smithoreCostLabel;

	private Label chrystiteCostLabel;

	@FXML
	private Label muleCostLabel;

	private Label foodQuantityLabel;

	private Label energyQuantityLabel;

	private Label smithoreQuantityLabel;

	private Label chrystiteQuantityLabel;

    @FXML
    private Label muleQuantityLabel;

	@FXML
	private ComboBox muleChoice;

    @FXML
	private Button buyFoodButton;

    @FXML
    private Button sellFoodButton;

    @FXML
    private Button buyEnergyButton;

    @FXML
    private Button sellEnergyButton;

    @FXML
    private Button buyOreButton;

    @FXML
    private Button sellOreButton;

    @FXML
    private Button buyCrysButton;

    @FXML
    private Button sellCrysButton;

    @FXML
    private Button buyMuleButton;

    @FXML
    private Button sellMuleButton;


	public static Mule.Type currentMuleType;
	public static Store store;


	public static int numPasses = 0;
	private static Stage start;
	private Stage newStage;
	private static boolean selectPhase = true;

    private boolean infoBarCreated = false;
    private static InfoBar infoBar;
	private Auction auction = new Auction();

	// TURNS AND SETUP
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert startButton != null : "fx:id=\"startButton\" was not injected: " +
				"check your FXML file 'playerStart.fxml'.";
		assert landBuyButton != null : "fx:id=\"landBuyButton\" was not injected: " +
				"check your FXML file 'landBuyInterface.fxml'.";
		assert backButton2 != null : "fx:id=\"passButton\" was not injected: " +
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
        if (!infoBarCreated){
            infoBar = new InfoBar();
            infoBarCreated = true;
        } else {
            infoBar.updateInfoBar();
        }
		//infoBar();
        //infoBar.updateInfoBar();
		if (event.getSource() == startButton) {
			Timer timer = new Timer(Turns.timeForTurn(Turns.getTurn()));
			timer.start();
			start.close();

			store = new Store();
			/* boolean auctionTime = auction.isAuctionTime();
			System.out.println("before auction if statement");
			if (auctionTime) {
				System.out.println("Auction time");
				auction.startAuction();
			} */
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

	public void updateStoreLabels() {
		System.out.println("Food Cost: " + store.getFoodCost() + " | Food Quantity: " + store.getFoodQuantity());
		System.out.println("Energy Cost: " + store.getEnergyCost() + " | Energy Quantity: " + store.getEnergyQuantity());
		System.out.println("Smithore Cost: " + store.getSmithCost() + " | Smithore Quantity: " + store.getSmithQuantity());
		System.out.println("Food Cost: " + store.getFoodCost() + " | Food Quantity: " + store.getFoodQuantity());
		System.out.println("Crystite Cost: " + store.getCrysCost() + " | Food Quantity: " + store.getCrysQuantity());
		System.out.println("Mule Cost: " + Store.muleCost + " | " + "Mule Quantity: " + store.getMuleQuantity());
	}

	@FXML
	public void bidButtonClicked(ActionEvent event) {
		if (event.getSource() == bidButton) {
			int currentBidAmount = Integer.parseInt(bidAmount.getText());
			Player p = Turns.getTurn();
			auction.placeBid(p, currentBidAmount);
		} else if (event.getSource() == bidPassButton) {
			Timer.endTurn();
			auction.auctionStage.close();
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

	//TOWN BUTTONS
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

	//LAND OFFICE
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

	public void buyLandButtonClicked(ActionEvent e) {
		newStage = new Stage();
		if (e.getSource() == landBuyButton) {
			if (Turns.getTurn().getLandGrants() > 0 || Turns.getTurn().getMoney() > 300)//make sure player can buy land
				Land.landBuyEnable = true;
			Stage stage = (Stage) landBuyButton.getScene().getWindow();
			stage.close();
		} else if (e.getSource() == backButton2) {
			Stage stage = (Stage) backButton2.getScene().getWindow();
			stage.close();
			newStage.setScene(Launcher.townScene);
			newStage.setTitle(Turns.getTurn().getName());
			newStage.show();
		}
	}

	public void landButtonClicked(ActionEvent e) {
		Player currentP = Turns.getTurn();
		Node landButton = (Node) e.getSource();
		GridPane grid = (GridPane) landButton.getParent();
		int col = GridPane.getColumnIndex(landButton);
		int row = GridPane.getRowIndex(landButton);
		Land newLand = new Land(GridPane.getColumnIndex(landButton), GridPane.getRowIndex(landButton));
		if (Land.landBuyEnable) {
			if (currentP.landGrants > 0) {//check for land grants
				currentP.landGrants--;

				Rectangle color =  new Rectangle();
				color.setFill(currentP.getColor());
				color.setHeight(25);
				color.setWidth(25);
				color.setOpacity(1);
				grid.add(color, col, row);
				GridPane.setHalignment(color, HPos.LEFT);
				GridPane.setValignment(color, VPos.TOP);
				// landButton.setDisable(true);//disable the land button since land is purchased

				Controller.landPlots[col][row].setOwner(currentP);
				currentP.landOwned.add(newLand);

			} else if (currentP.getMoney() >= 300){//if not grants sub money //doesn't allow to buy when at $300 //TODO
				currentP.addSubMoney(-300);
                infoBar.updateInfoBar();

				Rectangle color =  new Rectangle();
				color.setFill(currentP.getColor());
				color.setHeight(25);
				color.setWidth(25);
				color.setOpacity(1);
				grid.add(color, col, row);
				GridPane.setHalignment(color, HPos.LEFT);
				GridPane.setValignment(color, VPos.TOP);
				// landButton.setDisable(true);//disable the land button since land is purchased

				Controller.landPlots[col][row].setOwner(currentP);
				currentP.landOwned.add(newLand);

			} else {
				System.out.println("You do not have enough money to buy this land");
			}

			Land.landBuyEnable = false;//disable land buying for next turn
            if (selectPhase) {
                Timer.endTurn();
            }

		} else if (currentP.muleBuyEnable) {
			boolean muleBought = currentP.buyMule(new Mule(currentMuleType), newLand);//buy mule / return false if mule has been lost
			if (muleBought) {//if !muleLost
				Image mulePic =  new Image("gameConfig/UIFiles/Media/aMule.png");
				ImageView muleView = new ImageView();
				muleView.setImage(mulePic);
				muleView.setFitWidth(50);
				muleView.setPreserveRatio(true);
				grid.setConstraints(muleView, col, row, 1, 1);
				grid.getChildren().add(muleView);
			}
		}
	}

	//PUB
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
            Player p = Turns.getTurn();
            int moneyWon = p.gamble(timeLeft);
            infoBar.updateInfoBar();
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

//STORE

    public void storeButtonClicked(ActionEvent e) {
		this.updateStoreLabels();
        newStage = new Stage();
        if (e.getSource() == storeButton) {
            newStage.setScene(Launcher.storeScene);
            newStage.setTitle("Store");
            newStage.show();

            //foodCostLabel.setText("" + store.getFoodCost());
        }
        Stage stage = (Stage) storeButton.getScene().getWindow();
        stage.close();
    }

    public void buyFoodButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellFood(true, p);
		this.updateStoreLabels();
        infoBar.updateInfoBar();
	}

	public void sellFoodButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellFood(false,p);
		this.updateStoreLabels();
        infoBar.updateInfoBar();
	}

	public void buyEnergyButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellEnergy(true,p);
		this.updateStoreLabels();
        infoBar.updateInfoBar();
	}

	public void sellEnergyButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellEnergy(false,p);
		this.updateStoreLabels();
        infoBar.updateInfoBar();
	}

	public void buyOreButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellSmithore(true,p);
		this.updateStoreLabels();
        infoBar.updateInfoBar();
	}

	public void sellOreButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellSmithore(false,p);
		this.updateStoreLabels();
        infoBar.updateInfoBar();
	}

	public void buyCrysButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellChrystite(true,p);
		this.updateStoreLabels();
        infoBar.updateInfoBar();
	}

	public void sellCrysButtonClicked(ActionEvent e) {
        Player p = Turns.getTurn();
        store.buySellChrystite(false,p);
		this.updateStoreLabels();
        infoBar.updateInfoBar();
	}

	public void buyMuleButtonClicked(ActionEvent e) {
        String choice = muleChoice.getSelectionModel().getSelectedItem().toString();
        choice = choice.toUpperCase().substring(0, choice.indexOf(" "));
        currentMuleType = Mule.Type.valueOf(choice);
        Player p = Turns.getTurn();
        p.muleBuyEnable = true;
        Stage stage = (Stage) muleChoice.getScene().getWindow();
        stage.close();
		this.updateStoreLabels();
        //infoBar.updateInfoBar(); //Todo
	}

	public void sellMuleButtonClicked(ActionEvent e) { //Todo
        Player p = Turns.getTurn();
		this.updateStoreLabels();
        //infoBar.updateInfoBar(); //Todo
	}


}