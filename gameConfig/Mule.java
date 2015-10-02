package gameConfig;

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

	public int getCost() {
		return cost;
	}

	public void setOwner(Player p) {
		owner = p;
	}

	public Player getOwner() {
		return owner;
	}

	public Type getType() {
		return type;
	}

	public void setPosition(Land p) {
		position = p;
	}

	public enum Type {
		FOOD, ENERGY, SMITHORE, CRYSTITE
	}

}
