package gameConfig;

import java.util.Random;

public class Mule {

	private static Type type;
	private Player owner;
	private int cost;
	private Land position;

	/**
	 *
	 * @param t the type of mule to set the mule to
	 */
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

	/**
	 *
	 * @return type the type of mule
	 */
	public Type getType() {
		return type;
	}

	/**
	 *
	 * @return cost the cost of the mule
	 */
	public int getCost() {
		return cost;
	}

	/**
	 *
	 * @param p the player to set the owner to
	 */
	public void setOwner(Player p) {
		owner = p;
	}

	/**
	 *
	 * @return owner the owner of the mule
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 *
	 * @param p the position to set the mule to
	 */
	public void setPosition(Land p) {
		position = p;
	}

	/**
	 *
	 * @return position the position of the land
	 */
	public Land getPosition() {
		return position;
	}

	public enum Type {
		FOOD, ENERGY, SMITHORE, CRYSTITE
	}

	/**
	 *
	 * @param typeMule the type of mule to produce
	 * @param plotType the type of land type to produce on
	 * @param p the player that owns the mule
	 */
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
