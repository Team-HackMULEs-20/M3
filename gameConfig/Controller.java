package gameConfig;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.net.URL;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Controller implements Initializable {

<<<<<<< HEAD
    @FXML
    private Button nextButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button nextButton2;

    @FXML
    private Button backButton;

    @FXML
    private Button townButton;

    @FXML
    private Button landOfficeButton;
    
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

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public static Integer playerNum;

    public static String name;

    public static String race;

    public static String map;

    public static String level;
    
    private static int count;

    private static Color color;

    private Stage newStage;
=======
=======
>>>>>>> origin/kfindley7
=======
>>>>>>> origin/kfindley7
    public static Integer numPlayer;
    public static String name;
    public static String race;
    public static String map;
    public static String level;
    private static int count;
    private static Color color;
    private Stage newStage;
<<<<<<< HEAD
    private Player[] players;
    private Turns gameTurns;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/kfindley7
=======
>>>>>>> origin/kfindley7
=======
>>>>>>> origin/kfindley7
=======
    private static Player[] players;
    private static Land[][] landPlots;
    private static Turns gameTurns;
>>>>>>> origin/kfindley7

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
        assert townButton != null : "fx:id=\"townButton\" was not injected: " +
                "check your FXML file 'M.U.L.E Game Setup.fxml'.";
        assert numPlayers != null : "fx:id=\"numPlayer\" was not injected: " +
                "check your FXML file 'M.U.LE Game Setup.fxml'.";
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        assert okButton != null : "fx:id=\"okButton\" was not injected: " +
                "check your FXML file 'configError.fxml'.";
    }

    @FXML
