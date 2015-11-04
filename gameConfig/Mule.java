package gameConfig;

import java.util.Random;

public class Mule {

	private static Type type;
	private Player owner;
	private int cost;
	private Land position;

	public Mule(Type t) {
		type = t;
		this.cost = 100;

		if (type == Type.FOOD) {
			this.cost += 25;
		} else if (type == Type.ENERGY) {
			this.cost += 50;
		} else if (type == Type.SMITHORE) {
			this.cost += 75;
		} else if (type == Type.CRYSTITE) {
			this.cost += 100;
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

	public static void produce(Type typeMule, LandType plotType, Player p) {
		Random randomInt = new Random();
		if (plotType.equals(LandType.RIVER)) {
			if (typeMule == Type.FOOD) {
				p.addSubFood(4);
			} else if (typeMule == Type.ENERGY) {
				p.addSubEnergy(2);
			}
		} else if (plotType.equals(LandType.PLAIN)) {
			if (typeMule == Type.FOOD) {
				p.addSubFood(2);
			} else if (typeMule == Type.ENERGY) {
				p.addSubEnergy(3);
			} else if (typeMule == Type.SMITHORE) {
				p.addSubOre(1);
			} else if (typeMule == Type.CRYSTITE) {
				p.addSubCrystite(randomInt.nextInt(5));
			}
		} else if (plotType.equals(LandType.M1)) {
			if (typeMule == Type.FOOD) {
				p.addSubFood(1);
			} else if (typeMule == Type.ENERGY) {
				p.addSubEnergy(1);
			} else if (typeMule == Type.SMITHORE) {
				p.addSubOre(2);
			} else if (typeMule == Type.CRYSTITE) {
				p.addSubCrystite(randomInt.nextInt(5));
			}
		} else if (plotType.equals(LandType.M2)) {
			if (typeMule == Type.FOOD) {
				p.addSubFood(1);
			} else if (typeMule == Type.ENERGY) {
				p.addSubEnergy(1);
			} else if (typeMule == Type.SMITHORE) {
				p.addSubOre(3);
			} else if (typeMule == Type.CRYSTITE) {
				p.addSubCrystite(randomInt.nextInt(5));
			}
		} else if (plotType.equals(LandType.M3)) {
			if (typeMule == Type.FOOD) {
				p.addSubFood(1);
			} else if (typeMule == Type.ENERGY) {
				p.addSubEnergy(1);
			} else if (typeMule == Type.SMITHORE) {
				p.addSubOre(4);
			} else if (typeMule == Type.CRYSTITE) {
				p.addSubCrystite(randomInt.nextInt(5));
			}
		}
 	}
}
