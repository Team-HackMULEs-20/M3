package gameConfig;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import java.lang.String;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;



public class RandomEvents {
	//    Map<Integer, String> re;
	//
	//    public RandomEvents() {
	//        re = new HashMap<>();
	//        re.put(1, "YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.");
	//        re.put(2, "A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.");
	//        re.put(3, "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $" + 8 * calculateM() + ".");
	//        re.put(4, "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $" + 2 * calculateM() + ".");
	//        re.put(5, "FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $" + 4 * calculateM() + ".");
	//        re.put(6, "MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.");
	//        re.put(7, "YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $" + 6 * calculateM() + " TO CLEAN IT UP.");
	//
	//    }

	//randomNum = Min + (int)(Math.random() * ((Max - Min) + 1));

	/**
	 *
	 * @param p the player to have the event occur to
	 * @return string of the event message
	 */
	public String determineRandomEvent(Player p){

		int chance = (int)(Math.random() * 100);
		if (chance <= 27) {
			if (Turns.playerTurn == 1) {
				int chooseRE = (int)(Math.random() * 4) + 1;
				if (chooseRE == 1) {
					System.out.println("YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.");
					p.addSubFood(3);
					p.addSubEnergy(2);
					return "YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.";

				} else if (chooseRE == 2) {
					System.out.println("A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.");
					p.addSubOre(2);
					return "A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.";

				} else if (chooseRE == 3) {
					int m = 8 * calculateM();
					System.out.println("THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $" + m + ".");
					p.addSubMoney(m);
					return "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $" + m + ".";

				} else if (chooseRE == 4) {
					int m = 2 * calculateM();
					System.out.println("YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $" + m + ".");
					p.addSubMoney(m);
					return "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $" + m + ".";
				}
			} else {
				int chooseRE = (int)(Math.random() * 7) + 1;
				if (chooseRE == 1) {
					System.out.println("YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.");
					p.addSubFood(3);
					p.addSubEnergy(2);
					return "YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.";

				} else if (chooseRE == 2) {
					System.out.println("A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.");
					p.addSubOre(2);
					return "A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.";

				} else if (chooseRE == 3) {
					int m = 8 * calculateM();
					System.out.println("THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $" + m + ".");
					p.addSubMoney(m);
					return "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $" + m + ".";

				} else if (chooseRE == 4) {
					int m = 2 * calculateM();
					System.out.println("YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $" + m + ".");
					p.addSubMoney(m);
					return "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $" + m + ".";

				} else if (chooseRE == 5) {
					int m = 4 * calculateM();
					System.out.println("FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $" + m + ".");
					p.addSubMoney(-m);
					return "FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $" + m + ".";

				} else if (chooseRE == 6) {
					System.out.println("MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.");
					int f = p.getFood();
					p.addSubFood(-(f/2));
					return "MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.";

				} else {
					int m = 6 * calculateM();
					System.out.println("YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $" + m + " TO CLEAN IT UP.");
					p.addSubMoney(-m);
					return "YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $" + m + " TO CLEAN IT UP.";
				}
			}
		}
			return "NVM";
	}

	/**
	 *
	 * @return m the round probability
	 */
	private static int calculateM(){
		int r = Turns.rounds;
		int m;

		if (r <= 3) { // rounds 1 - 3
			m = 25;
		} else if (r <= 7) { // rounds 4 - 7
			m = 50;
		} else if (r <= 11) { // rounds 8 - 11
			m = 75;
		} else { // round 12
			m = 100;
		}
		return m;
	}

	/**
	 *
	 * @param message the message the pass into the message box
	 */
	public static void messageBox(String message) {
		Stage errorStage = new Stage();
		errorStage.setTitle("Random Event!");
		errorStage.setAlwaysOnTop(true);
		Group t = new Group();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		Label errorLabel = new Label(message);
		errorLabel.setFont(new Font("American Typewriter", 15));
		Button errorButton = new Button("Ok");
		errorButton.setFont(new Font("American Typewriter", 17));
		GridPane grid2 = new GridPane();
		grid2.setAlignment(Pos.CENTER);
		grid2.add(errorButton, 0, 0);
		grid.add(errorLabel, 1, 0);
		grid.add(grid2, 1, 1);
		t.getChildren().add(grid);
		Scene errorScene = new Scene(t);
		errorStage.setScene(errorScene);
		errorStage.show();
		errorStage.toFront();
		errorButton.setOnAction((ActionEvent e) -> errorStage.close());

	}

}