<<<<<<< HEAD:Game_Config/src/sample/Controller.java
    private void buttonClicked(ActionEvent e) throws NullPointerException {
        try {
            if (e.getSource() == nextButton) {
                playerNum = Integer.parseInt(numPlayers.getSelectionModel().getSelectedItem().toString());
                map = mapType.getSelectionModel().getSelectedItem().toString();
                level = difficulty.getSelectionModel().getSelectedItem().toString();
                Main.primaryStage.setScene(Main.nextScene);
                Main.primaryStage.setTitle("Player 1 Configuration");
                count = 1;
            } else if (e.getSource() == cancelButton) {
                Main.primaryStage.close();
            }
        } catch (NullPointerException error) {
            Main.primaryStage.setScene(Main.errorMessage);
=======
    private void buttonClicked(ActionEvent e) {
        if (e.getSource() == nextButton) {
            playerNum = Integer.parseInt(numPlayers.getSelectionModel().getSelectedItem().toString());
            Launcher.primaryStage.setScene(Launcher.nextScene);
            Launcher.primaryStage.setTitle("Player 1 Configuration");
            count = 1;
        } else if (e.getSource() == cancelButton) {
            Launcher.primaryStage.close();
>>>>>>> acollins41:gameConfig/Controller.java
        }
    }

    @FXML
<<<<<<< HEAD:Game_Config/src/sample/Controller.java
=======
=======
>>>>>>> origin/kfindley7
=======
>>>>>>> origin/kfindley7
    }

    @FXML
    private void buttonClicked(ActionEvent e) throws NullPointerException {
        try {
            if (e.getSource() == nextButton) {
                numPlayer = Integer.parseInt(numPlayers.getSelectionModel().getSelectedItem().toString());

                //initializing players array
                players = new Player[numPlayer.intValue()];
                map = mapType.getSelectionModel().getSelectedItem().toString();
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
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/kfindley7
=======
>>>>>>> origin/kfindley7
=======
>>>>>>> origin/kfindley7
    private void buttonClicked2(ActionEvent e) throws NullPointerException {
        newStage = new Stage();
        try {
            if (e.getSource() == nextButton2) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                name = playerName.getText();
                race = raceChoice.getSelectionModel().getSelectedItem().toString();
                color = colorPick.getValue();
                if (name.equals("")) {
                    Main.primaryStage.setScene(Main.errorMessage);
                }
                if (count == 1) {
                    Main.primaryStage.setTitle("Player 2 Configuration");
                    Main.primaryStage.toFront();
                    playerName.clear();
                    count = 2;
                } else if (count == 2) {
                    if (count == playerNum) {
                        Main.primaryStage.hide();
=======
=======
>>>>>>> origin/kfindley7
=======
>>>>>>> origin/kfindley7

                name = playerName.getText();
                race = raceChoice.getSelectionModel().getSelectedItem().toString();
                if (race.length() > 8) {
                    race = race.toUpperCase().substring(0, race.indexOf(" "));
                } else {
                    race = race.toUpperCase();
                }
                Player.Race r = Player.Race.valueOf(race);

                color = colorPick.getValue();

                //creating Player
                Player p = new Player(count, name, r, color);
                players[count - 1] = p;
                if (players[players.length - 1] != null) {

                    //when players array is full, begins game turns
                    gameTurns = new Turns(players);
                }

                if (name.equals("")) { // check if player entered a name
                    Launcher.primaryStage.setScene(Launcher.errorMessage);
<<<<<<< HEAD
                }
                if (count == 1) {
                    Launcher.primaryStage.setTitle("Player 2 Configuration");
                    Launcher.primaryStage.toFront();
                    playerName.clear();
                    count = 2;
                } else if (count == 2) {
                    if (count == numPlayer) {
                        Launcher.primaryStage.hide();
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/kfindley7
=======
>>>>>>> origin/kfindley7
=======
>>>>>>> origin/kfindley7
                        newStage.setScene(new Scene(new FlowPane(), 600, 400));
                        newStage.setTitle("Game Screen");
                        newStage.show();
                    } else {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                        Main.primaryStage.setTitle("Player 3 Configuration");
                        Main.primaryStage.toFront();
=======
                        Launcher.primaryStage.setTitle("Player 3 Configuration");
                        Launcher.primaryStage.toFront();
>>>>>>> origin/kfindley7
=======
                        Launcher.primaryStage.setTitle("Player 3 Configuration");
                        Launcher.primaryStage.toFront();
>>>>>>> origin/kfindley7
=======
                        Launcher.primaryStage.setTitle("Player 3 Configuration");
=======
                    Launcher.primaryStage.setTitle("Error!");
                } else {
                    if (count == 1) { // if only one player config screen has been shown go to player 2
                        Launcher.primaryStage.setTitle("Player 2 Configuration");
>>>>>>> origin/kfindley7
                        Launcher.primaryStage.toFront();
>>>>>>> origin/kfindley7
                        playerName.clear();
<<<<<<< HEAD
                    }
                    count += 1;
                } else if (count == 3) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                    if (count == playerNum) {
                        Main.primaryStage.hide();
=======
                    if (count == numPlayer) {
                        Launcher.primaryStage.hide();
>>>>>>> origin/kfindley7
=======
                    if (count == numPlayer) {
                        Launcher.primaryStage.hide();
>>>>>>> origin/kfindley7
=======
                    if (count == numPlayer) {
                        Launcher.primaryStage.hide();
>>>>>>> origin/kfindley7
                        newStage.setScene(new Scene(new FlowPane(), 600, 400));
                        newStage.setTitle("Game Screen");
                        newStage.show();
                    } else {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                        Main.primaryStage.setTitle("Player 4 Configuration");
                        Main.primaryStage.toFront();
=======
                        Launcher.primaryStage.setTitle("Player 4 Configuration");
                        Launcher.primaryStage.toFront();
>>>>>>> origin/kfindley7
=======
                        Launcher.primaryStage.setTitle("Player 4 Configuration");
                        Launcher.primaryStage.toFront();
>>>>>>> origin/kfindley7
=======
                        Launcher.primaryStage.setTitle("Player 4 Configuration");
                        Launcher.primaryStage.toFront();
>>>>>>> origin/kfindley7
                        playerName.clear();
                    }
                    count += 1;
                } else if (count == 4) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                    Main.primaryStage.hide();
                    newStage.setScene(new Scene(new FlowPane(), 600, 400));
                    newStage.setTitle("Game Screen");
                    newStage.show();
                }

            } else if (e.getSource() == backButton) {
                Main.primaryStage.setScene(Main.rootScene);
                Main.primaryStage.setTitle("M.U.L.E. Game Setup");
=======
    private void buttonClicked2(ActionEvent e) {
        Stage newStage = new Stage();
        if (e.getSource() == nextButton2) {
            if (count == 1) {
                Launcher.primaryStage.setTitle("Player 2 Configuration");
                Launcher.primaryStage.toFront();
                count = 2;
            } else if (count == 2) {
                if (count == playerNum) {
=======
>>>>>>> origin/kfindley7
=======
>>>>>>> origin/kfindley7
                    Launcher.primaryStage.hide();
                    newStage.setScene(new Scene(new FlowPane(), 600, 400));
                    newStage.setTitle("Game Screen");
                    newStage.show();
<<<<<<< HEAD
<<<<<<< HEAD
                } else {
                    Launcher.primaryStage.setTitle("Player 3 Configuration");
                    Launcher.primaryStage.toFront();
                }
                count += 1;
            } else if (count == 3) {

                if (count == playerNum) {
=======
>>>>>>> origin/kfindley7
                    Launcher.primaryStage.hide();
                    newStage.setScene(new Scene(new FlowPane(), 600, 400));
                    newStage.setTitle("Game Screen");
                    newStage.show();
<<<<<<< HEAD
                } else {
                    Launcher.primaryStage.setTitle("Player 4 Configuration");
                    Launcher.primaryStage.toFront();
                }
                count += 1;
            } else if (count == 4) {
                Launcher.primaryStage.hide();
                newStage.setScene(new Scene(new FlowPane(), 600, 400));
                newStage.setTitle("Game Screen");
                newStage.show();
>>>>>>> acollins41:gameConfig/Controller.java
            }
        } catch (NullPointerException error) {
            Main.primaryStage.setScene(Main.errorMessage);
        }
    }

<<<<<<< HEAD:Game_Config/src/sample/Controller.java
    public void errorBox(ActionEvent event) {
        if (event.getSource() == okButton) {
            Main.primaryStage.setScene(Main.rootScene);
=======
        } else if (e.getSource() == backButton) {
            Launcher.primaryStage.setScene(Launcher.rootScene);
            Launcher.primaryStage.setTitle("M.U.L.E. Game Setup");
>>>>>>> acollins41:gameConfig/Controller.java
        }
    }
}
=======
=======
>>>>>>> origin/kfindley7
=======
>>>>>>> origin/kfindley7
=======
                        count += 1;
                    } else if (count == 2) {
                        if (count == numPlayer) { // if user selected only 2 players then show game screen
                            Launcher.primaryStage.hide();
                            newStage.setScene(Launcher.gameScene);
                            newStage.setTitle("Game Screen");
                            newStage.show();
                            GameController.beginTurn();
                            //creates land array
                            landPlots = new Land[5][9];//5 rows, 9 columns, row = i, col = j
                            for (int i = 0; i < landPlots.length; i++) {
                                for (int j = 0; j < landPlots[0].length; j++) {
                                    landPlots[i][j] = new Land(i,j);
                                }
                            }
                        } else { // if user selected more than 2 players, go on to player 3 config
                            Launcher.primaryStage.setTitle("Player 3 Configuration");
                            Launcher.primaryStage.toFront();
                            playerName.clear();
                            count += 1;
                        }

                    } else if (count == 3) {
                        if (count == numPlayer) {
                            Launcher.primaryStage.hide();
                            newStage.setScene(Launcher.gameScene);
                            newStage.setTitle("Game Screen");
                            newStage.show();
                            GameController.beginTurn();
                            //creates land array
                            landPlots = new Land[5][9];//5 rows, 9 columns, row = i, col = j
                            for (int i = 0; i < landPlots.length; i++) {
                                for (int j = 0; j < landPlots[0].length; j++) {
                                    landPlots[i][j] = new Land(i,j);
                                }
                            }
                        } else {
                            Launcher.primaryStage.setTitle("Player 4 Configuration");
                            Launcher.primaryStage.toFront();
                            playerName.clear();
                            count += 1;
                        }

                    } else if (count == 4) {
                        Launcher.primaryStage.hide();
                        newStage.setScene(Launcher.gameScene);
                        newStage.setTitle("Game Screen");
                        newStage.show();
                        GameController.beginTurn();
                        //creates land array
                        landPlots = new Land[5][9];//5 rows, 9 columns, row = i, col = j
                        for (int i = 0; i < landPlots.length; i++) {
                            for (int j = 0; j < landPlots[0].length; j++) {
                                landPlots[i][j] = new Land(i,j);
                            }
                        }
                    }
>>>>>>> origin/kfindley7
                }
            } else if (e.getSource() == backButton) {
                Launcher.primaryStage.setScene(Launcher.rootScene);
                Launcher.primaryStage.setTitle("M.U.L.E. Game Setup");
            }
        } catch (NullPointerException error) {
            Launcher.primaryStage.setScene(Launcher.errorMessage);
            Launcher.primaryStage.setTitle("Error!");
        }
    }

    public void buttonClicked3(ActionEvent e) {
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
    
    public void buttonClicked4(ActionEvent e) {
    	newStage = new Stage();
    	if (e.getSource() == landOfficeButton) {
    		newStage.setScene(Launcher.landBuyIntScene);
    		newStage.setTitle(Turns.getTurn().getName());
    		newStage.show();
    	} else {
    		Stage stage = (Stage) landOfficeButton.getScene().getWindow();
    		stage.close();
    	}
    	
    }

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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
}
>>>>>>> origin/kfindley7
=======
}
>>>>>>> origin/kfindley7
=======
}
>>>>>>> origin/kfindley7
=======
=======
	@FXML
	private Button nextButton;

	@FXML
	private Button cancelButton;

	@FXML
	private Button nextButton2;

	@FXML
	private Button backButton;

	@FXML
	private Button townButton;

	@FXML
	private Button landOfficeButton;

	@FXML
	private Button landBuyButton;

	@FXML
	private Button passButton;

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
	public static String name;
	public static String race;
	public static String map;
	public static String level;
	private static int count;
	private static Color color;
	private Stage newStage;
	private static Player[] players;
	private static Land[][] landPlots;
	private static Turns gameTurns;
	//private boolean landBuyEnable = false;

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
		assert townButton != null : "fx:id=\"townButton\" was not injected: " +
				"check your FXML file 'M.U.L.E Game Setup.fxml'.";
		assert numPlayers != null : "fx:id=\"numPlayer\" was not injected: " +
				"check your FXML file 'M.U.LE Game Setup.fxml'.";
	}

	@FXML
	private void buttonClicked(ActionEvent e) throws NullPointerException {
		try {
			if (e.getSource() == nextButton) {
				numPlayer = Integer.parseInt(numPlayers.getSelectionModel().getSelectedItem().toString());

				//initializing players array
				players = new Player[numPlayer.intValue()];
				map = mapType.getSelectionModel().getSelectedItem().toString();
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
	private void buttonClicked2(ActionEvent e) throws NullPointerException {
		newStage = new Stage();
		try {
			if (e.getSource() == nextButton2) {

				name = playerName.getText();
				race = raceChoice.getSelectionModel().getSelectedItem().toString();
				if (race.length() > 8) {
					race = race.toUpperCase().substring(0, race.indexOf(" "));
				} else {
					race = race.toUpperCase();
				}
				Player.Race r = Player.Race.valueOf(race);

				color = colorPick.getValue();

				//creating Player
				Player p = new Player(count, name, r, color);
				players[count - 1] = p;
				if (players[players.length - 1] != null) {

					//when players array is full, begins game turns
					gameTurns = new Turns(players);
				}

				if (name.equals("")) { // check if player entered a name
					Launcher.primaryStage.setScene(Launcher.errorMessage);
					Launcher.primaryStage.setTitle("Error!");
				} else {
					if (count == 1) { // if only one player config screen has been shown go to player 2
						Launcher.primaryStage.setTitle("Player 2 Configuration");
						Launcher.primaryStage.toFront();
						playerName.clear();
						count += 1;
					} else if (count == 2) {
						if (count == numPlayer) { // if user selected only 2 players then show game screen
							Launcher.primaryStage.hide();
							newStage.setScene(Launcher.gameScene);
							newStage.setTitle("Game Screen");
							newStage.show();
							GameController.beginTurn();
							//creates land array
							landPlots = new Land[5][9];//5 rows, 9 columns, row = i, col = j
							for (int i = 0; i < landPlots.length; i++) {
								for (int j = 0; j < landPlots[0].length; j++) {
									landPlots[i][j] = new Land(i,j);
								}
							}
						} else { // if user selected more than 2 players, go on to player 3 config
							Launcher.primaryStage.setTitle("Player 3 Configuration");
							Launcher.primaryStage.toFront();
							playerName.clear();
							count += 1;
						}

					} else if (count == 3) {
						if (count == numPlayer) {
							Launcher.primaryStage.hide();
							newStage.setScene(Launcher.gameScene);
							newStage.setTitle("Game Screen");
							newStage.show();
							GameController.beginTurn();
							//creates land array
							landPlots = new Land[5][9];//5 rows, 9 columns, row = i, col = j
							for (int i = 0; i < landPlots.length; i++) {
								for (int j = 0; j < landPlots[0].length; j++) {
									landPlots[i][j] = new Land(i,j);
								}
							}
						} else {
							Launcher.primaryStage.setTitle("Player 4 Configuration");
							Launcher.primaryStage.toFront();
							playerName.clear();
							count += 1;
						}

					} else if (count == 4) {
						Launcher.primaryStage.hide();
						newStage.setScene(Launcher.gameScene);
						newStage.setTitle("Game Screen");
						newStage.show();
						GameController.beginTurn();
						//creates land array
						landPlots = new Land[5][9];//5 rows, 9 columns, row = i, col = j
						for (int i = 0; i < landPlots.length; i++) {
							for (int j = 0; j < landPlots[0].length; j++) {
								landPlots[i][j] = new Land(i,j);
							}
						}
					}
				}
			} else if (e.getSource() == backButton) {
				Launcher.primaryStage.setScene(Launcher.rootScene);
				Launcher.primaryStage.setTitle("M.U.L.E. Game Setup");
			}
		} catch (NullPointerException error) {
			Launcher.primaryStage.setScene(Launcher.errorMessage);
			Launcher.primaryStage.setTitle("Error!");
		}
	}

	public void buttonClicked3(ActionEvent e) {
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

	public void buttonClicked4(ActionEvent e) {
		newStage = new Stage();
		if (e.getSource() == landOfficeButton) {
			newStage.setScene(Launcher.landBuyIntScene);
			newStage.setTitle(Turns.getTurn().getName());
			newStage.show();
		}
		Stage stage = (Stage) landOfficeButton.getScene().getWindow();
		stage.close();
	}

	public void buttonClicked5(ActionEvent e) {
		if (e.getSource() == landBuyButton) {
			if (Turns.getTurn().getLandGrants() > 0 || Turns.getTurn().getMoney() > 300)//make sure player can buy land
				Land.landBuyEnable = true;
			Stage stage = (Stage) landBuyButton.getScene().getWindow();
			stage.close();
		} else if (e.getSource() == passButton) {
			Stage stage = (Stage) passButton.getScene().getWindow();
			stage.close();
			Timer.endTurn();
		}
	}

	public void landButtonClicked(ActionEvent e) {
		if (Land.landBuyEnable) {
			Player currentP = Turns.getTurn();
			if (currentP.landGrants > 0)//check for land grants
				currentP.landGrants--;
			else//if not grants sub money
				currentP.addSubMoney(-300);
			Node landButton = (Node) e.getSource();
			GridPane grid = (GridPane) landButton.getParent();
			ColorPicker color =  new ColorPicker();//setting up the color picker
			color.setValue(currentP.getColor());
			color.setStyle("-fx-color-label-visible: false ;");
			color.setMaxSize(25, 25);
			color.setDisable(true);
			color.setOpacity(1);
			grid.add(color, GridPane.getColumnIndex(landButton), GridPane.getRowIndex(landButton));
			GridPane.setHalignment(color, HPos.LEFT);
			GridPane.setValignment(color, VPos.TOP);
			landButton.setDisable(true);//disable the land button since land is purchased
			Land.landBuyEnable = false;//disable land buying for next turn

			Timer.endTurn();
		}
	}

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
>>>>>>> master
}
>>>>>>> master
