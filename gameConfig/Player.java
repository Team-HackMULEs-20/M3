package gameConfig;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {

	private final String name;
	private final Race race;
	private final String color;

	private int money;
	private int food;
	private int energy;
	private int ore;
	private int crystite;

	public int landGrants;
	public final ArrayList<Land> landOwned;
	public final ArrayList<Mule> mulesOwned;

	public Player (String name, Race race, String color) {
		//this.number = number;
		this.name = name;
		this.race = race;
		this.color = color;
		landOwned = new ArrayList<>();
		mulesOwned = new ArrayList<>();
		landGrants = 2;

		if (Controller.level.equals("Beginner")){
			food = 8;
			energy = 4;
		} else {
			food = 4;
			energy = 2;
		}

		if (this.race.equals(Race.FLAPPER)) {
			money = 1600;
		} else if (this.race.equals(Race.HUMAN)) {
			money = 600;
		} else {
			money = 1000;
		}

		ore = 0;
		crystite = 0;
	}

	public enum Race {
		FLAPPER, BONZOID, UGAITE, BUZZITE, HUMAN
	}

	public String getName() {return name;}
	public Race getRace() {return race;}
	public int getLandGrants() {return landGrants;}


	public String getColor() {return color;}

	public int getScore() { //TODO score
		return money + (500 * landOwned.size()) + (30 * food) + (25 * energy) + (50 * ore);
	}

	public int getMoney() {return money;}
	public void addSubMoney(int amount) {money += amount;}

	public int getFood() {return food;}
	public void addSubFood(int amount) {food += amount;}

	public int getEnergy() {return energy;}
	public void addSubEnergy(int amount) {energy += amount;}

	public int getOre() {return ore;}
	public void addSubOre(int amount) {ore += amount;}

	public int getCrystite() {return crystite;}
	public void addSubCrystite(int amount) {crystite += amount;}

	public int gamble(int timeLeft) {
		int r = Turns.rounds;

		int rb; // round bonus
		if (r <= 3) { // rounds 1 - 3
			rb = 50;
		} else if (r <= 7) { // rounds 4 - 7
			rb = 100;
		} else if (r <= 11) { // rounds 8 - 11
			rb = 150;
		} else { // round 12
			rb = 200;
		}

		int tb; //time bonus
		if (timeLeft < 12) { // time left = 0-11 seconds
			tb = 50;
		} else if (timeLeft < 25) { // time left = 12-24 seconds
			tb = 100;
		} else if (timeLeft < 37) { // time left = 25-36 seconds
			tb = 150;
		} else { // time left = 37-50 seconds
			tb = 200;
		}

		//money bonus = round bonus * random(0 to timeBonus)
		//randomNum = Min + (int)(Math.random() * ((Max - Min) + 1));
		int mb = rb * ((int)(Math.random() * (tb+1))); //money bonus
		if (mb > 250) {
			mb = 250;
		}
		money += mb;
		return mb;
	}

	public boolean buyMule(boolean buy, Mule mule, Land land) {
		//Land landPlot = Controller.landPlots[land.getCol()][land.getRow()];
		if (buy) {
			if (money >= mule.getCost()) {//check that player has enough money
				money = money - mule.getCost();//player pays for the mule
				mule.setOwner(this);//player owns the mule
				if (this.equals(land.getOwner())) {//check to see if valid land
					if (!land.hasMule()) {//if there isn't a mule already on the land
						mule.setPosition(land);//mule is placed on the land
						StoreController.store.muleQuantity--;
						this.mulesOwned.add(mule);//player owns mule
						land.setMuleType(mule.getType());
						land.setHasMule(true);
						GameController.currentMuleType = StoreController.potentialMule.getType();
						System.out.println("mule placed.");
						land.setMuleBuyEnable(false);
						return true;
					} else {//if the land already has a mule, mule is lost
						GameController.errorMessageBox("There is already a mule on this land. You have lost your mule.");
					}
				} else {//if player doesn't own the land, mule is lost
					GameController.errorMessageBox("You do not own this land. You have lost your mule.");
				}
			} else {//if not enough money, nothing happens
				GameController.errorMessageBox("You do not have enough money.");
			}
			return false;
		} else {
			if (this.equals(land.getOwner())) {
				StoreController.store.muleQuantity++;
				land.getOwner().addSubMoney(StoreController.store.getMuleCost() - 15);
				land.setHasMule(false);
				land.setMuleType(null);
				land.setMuleBuyEnable(true);
				return false;
			} else {
				land.setMuleBuyEnable(false);
				GameController.errorMessageBox("There is not mule on this land.");
				return true;
			}
		}
	}


}
