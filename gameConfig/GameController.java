package gameConfig;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	private Button assayBackButton;

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

	@FXML
	private Button oreOkButton;

	public static Mule.Type currentMuleType;
	public static int numPasses = 0;
	public static Stage newStage;
	private static boolean selectPhase = true;

	private boolean infoBarCreated, townWinCreated,
			landBuyIntCreated, pubWinCreated,
			storeWinCreated, selectWinCreated, assayWinCreated = false;
	public static InfoBar infoBar;
	private final Auction auction = new Auction();
	public static Scene townScene;
	private static Scene storeScene;
	private static Scene selectScene;
	private static Scene landBuyIntScene;
	private static Scene pubGambleScene;
	private static Scene assayScene;
	public static GridPane grid;

	/**
	 *
	 * @param fxmlFileLocation URL for the file location
	 * @param resources resource bundle to check resources
	 */
	// TURNS AND SETUP
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		grid = (GridPane) Controller.gameRoot;
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
        grid.getChildren().stream().filter(node -> node.getId() != null && !node.getId().equals("townButton")).forEach(node -> node.setDisable(true));
		Launcher.primaryStage.hide();
		//newStage.hide();
		Stage start = new Stage();
		start.setScene(Controller.startScene);
		start.setTitle(Turns.getTurn().getName() + "'s Turn");
		start.show();
	}

	/**
	 *
	 * @param event action event to check button
	 */
	@FXML
	public void startButtonClicked(ActionEvent event) {
		Player currentPlayer = Turns.getTurn();
		newStage = new Stage();
		if (!infoBarCreated){
			infoBar = new InfoBar();
			infoBarCreated = true;
		} else {
			infoBar.updateInfoBar();
		}
		RandomEvents randomEvents = new RandomEvents();
		String message;
		message = randomEvents.determineRandomEvent(currentPlayer);
		if (event.getSource() == startButton) {
			Timer timer = new Timer(Turns.timeForTurn(currentPlayer));
			timer.start();
			Stage stage = (Stage) startButton.getScene().getWindow();
			stage.close();
			if (currentPlayer.getLandOwned().size() != 0 && currentPlayer.getMulesOwned().size() != 0) {
                currentPlayer.getMulesOwned().stream().filter(mule -> mule.getPosition().getOwner() == currentPlayer && currentPlayer.getEnergy() >= 1
                        && mule.getOwner() == currentPlayer).forEach(mule -> {
                    System.out.println("producing");
                    Mule.produce(mule.getType(), mule.getPosition().getType(), currentPlayer);
                    infoBar.updateInfoBar();
                });
			}
			//store = new Store();
			/* boolean auctionTime = auction.isAuctionTime();
			System.out.println("before auction if statement");
			if (auctionTime) {
				System.out.println("Auction time");
				auction.startAuction();
			} */
			if (numPasses < Controller.numPlayer) {
				System.out.println("Land Selection Phase");
				selectPhase = true;
				if (!selectWinCreated) {
					try {
						Parent selectPhase = FXMLLoader.load(getClass().getResource("UIFiles/SelectionPhaseInterface.fxml"));
						selectScene = new Scene(selectPhase);
						newStage.setScene(selectScene);
						newStage.setTitle(Turns.getTurn().getName());
						newStage.show();
						selectWinCreated = true;
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					newStage.setScene(selectScene);
					newStage.show();
				}
			} else {
				selectPhase = false;
			}
			if (!(message.equals("NVM"))) {
				RandomEvents randomMessage = new RandomEvents();
				RandomEvents.messageBox(message);
			}
		}

	}

	/**
	 *
	 * @param event action event to check button source
	 */
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

	/**
	 *
	 * @param event action event to check button source
	 */
	@FXML
	public void selectionPhase(ActionEvent event) {
		if (event.getSource() == selectLand) {
            grid.getChildren().stream().filter(node -> node.getId() != null && !node.getId().equals("townButton")).forEach(node -> node.setDisable(false));
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

	/**
	 *
	 * @param e action event to check button source
	 */
	//TOWN BUTTONS
	@FXML
	public void townButtonClicked(ActionEvent e) {
		newStage = new Stage();
		if (e.getSource() == townButton) {
			if (!townWinCreated) {
				try {
					Parent town = FXMLLoader.load(getClass().getResource("UIFiles/TownMap.fxml"));
					townScene = new Scene(town);
					newStage.setScene(townScene);
					newStage.setTitle("Welcome to the Town");
					newStage.show();
					townWinCreated = true;
				} catch (Exception ex) {
					Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else {
				newStage.setScene(townScene);
				newStage.show();
			}
		}
	}

	/**
	 *
	 * @param e action event to check button source
	 */
	@FXML
	public void backButtonClicked(ActionEvent e) {
		newStage = new Stage();
		if (e.getSource() == backButton) {
			newStage.setScene(townScene);
			newStage.setTitle("Town");
			newStage.show();
		}
		Stage stage = (Stage) backButton.getScene().getWindow();
		stage.close();
	}
	/**
	 *
	 * @param e action event to check button source
	 */
	//LAND OFFICE
	@FXML
	public void landOfficeButtonClicked(ActionEvent e) {
		newStage = new Stage();
		if (e.getSource() == landOfficeButton) {
			if (!landBuyIntCreated) {
				try {
					Parent landBuy = FXMLLoader.load(getClass().getResource("UIFiles/LandBuyInterface.fxml"));
					landBuyIntScene = new Scene(landBuy);
					newStage.setScene(landBuyIntScene);
					newStage.setTitle(Turns.getTurn().getName());
					newStage.show();
					landBuyIntCreated = true;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				newStage.setScene(landBuyIntScene);
				newStage.show();
			}
		}
		Stage stage = (Stage) landOfficeButton.getScene().getWindow();
		stage.close();
	}
	/**
	 *
	 * @param e action event to check button source
	 */
	@FXML
	public void buyLandButtonClicked(ActionEvent e) {
		newStage = new Stage();
		if (e.getSource() == landBuyButton) {
            grid.getChildren().stream().filter(node -> node.getId() != null && !node.getId().equals("townButton")).forEach(node -> node.setDisable(false));
			if (Turns.getTurn().getLandGrants() > 0 || Turns.getTurn().getMoney() > 300)//make sure player can buy land
				Land.landBuyEnable = true;
			Stage stage = (Stage) landBuyButton.getScene().getWindow();
			stage.close();
		} else if (e.getSource() == backButton2) {
			Stage stage = (Stage) backButton2.getScene().getWindow();
			stage.close();
			newStage.setScene(townScene);
			newStage.setTitle(Turns.getTurn().getName());
			newStage.show();
		}
	}
	/**
	 *
	 * @param e action event to check button source
	 */
	@FXML
	public void landButtonClicked(ActionEvent e) {
		Mule mule = StoreController.potentialMule;
		Player currentP = Turns.getTurn();
		Node landButton = (Node) e.getSource();
		//GridPane grid = (GridPane) landButton.getParent();
		int col = GridPane.getColumnIndex(landButton);
		int row = GridPane.getRowIndex(landButton);
		Land newLand = new Land(col, row);
		Land selectedLand = Controller.landPlots[col][row];
		if (Land.landBuyEnable) {
			if (currentP.getLandGrants() > 0) {//check for land grants
				currentP.decLandGrants();
				Rectangle color =  new Rectangle();
				color.setFill(Color.valueOf(currentP.getColor()));
				color.setHeight(25);
				color.setWidth(25);
				color.setOpacity(1);
				grid.add(color, col, row);
				GridPane.setHalignment(color, HPos.LEFT);
				GridPane.setValignment(color, VPos.TOP);
				newLand.setOwner(currentP);
				newLand.setType(selectedLand.getType());
				selectedLand.setOwner(currentP);
				currentP.getLandOwned().add(newLand);
				//landButton.setDisable(true);
			} else if (currentP.getMoney() >= 300){//if not grants sub money //doesn't allow to buy when at $300 //TODO
				currentP.addSubMoney(-300);
				Rectangle color = new Rectangle();
				color.setFill(Color.valueOf(currentP.getColor()));
				color.setHeight(25);
				color.setWidth(25);
				color.setOpacity(1);
				grid.add(color, col, row);
				GridPane.setHalignment(color, HPos.LEFT);
				GridPane.setValignment(color, VPos.TOP);
				newLand.setOwner(currentP);
				newLand.setType(selectedLand.getType());
				selectedLand.setOwner(currentP);
				currentP.getLandOwned().add(newLand);
				//landButton.setDisable(true);
			} else {
				GameController.errorMessageBox("You do not have enough money to buy this land");
			}
			Land.landBuyEnable = false;//disable land buying for next turn
			if (selectPhase) {
				Timer.endTurn();
			}

		} else if (StoreController.buy) {
			boolean muleBought = currentP.buyMule(true, mule, selectedLand);//buy mule / return false if mule has been lost
			if (muleBought) {//if !muleLost
				Image mulePic =  new Image("gameConfig/UIFiles/Media/aMule.png");
				ImageView muleView = new ImageView();
				muleView.setImage(mulePic);
				muleView.setFitWidth(50);
				muleView.setPreserveRatio(true);
				GridPane.setConstraints(muleView, col, row, 1, 1);
				muleView.setId(String.valueOf(col) + String.valueOf(row));
				grid.getChildren().add(muleView);
				selectedLand.setHasMule(true);
				//landButton.setDisable(true);
			}
		} else if (!StoreController.buy) {
			if (mule.getType() == selectedLand.getMuleType() && selectedLand.hasMule()) {
				boolean muleBought = currentP.buyMule(false, mule, selectedLand);
				if (!muleBought) {
					for (Node node : grid.getChildren()) {
						String temp = String.valueOf(col) + String.valueOf(row);
						if (Objects.equals(temp, node.getId())) {
							grid.getChildren().remove(node);
							break;
						}
					}
					int pos = -1;
					for (Mule m : currentP.getMulesOwned()) {
						pos++;
						if (m.getPosition().equals(newLand)) {
							break;
						}
					}
					selectedLand.setHasMule(false);
					currentP.getMulesOwned().remove(pos);
					//landButton.setDisable(true);
				}
			} else if (mule.getType() != selectedLand.getMuleType()) {
				errorMessageBox("This land has a " + Controller.landPlots[col][row].getMuleType()
						+ " mule on it, not a " + mule.getType() + " mule.");
			}
		}
        grid.getChildren().stream().filter(node -> node.getId() != null && !node.getId().equals("townButton")).forEach(node -> node.setDisable(true));
		infoBar.updateInfoBar();
	}
	/**
	 *
	 * @param e action event to check button source
	 */
	@FXML
	public void pubButtonClicked(ActionEvent e) {
		newStage = new Stage();
		if (e.getSource() == pubButton) {
			if (!pubWinCreated) {
				try {
					Parent pubGamble = FXMLLoader.load(getClass().getResource("UIFiles/PubGambleInterface.fxml"));
					pubGambleScene = new Scene(pubGamble);
					newStage.setScene(pubGambleScene);
					newStage.show();
					pubWinCreated = true;
				} catch (Exception ex) {
					Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else {
				newStage.setScene(pubGambleScene);
				newStage.show();
			}
		}
		Stage stage = (Stage) pubButton.getScene().getWindow();
		stage.close();
	}
	/**
	 *
	 * @param e action event to check button source
	 */
	@FXML
	public void gambleButtonClicked(ActionEvent e) {
		newStage = new Stage();
		if (e.getSource() == gambleButton) {
			int timeLeft = Timer.getTimeLeft();
			Player p = Turns.getTurn();
			p.gamble(timeLeft);
			infoBar.updateInfoBar();
			Timer.endTurn();
			try {
				Parent gambleC = FXMLLoader.load(getClass().getResource("UIFiles/GambleConfirmation.fxml"));
				Scene gambleConfirm = new Scene(gambleC);
				newStage.setScene(gambleConfirm);
				newStage.setTitle("Congratulations");
				newStage.show();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		Stage stage = (Stage) backButton.getScene().getWindow();
		stage.close();
	}
	/**
	 *
	 * @param e action event to check button source
	 */
	@FXML
	public void gambleConfirm(ActionEvent e) {
		if (e.getSource() == gambleOkButton) {
			Stage stage = (Stage) gambleOkButton.getScene().getWindow();
			stage.close();
		}
	}
	/**
	 *
	 * @param e action event to check button source
	 */
	@FXML
	public void storeButtonClicked(ActionEvent e) {
		newStage = new Stage();
		if (e.getSource() == storeButton) {
			if (!storeWinCreated) {
				try {
					Parent storeFile = FXMLLoader.load(getClass().getResource("UIFiles/storeInterface2.fxml"));
					storeScene = new Scene(storeFile);
					newStage.setScene(storeScene);
					newStage.setTitle("Welcome to the Store");
					newStage.show();
					storeWinCreated = true;
				} catch (Exception ex) {
					Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else {
				newStage.setScene(storeScene);
				newStage.show();
			}
		}
		Stage stage = (Stage) storeButton.getScene().getWindow();
		stage.close();
	}
	/**
	 *
	 * @param e action event to check button source
	 */
	@FXML
	public void assayBackButtonClicked(ActionEvent e) {
		newStage = new Stage();
		if (e.getSource() == assayBackButton) {
			newStage.setScene(townScene);
			newStage.setTitle("Town");
			newStage.show();
		}
		Stage stage = (Stage) assayBackButton.getScene().getWindow();
		stage.close();
	}
	/**
	 *
	 */
	@FXML
	public void mineButtonClicked() {
		System.out.println("Mine button clicked");
	}
	/**
	 *
	 */
	@FXML
	public void assayOfficeButtonClicked() {
		newStage = new Stage();
		if (!assayWinCreated) {
			try {
				Parent assay = FXMLLoader.load(getClass().getResource("UIFiles/AssayInterface.fxml"));
				assayScene = new Scene(assay);
				newStage.setScene(assayScene);
				newStage.setTitle("Assay Office");
				newStage.show();
				assayWinCreated = true;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			newStage.setScene(assayScene);
			newStage.show();
		}
	}
	/**
	 *
	 * @param message string to show on error box
	 */
	public static void errorMessageBox(String message) {
		Stage errorStage = new Stage();
		errorStage.setTitle("Error!");
		GridPane grid = new GridPane();
		Label errorLabel = new Label(message);
		errorLabel.setFont(new Font("American Typewriter", 15));
		Button errorButton = new Button("Ok");
		errorButton.setFont(new Font("American Typewriter", 17));
		errorButton.setOnAction((ActionEvent e) -> errorStage.close());
		grid.add(errorLabel, 0, 0);
		grid.add(errorButton, 1, 1);
		Scene errorScene = new Scene(grid);
		errorStage.setScene(errorScene);
		errorStage.show();
		errorStage.toFront();
	}
	/**
	 *
	 * @param e action event to check button source
	 */
	public void oreErrorMessage(ActionEvent e) {
		if(e.getSource() == oreOkButton) {
			if (!storeWinCreated) {
				try {
					Parent storeFile = FXMLLoader.load(getClass().getResource("UIFiles/storeInterface2.fxml"));
					storeScene = new Scene(storeFile);
					newStage.setScene(storeScene);
					newStage.setTitle("Welcome to the Store");
					newStage.show();
					storeWinCreated = true;
				} catch (Exception ex) {
					Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else {
				newStage.setScene(storeScene);
				newStage.show();
			}
		}
	}
}