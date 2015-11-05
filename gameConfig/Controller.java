package gameConfig;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.net.URL;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.util.List;

public class Controller implements Initializable {

	@FXML
	private Button nextButton;

	@FXML
	private Button cancelButton;

	@FXML
	private Button loadButton;

	@FXML
	private Button nextButton2;

	@FXML
	private Button backButton;

	@FXML
	private ChoiceBox numPlayers;

	@FXML
	private ChoiceBox raceChoice;

	@FXML
	private Button okButton;

	@FXML
	private ChoiceBox mapType;

	@FXML
	private ChoiceBox difficulty;

	@FXML
	private TextField playerName;

	@FXML
	private ColorPicker colorPick;

	public static Integer numPlayer;
	public static String level;
    public static Land[][] landPlots;

	private static int count;
	public static Player[] players;
	private Scene gameScene;
	public static Scene startScene;
	public static LandType[] landTypes = LandType.standardMap();
	public static List<Object> loadData;
	public static boolean loaded;

	/**
	 *
	 * @param fxmlFileLocation fxml file to add button to
	 * @param resources resoucebundle to add buttons to
	 */
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert nextButton != null : "fx:id=\"nextButton\" was not injected: " +
				"check your FXML file 'M.U.L.E Game Setup.fxml'.";
		assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: " +
				"check your FXML file 'M.U.L.E Game Setup.fxml'.";
		assert backButton != null : "fx:id=\"backButton\" was not injected: " +
				"check your FXML file 'playerSetup.fxml'.";
		assert nextButton2 != null : "fx:id=\"nextButton2\" was not injected: " +
				"check your FXML file 'playerSetup.fxml'.";
		assert numPlayers != null : "fx:id=\"numPlayer\" was not injected: " +
				"check your FXML file 'M.U.LE Game Setup.fxml'.";
	}

	@FXML
	private void gameSetup(ActionEvent e) throws NullPointerException {
		try {
			if (e.getSource() == nextButton) {
				numPlayer = Integer.parseInt(numPlayers.getSelectionModel().getSelectedItem().toString());

				//initializing players array
				players = new Player[numPlayer.intValue()];
				String map = mapType.getSelectionModel().getSelectedItem().toString();
				if (Objects.equals(map, "Random")) {
					try {
						Parent gameRoot = FXMLLoader.load(getClass().getResource("UIFiles/MainMap.fxml"));
		//				RandMap.setImages();
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				}
				level = difficulty.getSelectionModel().getSelectedItem().toString(); //"Beginner", "Standard", or "Tournament"
				Launcher.primaryStage.setScene(Launcher.nextScene); // Show player config screen for player 1
				Launcher.primaryStage.setTitle("Player 1 Configuration");
				count = 1;

			} else if (e.getSource() == cancelButton) {
				Launcher.primaryStage.close();
			}
		} catch (NullPointerException error) {
			Launcher.primaryStage.setScene(Launcher.errorMessage);
		}
	}


	@FXML
	private void playerSetup(ActionEvent e) throws NullPointerException {
		Stage newStage = new Stage();
		try {
			if (e.getSource() == nextButton2) {

				String name = playerName.getText();
				String race = raceChoice.getSelectionModel().getSelectedItem().toString();
				if (race.length() > 8) {
					race = race.toUpperCase().substring(0, race.indexOf(" "));
				} else {
					race = race.toUpperCase();
				}
				Player.Race r = Player.Race.valueOf(race);

				Color color = colorPick.getValue();

				//creating Player
				Player p = new Player(name, r, color.toString());
				players[count - 1] = p;
				if (players[players.length - 1] != null) {

					//when players array is full, begins game turns
					Turns gameTurns = new Turns(players);
				}

				if (name.equals("")) { // check if player entered a name
					Launcher.primaryStage.setScene(Launcher.errorMessage);
					Launcher.primaryStage.setTitle("Error!");
				} else {
					if (count == 1) { // if only one player config screen has been shown go to player 2
						Launcher.primaryStage.setTitle("Player 2 Configuration");
						Launcher.primaryStage.toFront();
						playerName.clear();
						raceChoice.getSelectionModel().clearSelection();
						colorPick.setValue(Color.WHITE);
						count += 1;
					} else if (count == 2) {
						if (count == numPlayer) { // if user selected only 2 players then show game screen
							Launcher.primaryStage.hide();
							try {
								Parent gameRoot = FXMLLoader.load(getClass().getResource("UIFiles/MainMap.fxml"));
								gameScene = new Scene(gameRoot);
								Parent startWindow = FXMLLoader.load(getClass().getResource("UIFiles/playerStart.fxml"));
								startScene = new Scene(startWindow);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							newStage.setScene(gameScene);
							newStage.setTitle("Game Screen");
							newStage.show();
							GameController.beginTurn();
							//creates land array
							landPlots = new Land[9][5];//5 rows, 9 columns, col = i, row = j
							int count = 0;
							for (int i = 0; i < landPlots.length; i++) {
								for (int j = 0; j < landPlots[0].length; j++) {
									Land newLand = new Land(i,j);
									newLand.setType(landTypes[count]);
									landPlots[i][j] = newLand;
									count++;
								}
							}
						} else { // if user selected more than 2 players, go on to player 3 config
							Launcher.primaryStage.setTitle("Player 3 Configuration");
							Launcher.primaryStage.toFront();
							playerName.clear();
							raceChoice.getSelectionModel().clearSelection();
							colorPick.setValue(Color.WHITE);
							count += 1;
						}

					} else if (count == 3) {
						if (count == numPlayer) {
							Launcher.primaryStage.hide();
							try {
								Parent gameRoot = FXMLLoader.load(getClass().getResource("UIFiles/MainMap.fxml"));
								gameScene = new Scene(gameRoot);
								Parent startWindow = FXMLLoader.load(getClass().getResource("UIFiles/playerStart.fxml"));
								startScene = new Scene(startWindow);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							newStage.setScene(gameScene);
							newStage.setTitle("Game Screen");
							newStage.show();
							GameController.beginTurn();
							//creates land array
							landPlots = new Land[9][5];//5 rows, 9 columns, col = i, row = j
							int count = 0;
							for (int i = 0; i < landPlots.length; i++) {
								for (int j = 0; j < landPlots[0].length; j++) {
									Land newLand = new Land(i,j);
									newLand.setType(landTypes[count]);
									landPlots[i][j] = newLand;
									count++;
								}
							}
						} else {
							Launcher.primaryStage.setTitle("Player 4 Configuration");
							Launcher.primaryStage.toFront();
							playerName.clear();
							raceChoice.getSelectionModel().clearSelection();
							colorPick.setValue(Color.WHITE);
							count += 1;
						}

					} else if (count == 4) {
						Launcher.primaryStage.hide();
						try {
							Parent gameRoot = FXMLLoader.load(getClass().getResource("UIFiles/MainMap.fxml"));
							gameScene = new Scene(gameRoot);
							Parent startWindow = FXMLLoader.load(getClass().getResource("UIFiles/playerStart.fxml"));
							startScene = new Scene(startWindow);
						} catch (Exception e1) {
							e1.printStackTrace();
						}

						newStage.setScene(gameScene);
						newStage.setTitle("Game Screen");
						newStage.show();
						GameController.beginTurn();
						//creates land array
						landPlots = new Land[9][5];//5 rows, 9 columns, col = i, row = j
						int count = 0;
						for (int i = 0; i < landPlots.length; i++) {
							for (int j = 0; j < landPlots[0].length; j++) {
								Land newLand = new Land(i,j);
								newLand.setType(landTypes[count]);
								landPlots[i][j] = newLand;
								count++;
							}
						}
					}
				}
			} else if (e.getSource() == backButton) {
				playerName.clear();
				raceChoice.getSelectionModel().clearSelection();
				colorPick.setValue(Color.WHITE);
				Launcher.primaryStage.setScene(Launcher.rootScene);
				Launcher.primaryStage.setTitle("M.U.L.E. Game Setup");
			}
		} catch (NullPointerException error) {
			Launcher.primaryStage.setScene(Launcher.errorMessage);
			Launcher.primaryStage.setTitle("Error!");
		}
	}

	/**
	 *
	 * @param event actionevent to check button
	 */
	public void errorBox(ActionEvent event) {
		if (event.getSource() == okButton) {
			if (count == 1) {
				Launcher.primaryStage.setScene(Launcher.nextScene);
				Launcher.primaryStage.setTitle("Player 1 Configuration");
			} else if (count == 2) {
				Launcher.primaryStage.setScene(Launcher.nextScene);
				Launcher.primaryStage.setTitle("Player 2 Configuration");
			} else if (count == 3) {
				Launcher.primaryStage.setScene(Launcher.nextScene);
				Launcher.primaryStage.setTitle("Player 3 Configuration");
			} else if (count == 4) {
				Launcher.primaryStage.setScene(Launcher.nextScene);
				Launcher.primaryStage.setTitle("Player 4 Configuration");
			} else {
				Launcher.primaryStage.setScene(Launcher.rootScene);
				Launcher.primaryStage.setTitle("M.U.L.E. Game Setup");
			}
		}
	}

	@FXML
	public void loadGame(ActionEvent event) {
		Stage newStage = new Stage();
		if (event.getSource() == loadButton) {
			loadData = LoadSaveGame.load();
			if (loadData != null) {
				Controller.loaded = true;
				Parent gameRoot = null;
				try {
					gameRoot = FXMLLoader.load(getClass().getResource("UIFiles/MainMap.fxml"));
					gameScene = new Scene(gameRoot);
					Parent startWindow = FXMLLoader.load(getClass().getResource("UIFiles/playerStart.fxml"));
					startScene = new Scene(startWindow);
				} catch (IOException e) {
					e.printStackTrace();
				}
				newStage.setScene(gameScene);
				newStage.setTitle("Game Screen");
				newStage.show();
				landPlots = (Land[][]) loadData.get(0);
				level = (String) loadData.get(1);
				players = (Player[]) loadData.get(3);
				for (Player player : players) {
					for (Land land : player.landOwned) {
						landPlots[land.getCol()][land.getRow()] = land;
					}
				}
				GridPane grid = (GridPane) gameRoot;
				int pos = 0;
				if (grid != null) {
					for (Node node : grid.getChildren()) {
						if (Objects.equals(node.getId(), "00")) {
							break;
						}
						pos++;
					}
					for (Land[] landArray : landPlots) {
						for (Land land : landArray) {
							if (land.isOwned()) {
								Player owner = land.getOwner();
								Rectangle color = new Rectangle();
								color.setFill(Color.valueOf(owner.getColor()));
								color.setHeight(25);
								color.setWidth(25);
								color.setOpacity(1);
								GridPane.setHalignment(color, HPos.LEFT);
								GridPane.setValignment(color, VPos.TOP);
								grid.add(color, land.getCol(), land.getRow());
								if (land.hasMule()) {
									Image mulePic = new Image("gameConfig/UIFiles/Media/aMule.png");
									ImageView muleView = new ImageView();
									muleView.setImage(mulePic);
									muleView.setFitWidth(50);
									muleView.setPreserveRatio(true);
									GridPane.setConstraints(muleView, land.getCol(), land.getRow(), 1, 1);
									muleView.setId(String.valueOf(land.getCol()) + String.valueOf(land.getRow()));
									grid.add(muleView, land.getCol(), land.getRow());
								}
							}
						}
					}
				}
				numPlayer = players.length;
				Turns turns = new Turns(players);
				turns.setRounds((int) loadData.get(5));
				GameController.beginTurn();
			} else {
				Controller.loaded = false;
			}
		}
	}
}
