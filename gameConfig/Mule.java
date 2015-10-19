package gameConfig;

import java.util.Random;

public class Mule {

	public static Type type;
	private Player owner;
	private int cost;
	private Land position;

	public Mule(Type t) {
		type = t;
		cost = 100;

		if (type == Type.FOOD) {
			cost += 25;
		} else if (type == Type.ENERGY) {
			cost += 50;
		} else if (type == Type.SMITHORE) {
			cost += 75;
		} else if (type == Type.CRYSTITE) {
			cost += 100;
		}

	}

	public Type getType() {
		return type;
	}

	public int getCost() {
		return cost;
	}

	public void setOwner(Player p) {
		owner = p;
	}

	public Player getOwner() {
		return owner;
	}

	public void setPosition(Land p) {
		position = p;
	}

	public Land getPosition() {
		return position;
	}

	public enum Type {
		FOOD, ENERGY, SMITHORE, CRYSTITE
	}

	public static void produce(Type typeMule, LandType plotType) {
		Player p = Turns.getTurn();
		Random randomInt = new Random();
		if (plotType == LandType.RIVER) {
			if (typeMule == Type.FOOD) {
				p.addSubFood(4);
			} else if (typeMule == Type.ENERGY) {
				p.addSubEnergy(2);
			}
		} else if (plotType == LandType.PLAIN) {
			if (typeMule == Type.FOOD) {
				p.addSubFood(2);
			} else if (typeMule == Type.ENERGY) {
				p.addSubEnergy(3);
			} else if (typeMule == Type.SMITHORE) {
				p.addSubOre(1);
			} else {
				p.addSubCrystite(randomInt.nextInt(5));
			}
		} else if (plotType == LandType.M1) {
			if (typeMule == Type.FOOD) {
				p.addSubFood(1);
			} else if (typeMule == Type.ENERGY) {
				p.addSubEnergy(1);
			} else if (typeMule == Type.SMITHORE) {
				p.addSubOre(2);
			} else {
				p.addSubCrystite(randomInt.nextInt(5));
			}
		} else if (plotType == LandType.M2) {
			if (typeMule == Type.FOOD) {
				p.addSubFood(1);
			} else if (typeMule == Type.ENERGY) {
				p.addSubEnergy(1);
			} else if (typeMule == Type.SMITHORE) {
				p.addSubOre(3);
			} else {
				p.addSubCrystite(randomInt.nextInt(5));
			}
		} else if (plotType == LandType.M3) {
			if (typeMule == Type.FOOD) {
				p.addSubFood(1);
			} else if (typeMule == Type.ENERGY) {
				p.addSubEnergy(1);
			} else if (typeMule == Type.SMITHORE) {
				p.addSubOre(4);
			} else {
				p.addSubCrystite(randomInt.nextInt(5));
			}
		}
 	}
}
